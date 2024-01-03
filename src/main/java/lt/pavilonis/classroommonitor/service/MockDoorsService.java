package lt.pavilonis.classroommonitor.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lt.pavilonis.classroommonitor.dto.ClassroomOccupancy;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.IntStream;

@Slf4j
@ConditionalOnProperty(value = "api.test-mode", havingValue = "true")
@Service
public class MockDoorsService implements DoorsService {

   private static final Random RANDOM = new Random();

   public MockDoorsService() {
      log.info("Using {}", this.getClass().getSimpleName());
   }

   @Override
   public List<ClassroomOccupancy> fetchDoors() {
      return IntStream.range(0, 80)
            .map(i -> randomInt(100, 900))
            .mapToObj(String::valueOf)
            .map(number -> new ClassroomOccupancy(number, randomBoolean(), randomLocalDateTime()))
            .toList();
   }

   @SneakyThrows
   @Override
   public void updateStatuses(Consumer<Double> progressConsumer) {
      int testDataFetchSteps = 10;
      for (int i = 1; i <= testDataFetchSteps; i++) {
         double progress = i / (double) testDataFetchSteps;
         log.info("Test data progress: {}", progress);
         progressConsumer.accept(progress);
         Thread.sleep(1_000L);
      }
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
