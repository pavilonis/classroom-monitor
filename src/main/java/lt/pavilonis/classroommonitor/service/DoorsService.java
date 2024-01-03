package lt.pavilonis.classroommonitor.service;

import lt.pavilonis.classroommonitor.dto.ClassroomOccupancy;

import java.util.List;
import java.util.function.Consumer;

public interface DoorsService {

   void updateStatuses(Consumer<Double> progressConsumer);

   List<ClassroomOccupancy> fetchDoors();

}
