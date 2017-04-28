package lt.pavilonis.scan.cmm.client.ui;

import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;
import lt.pavilonis.scan.cmm.client.App;
import lt.pavilonis.scan.cmm.client.representation.ClassroomOccupancy;
import lt.pavilonis.scan.cmm.client.service.WebServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class MainView extends BorderPane {

   private final static Logger LOG = LoggerFactory.getLogger(MainView.class);
   private final static String STYLE_BASE = "-fx-border-color: black; -fx-border-width:4px;" +
         " -fx-border-radius: 30px; -fx-background-radius: 30px; ";
   private final static String FONT = "SansSerif";
   private final static int INTERVAL_MIN = 1000;
   private final static int COUNTER_STEP = 50;
   private final static int GRID_SIZE = 24;
   private final static int GRID_COLUMNS = 6;
   private final List<ClassroomNode> nodes = initEmptyNodes();
   private final WebServiceClient wsClient;
   private final int updateInterval;
   private final Footer footer = new Footer();
   private int counter;
   private boolean busy;

   public MainView(WebServiceClient wsClient, @Value("${api.request.interval}") int updateInterval) {

      if (updateInterval < INTERVAL_MIN) {
         LOG.error("Update interval is too small. Should be more than {}", INTERVAL_MIN);
         throw new IllegalArgumentException("Update interval is too small");
      }
      this.wsClient = wsClient;
      this.updateInterval = updateInterval;

      setCenter(createGrid(nodes));
      setBottom(footer);
   }

   @Scheduled(fixedRate = COUNTER_STEP)
   public void updateNodes() {

      if (busy) {
         LOG.warn("Skipping update: busy");
         return;
      }

      counter += COUNTER_STEP;

      if (counter <= updateInterval + COUNTER_STEP * 2 && counter >= updateInterval - COUNTER_STEP * 2) {

         performUpdate();

      } else {
         double progress = counter / (double) updateInterval;
         footer.updateProgressValue(progress);
      }
   }

   private void performUpdate() {
      busy = true;
      wsClient.load(response -> {
         if (response.isPresent()) {

            List<ClassroomOccupancy> items = Arrays.asList(response.get());
            items.sort((i1, i2) -> Integer.compare(i1.getClassroomNumber(), i2.getClassroomNumber()));

            regularUpdate(items);
//            animatedUpdate(items);

         } else {
            App.displayWarning("No response from server!");
         }
         counter = 0;
         footer.updateProgressValue(0);
         busy = false;
      });
   }

   private void regularUpdate(List<ClassroomOccupancy> items) {
      for (int i = 0; i < GRID_SIZE; i++) {

         ClassroomNode node = nodes.get(i);

         Optional<ClassroomOccupancy> item = i < items.size() ? Optional.of(items.get(i)) : Optional.empty();

         updateNode(node, item);
      }
   }

   private void animatedUpdate(List<ClassroomOccupancy> items) {
      FadeTransition transition = new FadeTransition(Duration.seconds(2), this);
      transition.setFromValue(1);
      transition.setToValue(0);
      transition.setOnFinished(event -> {
         for (int i = 0; i < GRID_SIZE; i++) {

            ClassroomNode node = nodes.get(i);

            Optional<ClassroomOccupancy> item = i < items.size() ? Optional.of(items.get(i)) : Optional.empty();

            updateNode(node, item);
         }
         transition.setFromValue(0);
         transition.setToValue(1);
         transition.setOnFinished(null);
         transition.play();
      });
      transition.play();
   }

   private void updateNode(ClassroomNode node, Optional<ClassroomOccupancy> item) {
      node.getChildren().clear();

      if (item.isPresent()) {
         node.setStyle(item.get().isOccupied()
                     ? STYLE_BASE + "-fx-background-color: rgba(255, 0, 0, .66)"
                     : STYLE_BASE + "-fx-background-color: rgba(0, 255, 0, 0.66)"
         );
         node.getChildren().add(createLabel(item.get()));

      } else {
         node.setStyle("-fx-background-color: #fafafa");
      }
   }

   private List<ClassroomNode> initEmptyNodes() {
      ArrayList<ClassroomNode> result = new ArrayList<>(GRID_SIZE);
      for (int i = 0; i < GRID_SIZE; i++) {
         result.add(new ClassroomNode());
      }
      return result;
   }

   private Node createGrid(List<? extends Node> nodes) {
      GridPane grid = new GridPane();
      grid.setHgap(38);
      grid.setVgap(94);
//      grid.setGridLinesVisible(true);
      grid.setPadding(new Insets(20, 5, 5, 20));

      for (int i = 0; i < GRID_SIZE; i++) {
         int row = i / GRID_COLUMNS;
         int column = i - row * GRID_COLUMNS;

         Node node = nodes.get(i);
         grid.add(node, column, row);
      }
      return grid;
   }

   private Node createLabel(ClassroomOccupancy classroomOccupancy) {

      String number = String.valueOf(classroomOccupancy.getClassroomNumber());

      Text textNode = new Text(number);
      textNode.setFont(Font.font(FONT, FontWeight.NORMAL, 145));
      return textNode;
   }
}
