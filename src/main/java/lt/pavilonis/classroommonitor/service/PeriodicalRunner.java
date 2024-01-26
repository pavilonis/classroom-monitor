package lt.pavilonis.classroommonitor.service;

import javafx.application.Platform;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lt.pavilonis.classroommonitor.dto.ClassroomOccupancy;
import lt.pavilonis.classroommonitor.ui.Footer;
import lt.pavilonis.classroommonitor.ui.MainView;
import org.springframework.beans.factory.annotation.Value;
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

   private static final double INITIAL_PROGRESS_PERCENT = 0.15;
   private final DoorsService doorsService;
   private final MainView view;
   private final Footer footer;
   private Instant updateFinished = Instant.now();

   @Value("${api.request.interval}")
   private int updateDelay;

   @Scheduled(fixedDelayString = "${api.request.interval}", timeUnit = TimeUnit.SECONDS, initialDelay = 1)
   public void refreshView() {
      if (updateFinished == null) {
         // This "if" should never be true
         log.debug("Skipping update: busy");
         return;
      }

      updateFinished = null;
      log.info("Periodic door fetch: STARTING");
      footer.updateProgress(INITIAL_PROGRESS_PERCENT, true);
      Platform.runLater(view::clearWarnings);

      try {

         displayDoors();

      } catch (Exception e) {
         Platform.runLater(() -> view.displayWarning(e));

      } finally {
         updateFinished = Instant.now();
         log.info("Periodic door fetch: FINISHED");
      }
   }

   @Scheduled(cron = "${api.request.status-update.cron:-}")
   public void requestDoorsStatusUpdate() {
      if (updateFinished == null) {
         // This "if" should never be true
         log.debug("Skipping update: busy");
         return;
      }

      updateFinished = null;
      log.info("Periodic door status update request: STARTING");
      Platform.runLater(view::clearWarnings);

      try {

         doorsService.updateStatuses(progress -> footer.updateProgress(progress, true));

      } catch (Exception e) {
         Platform.runLater(() -> view.displayWarning(e));

      } finally {
         updateFinished = Instant.now();
         log.info("Periodic door status update request: FINISHED");
      }
   }



   private void displayDoors() {
      List<ClassroomOccupancy> doors = doorsService.fetchDoors();
      if (doors.isEmpty()) {
         throw new IllegalStateException("Empty doors response");
      }

      Platform.runLater(() -> view.update(doors));
   }

   @Scheduled(fixedRate = 100)
   public void updatePauseProgress() {
      final Instant lastUpdate = updateFinished;
      if (lastUpdate == null) {
         return;
      }

      long millisDiff = Duration.between(lastUpdate, Instant.now()).toMillis();
      int updateDelayMillis = updateDelay * 1_000;
      double progress = millisDiff / (double) updateDelayMillis;
      footer.updateProgress(progress, false);
   }
}
