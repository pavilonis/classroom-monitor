package lt.pavilonis.classroommonitor.service;

import lombok.extern.slf4j.Slf4j;
import lt.pavilonis.classroommonitor.dto.ClassroomOccupancy;
import lt.pavilonis.classroommonitor.generated.StateType;
import lt.pavilonis.classroommonitor.generated.WirelessDoor;
import lt.pavilonis.classroommonitor.generated.WirelessDoorsService;
import lt.pavilonis.classroommonitor.generated.WirelessResultDoorList;
import lt.pavilonis.classroommonitor.util.TimeUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

import static lt.pavilonis.classroommonitor.util.NumberUtils.extractNumber;

@Slf4j
@ConditionalOnProperty(value = "api.test-mode", havingValue = "false")
@Service
public class SoapDoorsService implements DoorsService {

   private final Map<String, LocalDateTime> occupancyStartTimes = new ConcurrentHashMap<>();
   private final String username;
   private final String password;
   private final WirelessDoorsService soapService;

   public SoapDoorsService(@Value("${soap.username}") String username,
                           @Value("${soap.password}") String password,
                           WirelessDoorsService soapService) {
      this.username = username;
      this.password = password;
      this.soapService = soapService;
      log.info("Using {}", this.getClass().getSimpleName());
   }

   @Override
   public List<ClassroomOccupancy> fetchDoors(Consumer<Double> progressMonitor) {
      var start = LocalDateTime.now();
      updateDoorStatuses(progressMonitor);

      List<ClassroomOccupancy> result = fetchUpdatedDoors();
      progressMonitor.accept(1d);
      log.info("Request completed [entries={}, t={}]", result.size(), TimeUtils.duration(start));
      return result;
   }

   private List<WirelessDoor> fetchDoors() {
      LocalDateTime start = LocalDateTime.now();
      WirelessResultDoorList doorList = soapService.doorGetAll(username, password);
      List<WirelessDoor> doors = doorList.getWirelessDoor();

      if (doors.isEmpty()) {
         log.warn("Received empty doors response in {}. " +
               "This can happen because of incorrect service username/password", TimeUtils.duration(start));
      } else  {
         log.info("Received {} doors in {}", doors.size(), TimeUtils.duration(start));
      }
      return doors;
   }

   private List<ClassroomOccupancy> fetchUpdatedDoors() {
      log.info("Fetching updated doors");
      List<ClassroomOccupancy> result = new ArrayList<>();
      List<WirelessDoor> updatedDoors = fetchDoors();

      for (WirelessDoor door : updatedDoors) {
         ClassroomOccupancy occupancy = createClassroomOccupancy(door);
         result.add(occupancy);
      }
      log.info("Updated doors fetching: FINISHED");
      return result;
   }

   private void updateDoorStatuses(Consumer<Double> progressMonitor) {
      log.info("Starting doors status update");
      List<WirelessDoor> doors = fetchDoors();

      LocalDateTime start = LocalDateTime.now();
      int counter = 1;
      int successCounter = 0;
      for (WirelessDoor door : doors) {
         try {
            LocalDateTime doorUpdateStart = LocalDateTime.now();
            soapService.doorUpdate(username, password, door.getDoorId(), door.getDoorName());
            successCounter++;
            log.info("{}/{} door {} updated in {}",
                  counter++, doors.size(), door.getDoorName(), TimeUtils.duration(doorUpdateStart));

         } catch (Exception e) {
            log.error("Could not update door {}", door.getDoorName(), e);

         } finally {
            progressMonitor.accept(counter / (double) doors.size() * 0.9);
         }
      }
      log.info("Updated {}/{} doors in {}", successCounter, doors.size(), TimeUtils.duration(start));
   }

   private ClassroomOccupancy createClassroomOccupancy(WirelessDoor door) {
      boolean occupied = door.getDoorStateInfo().getState() == StateType.PASSAGE;
      String doorName = door.getDoorName();
      String label = extractNumber(doorName);
      LocalDateTime occupancyStartTime = resolveOccupancyStartTime(doorName, occupied);

      return new ClassroomOccupancy(label, occupied, occupancyStartTime);
   }

   private synchronized LocalDateTime resolveOccupancyStartTime(String doorName, boolean occupied) {
      boolean known = occupancyStartTimes.containsKey(doorName);
      LocalDateTime now = LocalDateTime.now();

      if (occupied) {
         if (!known) {
            occupancyStartTimes.put(doorName, now);
         }
         return occupancyStartTimes.get(doorName);

      }

      if (known) {
         occupancyStartTimes.remove(doorName);
      }
      return null;
   }
}
