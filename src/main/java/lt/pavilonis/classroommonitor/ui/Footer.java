package lt.pavilonis.classroommonitor.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;

@Component
public class Footer extends HBox {

   private final ProgressBar progressBar = new ProgressBar(0);

   Footer(BuildProperties buildProperties,
          MessageSource messages) {

      setSpacing(10);
      HBox.setHgrow(progressBar, Priority.ALWAYS);
      progressBar.setMaxWidth(Double.MAX_VALUE);

      getChildren().addAll(createVersionLabel(buildProperties, messages), progressBar);
      setAlignment(Pos.CENTER_LEFT);
   }

   public void updateProgressValue(double progress, boolean working) {
      String style = working ? "-fx-accent: rgba(255, 0, 0, .66);" : "-fx-accent: rgba(0, 255, 0, .66);";
      progressBar.setProgress(progress);
      progressBar.setStyle(style);
   }

   private Label createVersionLabel(BuildProperties buildProperties, MessageSource messages) {
      Object[] messageParams =
            {buildProperties.getVersion(), LocalDate.ofInstant(buildProperties.getTime(), ZoneId.systemDefault())};

      String version = messages.getMessage("Footer.version", messageParams, null);
      return new Label(version);
   }
}
