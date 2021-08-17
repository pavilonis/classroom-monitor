package lt.pavilonis.classroommonitor.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import lt.pavilonis.classroommonitor.Spring;
import org.springframework.context.MessageSource;

final class Footer extends HBox {

   private final ProgressBar progressBar = new ProgressBar(0);

   Footer() {
      setSpacing(10);
      HBox.setHgrow(progressBar, Priority.ALWAYS);
      progressBar.setMaxWidth(Double.MAX_VALUE);

      getChildren().addAll(createVersionLabel(), progressBar);
      setAlignment(Pos.CENTER_LEFT);
   }

   void updateProgressValue(double progress) {
      progressBar.setProgress(progress);
   }

   private Label createVersionLabel() {
      String versionKey = Spring.getBean(MessageSource.class)
            .getMessage("Footer.version", null, null);

      String versionValue = Spring.getStringProperty("application.version");
      return new Label(versionKey + " " + versionValue);
   }
}
