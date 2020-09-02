package lt.pavilonis.scan.cmm.client.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class ClassroomNode extends VBox {

   private static final int WIDTH = 186;

   public ClassroomNode() {
      setPadding(new Insets(5));
      setMinWidth(WIDTH);
      setMaxWidth(WIDTH);
      setAlignment(Pos.CENTER);
   }
}
