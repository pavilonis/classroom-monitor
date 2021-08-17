package lt.pavilonis.classroommonitor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.function.DoubleConsumer;

@Service
public class PeriodicalRunner {

   private static final Logger LOGGER = LoggerFactory.getLogger(PeriodicalRunner.class);
   private static final int INTERVAL_MIN = 1000;
   private static final int COUNTER_STEP = 50;
   private final int offsetPositive;
   private final int offsetNegative;
   private final int updateInterval;
   private int counter;
   private Runnable updateTask;
   private DoubleConsumer progressConsumer;

   public PeriodicalRunner(@Value("${api.request.interval}") int updateInterval) {
      this.updateInterval = updateInterval;
      if (updateInterval < INTERVAL_MIN) {
         LOGGER.error("Update interval is too small. Should be more than {}", INTERVAL_MIN);
         throw new IllegalArgumentException("Update interval is too small");
      }

      this.offsetPositive = updateInterval + COUNTER_STEP * 2;
      this.offsetNegative = updateInterval - COUNTER_STEP * 2;
   }

   @Scheduled(fixedRate = COUNTER_STEP)
   public void count() {

      if (progressConsumer == null || updateTask == null) {
         return;
      }

      counter += COUNTER_STEP;

      if (counter > offsetNegative && counter < offsetPositive) {
         updateTask.run();
         counter = 0;

      } else {
         double progress = counter / (double) updateInterval;
         progressConsumer.accept(progress);
      }
   }

   public void setUpdateTask(Runnable task) {
      this.updateTask = task;
   }

   public void setProgressConsumer(DoubleConsumer progressConsumer) {
      this.progressConsumer = progressConsumer;
   }
}
