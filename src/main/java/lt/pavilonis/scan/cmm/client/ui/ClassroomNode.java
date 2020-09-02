package lt.pavilonis.scan.cmm.client.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class ClassroomNode extends VBox {

   private static final int WIDTH = 220;

   public ClassroomNode() {
      setPadding(new Insets(7));
      setMinWidth(WIDTH);
      setMaxWidth(WIDTH);
      setAlignment(Pos.CENTER);
   }
}
