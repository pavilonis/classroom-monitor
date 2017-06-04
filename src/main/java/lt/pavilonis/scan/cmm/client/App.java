package lt.pavilonis.scan.cmm.client;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lt.pavilonis.scan.cmm.client.service.WebServiceClient;
import lt.pavilonis.scan.cmm.client.ui.MainView;
import lt.pavilonis.scan.cmm.client.ui.WarningBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App extends Application {

   private final static Logger LOG = LoggerFactory.getLogger(App.class);
   private static final StackPane ROOT_PANE = new StackPane();
   private static final WarningBox WARNING_BOX = new WarningBox(ROOT_PANE.getChildren());
   private static WebServiceClient wsClient;

   public static void main(String[] args) {
      launch();
   }

   @Override
   public void start(Stage stage) {
      try {

         AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
         wsClient = context.getBean(WebServiceClient.class);

         MainView mainView = context.getBean(MainView.class);
         ROOT_PANE.getChildren().add(mainView);

         stage.setScene(createScene());
         stage.setMaximized(true);
         stage.show();

      } catch (Exception e) {
         LOG.error("Got error: " + e.getMessage());
         e.printStackTrace();
      }
   }

   private Scene createScene() {
      Scene scene = new Scene(ROOT_PANE, Color.WHITE);
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

   public static void displayWarning(String text) {
      if (wsClient.getLastErrorMessage().isPresent()) {
         text += "\n" + wsClient.getLastErrorMessage().get();
      }
      WARNING_BOX.warning(text);
   }

   public static void clearWarning() {
      if (ROOT_PANE.getChildren().contains(WARNING_BOX)) {
         WARNING_BOX.hide();
      }
   }
}
