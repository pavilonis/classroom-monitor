package lt.pavilonis.classroommonitor.service;

import javafx.application.Platform;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lt.pavilonis.classroommonitor.ui.Footer;
import lt.pavilonis.classroommonitor.ui.MainView;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
@Service
public class PeriodicalRunner {

   private final SoapClient soapClient;
   private final MainView view;
   private final Footer footer;
   private Instant updateStartTime;
   private boolean busy;

   @Value("${api.request.interval}")
   private int dataUpdateInterval;

   @Async
   @Scheduled(fixedRateString = "${api.request.interval}", timeUnit = TimeUnit.SECONDS)
   public void updateData() {
      if (busy) {
         log.debug("Skipping update: busy");
         return;
      }

      busy = true;
      updateStartTime = Instant.now();
      Platform.runLater(view::clearWarnings);

      try {
         List<ClassroomOccupancy> doors = soapClient.fetchDoors();
         Platform.runLater(() -> view.update(doors));

      } catch (Exception e) {
         Platform.runLater(() -> view.displayWarning(e));

      } finally {
         busy = false;
      }
   }

   @Scheduled(fixedRate = 100)
   public void updateProgressBar() {
      if (updateStartTime == null) {
         return;
      }

      long millisDiff = Duration.between(updateStartTime, Instant.now()).toMillis();
      int updateIntervalMillis = dataUpdateInterval * 1_000;
      double progress = millisDiff / (double) updateIntervalMillis;
      footer.updateProgressValue(progress, busy);
   }
}
