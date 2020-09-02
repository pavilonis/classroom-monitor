package lt.pavilonis.scan.cmm.client.service;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class ClassroomOccupancy {

   private final LocalDateTime dateTime;
   private final int classroomNumber;
   private final boolean occupied;

   public ClassroomOccupancy(@JsonProperty("dateTime") LocalDateTime dateTime,
                             @JsonProperty("occupied") boolean occupied,
                             @JsonProperty("classroomNumber") int classroomNumber) {

      this.dateTime = dateTime;
      this.classroomNumber = classroomNumber;
      this.occupied = occupied;
   }

   public boolean isOccupied() {
      return occupied;
   }

   public int getClassroomNumber() {
      return classroomNumber;
   }

   public LocalDateTime getDateTime() {
      return dateTime;
   }
}
