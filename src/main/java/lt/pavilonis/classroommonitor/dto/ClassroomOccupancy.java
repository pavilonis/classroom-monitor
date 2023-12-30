package lt.pavilonis.classroommonitor.dto;

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
