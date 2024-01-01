package lt.pavilonis.classroommonitor.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static lt.pavilonis.classroommonitor.util.LabelUtils.createLabel;

@Component
public final class Header extends HBox {

   private static final double HEADER_RATIO = 0.07;
   private static final double BOTTOM_PADDING_RATIO = 0.005;

   public Header(@Value("${screen.header.text}") String headerText) {

      Rectangle2D bounds = Screen.getPrimary().getBounds();
      double screenHeight = bounds.getHeight();

      setAlignment(Pos.CENTER);
      setPadding(new Insets(0, 0, screenHeight * BOTTOM_PADDING_RATIO, 0));

      Node textNode = createLabel(headerText, screenHeight * HEADER_RATIO);
      getChildren().add(textNode);
   }
}
