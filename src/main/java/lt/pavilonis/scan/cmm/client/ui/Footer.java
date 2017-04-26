package lt.pavilonis.scan.cmm.client.ui;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import lt.pavilonis.scan.cmm.client.service.BackgroundTask;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ResourceBundle;

public class Footer extends HBox {
   private static final String PROPERTY_VERSION = ResourceBundle
         .getBundle("application")
         .getString("application.version");


   private final ProgressBar progressBar = new ProgressBar(0);


   public Footer() {

      Label versionLabel = new Label("v." + " " + PROPERTY_VERSION);

      setSpacing(10);

      HBox.setHgrow(progressBar, Priority.ALWAYS);
      progressBar.setMaxWidth(Double.MAX_VALUE);

      getChildren().addAll(versionLabel, progressBar);

      setAlignment(Pos.CENTER_LEFT);
//      setStyle("-fx-border-color: black");
   }

   public void updateProgressValue(double progress) {
//      progressBar.setProgress(progress);
             new BackgroundTask<Void>(() ->
                  Platform.runLater( () -> {
                     progressBar.setProgress(progress);
                     System.out.println("progress set: "+progress);
                  })
            );
//            () -> progressBar.setProgress(progress)
   }
}
