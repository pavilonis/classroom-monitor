package lt.pavilonis.classroommonitor;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import lt.pavilonis.classroommonitor.ui.MainView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Locale;

@Slf4j
@SpringBootApplication
@EnableAsync
@EnableScheduling
@PropertySource(value = {"file:${propertiesLocation:app.properties}"}, encoding = "UTF-8")
public class JavaFxApp extends Application {

   public final Pane rootPane = new StackPane();

   public static void main(String[] args) {
      JavaFxApp.launch(JavaFxApp.class);
   }

   @Override
   public void start(Stage stage) {
      try {
         stage.setScene(createScene());
         stage.setMaximized(true);
         stage.show();

      } catch (Exception e) {
         log.error("Could not start JavaFx app", e);
      }
   }

   private Scene createScene() {
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

   @Override
   public void init() {
      ConfigurableApplicationContext context = SpringApplication.run(JavaFxApp.class);

      Platform.runLater(() -> {
         MainView mainView = context.getBean(MainView.class);
         rootPane.getChildren().add(mainView);
      });
   }

   @Bean
   public MessageSource messageSource() {
      var messages = new ReloadableResourceBundleMessageSource();
      messages.setUseCodeAsDefaultMessage(true);
      messages.setBasename("classpath:lang/messages");
      messages.setCacheSeconds(0);
      messages.setDefaultEncoding("UTF-8");
      messages.setDefaultLocale(new Locale("lt"));
      return messages;
   }
}
