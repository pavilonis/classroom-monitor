package lt.pavilonis.scan.cmm.client.service;

import javafx.application.Platform;
import lt.pavilonis.scan.cmm.client.App;
import lt.pavilonis.scan.cmm.client.representation.ClassroomOccupancy;
import lt.pavilonis.util.TimeUtils;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class WsRestClient {
   private static final Logger LOG = getLogger(WsRestClient.class.getSimpleName());
   private static final String SEGMENT_CLASSROOMS = "classrooms";

   @Value(("${api.uri.base}"))
   private String baseUri;

   @Value(("${scanner.id}"))
   private String scannerId;

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
         LOG.info("Request completed [duration={}]", TimeUtils.duration(opStart));
         App.clearWarning();
         Platform.runLater(() -> consumer.accept(Optional.ofNullable(exchange == null ? null : exchange.getBody())));
      });
   }

   private ResponseEntity<ClassroomOccupancy[]> tryRequest(URI uri) {
      try {
//         ResponseEntity<ClassroomOccupancy[]> response = restTemplate.exchange(uri, HttpMethod.GET, null, ClassroomOccupancy[].class);
         ResponseEntity<ClassroomOccupancy[]> response = mockServiceCall();



         this.lastErrorMessage = null;
         return response;
      } catch (HttpClientErrorException httpErr) {

         switch (httpErr.getStatusCode()) {
            case NOT_FOUND:
               this.lastErrorMessage = "resourceNotFound";
               break;
            case CONFLICT:
               this.lastErrorMessage = "requestConflict";
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

   private ResponseEntity<ClassroomOccupancy[]> mockServiceCall() {
      ClassroomOccupancy[] array = new ClassroomOccupancy[22];

      for (int i = 0; i < 22; i++) {
         array[i] = new ClassroomOccupancy(randomLocalDateTime(), randomBoolean(), randomInt());
      }

      return new ResponseEntity<>(array, HttpStatus.OK);
   }

   public LocalDateTime randomLocalDateTime() {
      LocalDate start = LocalDate.of(1970, Month.JANUARY, 1);
      long days = ChronoUnit.DAYS.between(start, LocalDate.now());
      LocalDate randomDate = start.plusDays(new Random().nextInt((int) days + 1));
      return randomDate.atTime(LocalTime.now());
   }

   public boolean randomBoolean() {
      return RandomUtils.nextInt(1, 3) == 1;
   }

   public int randomInt() {
      return RandomUtils.nextInt(100, 200);
   }
}
