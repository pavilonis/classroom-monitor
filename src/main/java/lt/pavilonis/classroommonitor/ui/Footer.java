package lt.pavilonis.classroommonitor.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import lt.pavilonis.classroommonitor.Spring;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.MessageSource;

import java.time.LocalDate;
import java.time.ZoneId;

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
      BuildProperties buildProperties = Spring.getBean(BuildProperties.class);
      MessageSource messages = Spring.getBean(MessageSource.class);

      Object[] messageParams =
            {buildProperties.getVersion(), LocalDate.ofInstant(buildProperties.getTime(), ZoneId.systemDefault())};

      String version = messages.getMessage("Footer.version", messageParams, null);
      return new Label(version);
   }
}
