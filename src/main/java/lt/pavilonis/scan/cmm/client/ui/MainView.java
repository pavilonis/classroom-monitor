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
import lt.pavilonis.scan.cmm.client.service.WsRestClient;
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
   private final static String FONT = "SansSerif";
   private static final int COUNTER_STEP = 100;
   private final static int GRID_SIZE = 24;
   private final static int GRID_COLUMNS = 6;
   private final List<ClassroomNode> nodes = initEmptyNodes();
   private final WsRestClient wsClient;
   private final int updateInterval;
   private final Footer footer = new Footer();
   private int millisecondCounter;

   public MainView(WsRestClient wsClient, @Value("${api.request.interval}") int updateInterval) {
      this.wsClient = wsClient;
      this.updateInterval = updateInterval;

      setCenter(createGrid(nodes));
      setBottom(footer);
   }

   @Scheduled(fixedRate = COUNTER_STEP)
   public void updateNodes() {

      millisecondCounter += COUNTER_STEP;

      if (millisecondCounter == updateInterval) {
         wsClient.load(response -> {
            if (response.isPresent()) {

               List<ClassroomOccupancy> items = Arrays.asList(response.get());
               items.sort((i1, i2) -> Integer.compare(i1.getClassroomNumber(), i2.getClassroomNumber()));

               regularUpdate(items);
//            animatedUpdate(items);

            } else {
               App.displayWarning("No response from server!");
            }
            millisecondCounter = 0;
            footer.updateProgressValue(0);
         });
      } else {
         double progress = millisecondCounter / (double) updateInterval;
         footer.updateProgressValue(progress);
      }


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
         node.setStyle(item.get().isOccupied() ? "-fx-background-color: red" : "-fx-background-color: green");
         node.getChildren().add(createLabel(item.get()));

      } else {
         node.setStyle("-fx-background-color: white");
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
      grid.setHgap(40);
      grid.setVgap(106);
      grid.setGridLinesVisible(true);
      grid.setPadding(new Insets(30));

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
