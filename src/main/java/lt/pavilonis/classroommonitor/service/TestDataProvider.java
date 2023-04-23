package lt.pavilonis.classroommonitor.service;

import lt.pavilonis.classroommonitor.ui.MainView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static lt.pavilonis.classroommonitor.util.NumberUtils.extractNumber;

final class TestDataProvider {

   private static final Random RANDOM = new Random();

   List<ClassroomOccupancy> load() {
      Set<Integer> classroomNames = new HashSet<>(MainView.GRID_SIZE);
      while (classroomNames.size() < MainView.GRID_SIZE) {
         classroomNames.add(randomInt(100, 200));
      }

      return classroomNames.stream()
            .map(number -> new ClassroomOccupancy(extractNumber(number + " sample text"), randomBoolean(), randomLocalDateTime()))
            .collect(toList());
   }

   private LocalDateTime randomLocalDateTime() {
      LocalDate start = LocalDate.of(1970, Month.JANUARY, 1);
      long days = ChronoUnit.DAYS.between(start, LocalDate.now());
      LocalDate randomDate = start.plusDays(RANDOM.nextInt((int) days + 1));
      LocalTime randomTime = LocalTime.MIN.plusMinutes(randomInt(480, 1250));
      return randomDate.atTime(randomTime);
   }

   private boolean randomBoolean() {
      return randomInt(1, 3) == 1;
   }

   public int randomInt(int min, int max) {
      return RANDOM.nextInt(max - min) + min;
   }
}
