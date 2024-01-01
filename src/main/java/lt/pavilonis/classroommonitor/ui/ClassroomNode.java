package lt.pavilonis.classroommonitor.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

final class ClassroomNode extends VBox {

   private static final double INSET_RATIO = 0.03;

   ClassroomNode(double size) {
      setPadding(new Insets(size * INSET_RATIO));
      setMinSize(size, size);
      setMaxSize(size, size);
      setAlignment(Pos.CENTER);
   }
}
