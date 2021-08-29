package lt.pavilonis.classroommonitor.service;

import javafx.application.Platform;
import javafx.concurrent.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import static java.time.LocalDateTime.now;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class WebServiceClient {

   private static final Logger LOGGER = LoggerFactory.getLogger(WebServiceClient.class);
   private final String uri;
   private final Set<String> levels;
   private final String building;
   private final boolean testMode;
   private final RestTemplate restTemplate;

   public WebServiceClient(@Value("${api.uri}") String uri,
                           @Value("${api.levels}") String[] levels,
                           @Value("${api.building}") String building,
                           @Value("api.auth.username") String username,
                           @Value("api.auth.password") String password,
                           @Value("${api.test-mode}") boolean testMode) {
      this.uri = uri;
      this.levels = Set.of(levels);
      this.building = building;
      this.testMode = testMode;
      this.restTemplate = createRestTemplate(username, password);
   }

   public void load(Consumer<ClassroomOccupancy[]> successConsumer, Consumer<Exception> exceptionConsumer) {
      runInBackground(() -> {
         var start = now();

         try {
            ClassroomOccupancy[] response = testMode
                  ? new TestDataProvider().load()
                  : request(uri);

            LOGGER.info("Request completed [t={}, entries={}]", TimeUtils.duration(start), response.length);
            Platform.runLater(() -> successConsumer.accept(response));

         } catch (Exception e) {
            LOGGER.error("Failed to get REST service response", e);
            Platform.runLater(() -> exceptionConsumer.accept(e));
         }
      });
   }

   private ClassroomOccupancy[] request(String url) {
      URI requestUri = UriComponentsBuilder.fromUriString(url)
            .queryParam("levels", levels)
            .queryParam("building", building)
            .build()
            .toUri();

      LOGGER.info("Making request [uri={}]", requestUri);
      ResponseEntity<ClassroomOccupancy[]> response = restTemplate.getForEntity(requestUri, ClassroomOccupancy[].class);

      if (response.getStatusCode().is2xxSuccessful()) {
         return response.getBody();
      }

      throw new HttpStatusCodeException(response.getStatusCode()) {
      };
   }

   public RestTemplate createRestTemplate(String username, String password) {
      var rest = new RestTemplate();
      rest.setMessageConverters(List.of(new MappingJackson2HttpMessageConverter()));
      rest.setInterceptors(List.of((request, body, execution) -> {
         HttpHeaders headers = request.getHeaders();
         headers.setBasicAuth(username, password);
         headers.setAccept(Collections.singletonList(APPLICATION_JSON));
         return execution.execute(request, body);
      }));
      return rest;
   }

   private void runInBackground(Runnable action) {
      new javafx.concurrent.Service<Boolean>() {
         @Override
         protected Task<Boolean> createTask() {
            return new Task<>() {
               @Override
               protected Boolean call() {
                  action.run();
                  return true;
               }
            };
         }
      }.start();
   }
}
