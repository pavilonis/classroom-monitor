package lt.pavilonis.classroommonitor.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

final class ClassroomNode extends VBox {

   private static final int WIDTH = 220;

   ClassroomNode() {
      setPadding(new Insets(7));
      setMinWidth(WIDTH);
      setMaxWidth(WIDTH);
      setAlignment(Pos.CENTER);
   }
}
