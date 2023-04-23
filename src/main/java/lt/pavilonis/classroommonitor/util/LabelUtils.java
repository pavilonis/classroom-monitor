package lt.pavilonis.classroommonitor.util;

import javafx.scene.Node;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LabelUtils {

   private static final String FONT = "SansSerif";

   public static Node createLabel(String text, int size) {
      Text textNode = new Text(text);
      textNode.setFont(Font.font(FONT, FontWeight.NORMAL, size));
      return textNode;
   }

}
