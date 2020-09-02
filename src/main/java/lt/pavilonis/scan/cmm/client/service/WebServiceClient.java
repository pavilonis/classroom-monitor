package lt.pavilonis.scan.cmm.client.service;

import javafx.application.Platform;
import lt.pavilonis.scan.cmm.client.App;
import lt.pavilonis.scan.cmm.client.util.TimeUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Consumer;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class WebServiceClient {

   private static final Logger LOGGER = getLogger(WebServiceClient.class.getSimpleName());
   private final String uri;
   private final int level;
   private final String building;
   private final boolean isMockWebService;
   private final RestTemplate restTemplate;
   private String lastErrorMessage;

   public WebServiceClient(@Value("${api.uri}") String uri,
                           @Value("${api.level}") int level,
                           @Value("${api.building:SCHOOL}") String building,
                           @Value("${api.mock:false}") boolean isMockWebService,
                           RestTemplate restTemplate) {
      this.uri = uri;
      this.level = level;
      this.building = building;
      this.isMockWebService = isMockWebService;
      this.restTemplate = restTemplate;
   }

   public void load(Consumer<Optional<ClassroomOccupancy[]>> consumer) {
      new BackgroundTask<>(() -> {
         LocalDateTime opStart = LocalDateTime.now();
         ResponseEntity<ClassroomOccupancy[]> response = tryRequest(uri);

         Optional<ClassroomOccupancy[]> result = Optional.ofNullable(response)
               .map(HttpEntity::getBody);

         if (result.isPresent()) {
            LOGGER.info("Request completed [t={}, entries={}]", TimeUtils.duration(opStart), result.get().length);
         } else {
            LOGGER.error("Request failed [t={}, message={}]", TimeUtils.duration(opStart), lastErrorMessage);
         }
         App.clearWarning();
         Platform.runLater(() -> consumer.accept(result));
      });
   }

   private ResponseEntity<ClassroomOccupancy[]> tryRequest(String url) {
      this.lastErrorMessage = null;
      try {
         return isMockWebService
               ? new ResponseEntity<>(new WebServiceMock().load(), HttpStatus.OK)
               : request(url);

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
         LOGGER.error(this.lastErrorMessage);

      } catch (ResourceAccessException e) {
         this.lastErrorMessage = e.getCause() == null ? e.getMessage() : e.getCause().getMessage();
         LOGGER.error(this.lastErrorMessage);

      } catch (Exception e) {
         e.printStackTrace();
         this.lastErrorMessage = e.getMessage();
         LOGGER.error(this.lastErrorMessage);
      }
      return null;
   }

   private ResponseEntity<ClassroomOccupancy[]> request(String url) {
      URI requestUri = UriComponentsBuilder.fromUriString(url)
            .queryParam("level", level)
            .queryParam("building", building)
            .build()
            .toUri();

      LOGGER.info("Making request [uri={}]", requestUri);
      return restTemplate.exchange(requestUri, HttpMethod.GET, null, ClassroomOccupancy[].class);
   }

   public Optional<String> getLastErrorMessage() {
      return Optional.ofNullable(lastErrorMessage);
   }
}
