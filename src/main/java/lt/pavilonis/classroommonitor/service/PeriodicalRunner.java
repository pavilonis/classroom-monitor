package lt.pavilonis.classroommonitor.service;

import javafx.application.Platform;
import lombok.extern.slf4j.Slf4j;
import lt.pavilonis.classroommonitor.ui.Footer;
import lt.pavilonis.classroommonitor.ui.MainView;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PeriodicalRunner {

   private static final int INTERVAL_MIN = 1000;
   private static final int COUNTER_STEP = 50;
   private final SoapClient soapClient;
   private final MainView view;
   private final Footer footer;
   private final int offsetPositive;
   private final int offsetNegative;
   private final int updateInterval;
   private int counter;
   private boolean busy;

   public PeriodicalRunner(@Value("${api.request.interval}000") int updateInterval,
                           SoapClient soapClient,
                           MainView view,
                           Footer footer) {
      this.soapClient = soapClient;
      this.view = view;
      this.footer = footer;
      this.updateInterval = updateInterval;
      if (updateInterval < INTERVAL_MIN) {
         log.error("Update interval is too small. Should be more than {}", INTERVAL_MIN);
         throw new IllegalArgumentException("Update interval is too small");
      }

      this.offsetPositive = updateInterval + COUNTER_STEP * 2;
      this.offsetNegative = updateInterval - COUNTER_STEP * 2;
   }

   @Scheduled(fixedRate = COUNTER_STEP)
   public void count() {

      counter += COUNTER_STEP;

      if (counter > offsetNegative && counter < offsetPositive) {
         updateView();
         counter = 0;

      } else {
         double progress = counter / (double) updateInterval;
         footer.updateProgressValue(progress);
      }
   }

   public void updateView() {
      if (busy) {
         log.debug("Skipping update: busy");
         return;
      }
      busy = true;
      Platform.runLater(view::clearWarnings);

      try {
         List<ClassroomOccupancy> doors = soapClient.fetchDoors();
         Platform.runLater(() -> view.regularUpdate(doors));

      } catch (Exception e) {
         Platform.runLater(() -> view.displayWarning(e));

      } finally {
         busy = false;
         Platform.runLater(() -> footer.updateProgressValue(0));
      }
   }
}
