package lt.pavilonis.classroommonitor.service;

import lt.pavilonis.classroommonitor.ui.MainView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

final class TestDataProvider {

   ClassroomOccupancy[] load() {

      Set<Integer> classroomNames = new HashSet<>(MainView.GRID_SIZE);
      while (classroomNames.size() < MainView.GRID_SIZE) {
         classroomNames.add(randomInt(100, 200));
      }

      return classroomNames.stream()
            .map(number -> new ClassroomOccupancy(randomLocalDateTime(), randomBoolean(), number))
            .toArray(ClassroomOccupancy[]::new);
   }

   private LocalDateTime randomLocalDateTime() {
      LocalDate start = LocalDate.of(1970, Month.JANUARY, 1);
      long days = ChronoUnit.DAYS.between(start, LocalDate.now());
      LocalDate randomDate = start.plusDays(new Random().nextInt((int) days + 1));
      LocalTime randomTime = LocalTime.MIN.plusMinutes(randomInt(480, 1250));
      return randomDate.atTime(randomTime);
   }

   private boolean randomBoolean() {
      return randomInt(1, 3) == 1;
   }

   public int randomInt(int min, int max) {
      Random random = new Random();
      return random.nextInt(max - min) + min;
   }
}
