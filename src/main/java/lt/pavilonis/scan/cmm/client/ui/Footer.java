package lt.pavilonis.scan.cmm.client.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.util.ResourceBundle;

final class Footer extends HBox {

   private final ProgressBar progressBar = new ProgressBar(0);

   Footer() {
      setSpacing(10);

      HBox.setHgrow(progressBar, Priority.ALWAYS);
      progressBar.setMaxWidth(Double.MAX_VALUE);

      getChildren().addAll(createLabel(), progressBar);

      setAlignment(Pos.CENTER_LEFT);
   }

   void updateProgressValue(double progress) {
      progressBar.setProgress(progress);
   }

   private Label createLabel() {
      String version = ResourceBundle.getBundle("application")
            .getString("application.version");

      return new Label(" v. " + version);
   }
}
