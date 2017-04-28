package lt.pavilonis.scan.cmm.client.service;

import lt.pavilonis.scan.cmm.client.representation.ClassroomOccupancy;
import org.apache.commons.lang3.RandomUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Random;

class WebServiceMock {

   ClassroomOccupancy[] load() {
      ClassroomOccupancy[] result = new ClassroomOccupancy[22];

      for (int i = 0; i < 22; i++) {
         result[i] = new ClassroomOccupancy(randomLocalDateTime(), randomBoolean(), randomInt());
      }
      return result;
   }

   private LocalDateTime randomLocalDateTime() {
      LocalDate start = LocalDate.of(1970, Month.JANUARY, 1);
      long days = ChronoUnit.DAYS.between(start, LocalDate.now());
      LocalDate randomDate = start.plusDays(new Random().nextInt((int) days + 1));
      LocalTime randomTime = LocalTime.MIN.plusMinutes(RandomUtils.nextInt(480, 1250));
      return randomDate.atTime(randomTime);
   }

   private boolean randomBoolean() {
      return RandomUtils.nextInt(1, 3) == 1;
   }

   private int randomInt() {
      return RandomUtils.nextInt(100, 200);
   }
}
