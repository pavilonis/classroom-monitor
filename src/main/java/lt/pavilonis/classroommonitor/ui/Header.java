package lt.pavilonis.classroommonitor.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static lt.pavilonis.classroommonitor.util.LabelUtils.createLabel;

@Component
public final class Header extends HBox {

   public Header(@Value("${header.text}") String headerText,
                 @Value("${font.size.title}") int headerSize) {

      setAlignment(Pos.CENTER);
      setPadding(new Insets(0, 0, 36, 0));

      Node textNode = createLabel(headerText, headerSize);
      getChildren().add(textNode);
   }
}
