package lt.pavilonis.classroommonitor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lt.pavilonis.classroommonitor.ui.MainView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class JavaFxApp extends Application {

   private static final Logger LOGGER = LoggerFactory.getLogger(Spring.class);

   @Override
   public void start(Stage stage) {
      try {
         var rootPane = new StackPane();
         rootPane.getChildren().add(new MainView());
         stage.setScene(createScene(rootPane));
         stage.setMaximized(true);
         stage.show();

      } catch (Exception e) {
         LOGGER.error("Could not start JavaFx app", e);
      }
   }

   private Scene createScene(StackPane rootPane) {
      var scene = new Scene(rootPane, Color.WHITE);
      scene.setOnKeyPressed(event -> {
         if (event.getCode() == KeyCode.ESCAPE) {
            stop();
         }
      });
      return scene;
   }

   @Override
   public void stop() {
      System.exit(0);
   }
}
