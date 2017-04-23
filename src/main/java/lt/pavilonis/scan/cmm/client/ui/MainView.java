package lt.pavilonis.scan.cmm.client.ui;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import lt.pavilonis.scan.cmm.client.App;
import lt.pavilonis.scan.cmm.client.representation.ClassroomOccupancy;
import lt.pavilonis.scan.cmm.client.service.WsRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MainView extends BorderPane {

   private final static Logger LOG = LoggerFactory.getLogger(MainView.class);
   private final static String FONT = "SansSerif";
   private final static int GRID_SIZE = 24;
   private final static int GRID_COLUMNS = 6;
   private final List<VBox> nodes = initEmptyNodes();

   private final WsRestClient wsClient;

   public MainView(WsRestClient wsClient) {
      this.wsClient = wsClient;

      setCenter(createGrid(nodes));
      setBottom(new Footer());
   }

   @Scheduled(fixedRate = 5000)
   public void updateNodes() {
      wsClient.load(response -> {
         if (response.isPresent()) {
            ClassroomOccupancy[] classroomOccupancies = response.get();

            for (int i = 0; i < GRID_SIZE; i++) {
               VBox node = nodes.get(i);
               node.getChildren().clear();
               if (i < classroomOccupancies.length) {
                  ClassroomOccupancy item = classroomOccupancies[i];
                  node.setStyle(item.isOccupied() ? "-fx-background-color: red" : "-fx-background-color: green");
                  node.getChildren().add(createLabel(item));
               } else {
                  node.setStyle("-fx-background-color: white");
               }
            }
         } else {
            App.displayWarning("No response from server!");
         }
      });
   }

   private List<VBox> initEmptyNodes() {
      ArrayList<VBox> result = new ArrayList<>(GRID_SIZE);
      for (int i = 0; i < GRID_SIZE; i++) {
         result.add(new VBox());
      }
      return result;
   }

   private GridPane createGrid(List<VBox> nodes) {
      GridPane grid = new GridPane();
      grid.setHgap(40);
      grid.setVgap(106);
      grid.setGridLinesVisible(true);
      grid.setPadding(new Insets(30));

      for (int i = 0; i < GRID_SIZE; i++) {
         int row = i / GRID_COLUMNS;
         int column = i - row * GRID_COLUMNS;

         VBox node = nodes.get(i);
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
