package lt.pavilonis.classroommonitor.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class NumberUtils {

   private static final String CLASS_NUMBER_UNKNOWN = "-1";

   public static String extractNumber(String classroomName) {
      if (!StringUtils.hasText(classroomName)) {
         log.error("Could not extract number from classroom name: " + classroomName);
         return CLASS_NUMBER_UNKNOWN;
      }
      if (classroomName.length() <= 4) {
         return classroomName.trim();
      }
      return classroomName.substring(0, 4).trim();
   }

}
