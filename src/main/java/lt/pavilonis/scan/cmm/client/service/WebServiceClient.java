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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class WebServiceClient {
   private static final Logger LOG = getLogger(WebServiceClient.class.getSimpleName());
   private static final String SEGMENT_CLASSROOMS = "classrooms";

   @Value(("${api.uri.base}"))
   private String baseUri;

   @Value(("${api.mock:false}"))
   private boolean webServiceMock;

   @Autowired
   private RestTemplate restTemplate;

   private String lastErrorMessage;

   public void load(Consumer<Optional<ClassroomOccupancy[]>> consumer) {
      request(uri(SEGMENT_CLASSROOMS), consumer);
   }

   public Optional<String> getLastErrorMessage() {
      return Optional.ofNullable(lastErrorMessage);
   }

   private URI uri(String... segments) {
      return uri(Collections.emptyMap(), segments);
   }

   private URI uri(Map<String, String> params, String... segments) {
      LinkedMultiValueMap<String, String> paramMultiMap = new LinkedMultiValueMap<>();
      params.forEach(paramMultiMap::add);

      return UriComponentsBuilder.fromUriString(baseUri)
            .pathSegment(segments)
            .queryParams(paramMultiMap)
            .build()
            .toUri();
   }

   public void request(URI uri, Consumer<Optional<ClassroomOccupancy[]>> consumer) {
      new BackgroundTask<>(() -> {
         LocalDateTime opStart = LocalDateTime.now();
         ResponseEntity<ClassroomOccupancy[]> exchange = tryRequest(uri);
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

   private ResponseEntity<ClassroomOccupancy[]> tryRequest(URI uri) {
      try {

         ResponseEntity<ClassroomOccupancy[]> response = webServiceMock

               ? new ResponseEntity<>(new WebServiceMock().load(), HttpStatus.OK)

               : restTemplate.exchange(uri, HttpMethod.GET, null, ClassroomOccupancy[].class);

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
}
