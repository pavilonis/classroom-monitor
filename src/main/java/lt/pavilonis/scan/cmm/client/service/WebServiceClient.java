package lt.pavilonis.scan.cmm.client.service;

import javafx.application.Platform;
import lt.pavilonis.scan.cmm.client.App;
import lt.pavilonis.scan.cmm.client.representation.ClassroomOccupancy;
import lt.pavilonis.util.TimeUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Consumer;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class WebServiceClient {
   private static final Logger LOG = getLogger(WebServiceClient.class.getSimpleName());

   @Value(("${api.uri}"))
   private String uri;

   @Value(("${api.mock:false}"))
   private boolean isMockWebService;

   @Autowired
   private RestTemplate restTemplate;

   private String lastErrorMessage;

   public void load(Consumer<Optional<ClassroomOccupancy[]>> consumer) {
      request(uri, consumer);
   }

   private void request(String url, Consumer<Optional<ClassroomOccupancy[]>> consumer) {
      new BackgroundTask<>(() -> {
         LocalDateTime opStart = LocalDateTime.now();
         ResponseEntity<ClassroomOccupancy[]> exchange = tryRequest(url);

         Optional<ClassroomOccupancy[]> result =
               Optional.ofNullable(exchange == null ? null : exchange.getBody());

         if (result.isPresent()) {
            LOG.info("Request completed [duration={}, entries={}]",
                  TimeUtils.duration(opStart), result.get().length);
         } else {
            LOG.error("Request failed [duration={}, message={}]",
                  TimeUtils.duration(opStart), lastErrorMessage);
         }
         App.clearWarning();
         Platform.runLater(() -> consumer.accept(result));
      });
   }

   private ResponseEntity<ClassroomOccupancy[]> tryRequest(String url) {
      try {

         LOG.info("Making request [url={}, isMock={}]", url, isMockWebService);

         ResponseEntity<ClassroomOccupancy[]> response = isMockWebService

               ? new ResponseEntity<>(new WebServiceMock().load(), HttpStatus.OK)

               : restTemplate.exchange(url, HttpMethod.GET, null, ClassroomOccupancy[].class);

         this.lastErrorMessage = null;
         return response;
      } catch (HttpClientErrorException httpErr) {

         switch (httpErr.getStatusCode()) {
            case NOT_FOUND:
               this.lastErrorMessage = "Resource not found";
               break;
            case CONFLICT:
               this.lastErrorMessage = "Request conflict";
               break;
            default:
               this.lastErrorMessage = httpErr.getMessage();
         }
         LOG.error(this.lastErrorMessage);

      } catch (ResourceAccessException e) {
         this.lastErrorMessage = e.getCause() == null ? e.getMessage() : e.getCause().getMessage();
         LOG.error(this.lastErrorMessage);
      } catch (Exception e) {
         e.printStackTrace();
         this.lastErrorMessage = e.getMessage();
         LOG.error(this.lastErrorMessage);
      }
      return null;
   }

   public Optional<String> getLastErrorMessage() {
      return Optional.ofNullable(lastErrorMessage);
   }
}
