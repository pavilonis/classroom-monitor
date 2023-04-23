package lt.pavilonis.classroommonitor.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ClassroomOccupancy {

   private final String name;
   private final boolean occupied;
   private final LocalDateTime dateTime;

}
