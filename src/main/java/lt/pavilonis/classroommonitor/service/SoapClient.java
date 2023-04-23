package lt.pavilonis.classroommonitor.service;

import lombok.extern.slf4j.Slf4j;
import lt.pavilonis.classroommonitor.generated.StateType;
import lt.pavilonis.classroommonitor.generated.WirelessDoor;
import lt.pavilonis.classroommonitor.generated.WirelessDoorsService;
import lt.pavilonis.classroommonitor.generated.WirelessResultDoorList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static lt.pavilonis.classroommonitor.util.NumberUtils.extractNumber;

@Slf4j
@Service
public class SoapClient {

   private final Map<String, LocalDateTime> occupancyStartTimes = new ConcurrentHashMap<>();
   private final String username;
   private final String password;
   private final boolean testMode;
   private final WirelessDoorsService doorsService;

   public SoapClient(@Value("${api.test-mode}") boolean testMode,
                     @Value("${soap.username}") String username,
                     @Value("${soap.password}") String password,
                     WirelessDoorsService doorsService) {

      log.info("Test mode enabled: {}", testMode);
      this.username = username;
      this.password = password;
      this.testMode = testMode;
      this.doorsService = doorsService;
   }

   public List<ClassroomOccupancy> fetchDoors() {
      if (testMode) {
         return new TestDataProvider().load();
      }

      var start = LocalDateTime.now();
      List<WirelessDoor> doors = requestDoorList();
      updateDoors(doors);

      List<ClassroomOccupancy> result = fetchUpdatedDoors();
      log.info("Request completed [entries={}, t={}]", result.size(), TimeUtils.duration(start));
      return result;
   }

   private List<WirelessDoor> requestDoorList() {
      LocalDateTime start = LocalDateTime.now();
      WirelessResultDoorList doorList = doorsService.doorGetAll(username, password);
      List<WirelessDoor> doors = doorList.getWirelessDoor();
      log.info("Door list ({}) received in {}", doors.size(), TimeUtils.duration(start));
      return doors;
   }

   private List<ClassroomOccupancy> fetchUpdatedDoors() {
      List<ClassroomOccupancy> result = new ArrayList<>();
      List<WirelessDoor> updatedDoors = requestDoorList();

      for (WirelessDoor door : updatedDoors) {
         ClassroomOccupancy occupancy = createClassroomOccupancy(door);
         result.add(occupancy);
      }
      return result;
   }

   private void updateDoors(List<WirelessDoor> doors) {
      LocalDateTime start = LocalDateTime.now();
      int counter = 1;
      int successCounter = 0;
      for (WirelessDoor door : doors) {
         try {
            LocalDateTime doorUpdateStart = LocalDateTime.now();
            doorsService.doorUpdate(username, password, door.getDoorId(), door.getDoorName());
            successCounter++;
            log.info("{}/{} door {} updated in {}",
                  counter++, doors.size(), door.getDoorName(), TimeUtils.duration(doorUpdateStart));
//            Thread.sleep(100);
         } catch (Exception e) {
            log.error("Could not update door {}", door.getDoorName(), e);
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
