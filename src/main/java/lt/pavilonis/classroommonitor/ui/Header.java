package lt.pavilonis.classroommonitor.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

final class Header extends HBox {

   Header(String title, int fontSizeTitle) {
      setAlignment(Pos.CENTER);
      setPadding(new Insets(0, 0, 36, 0));

      Node textNode = MainView.createLabel(title, fontSizeTitle);
      getChildren().add(textNode);
   }
}
