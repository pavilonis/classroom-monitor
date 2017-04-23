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
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MainView extends BorderPane {

   private final static Logger LOG = LoggerFactory.getLogger(MainView.class);
   private final static int GRID_SIZE = 24;
   private final  List<VBox> nodes = new ArrayList<>(GRID_SIZE);

   private final WsRestClient wsClient;

   public MainView(WsRestClient wsClient) {
      this.wsClient = wsClient;
      for (int i = 0; i < GRID_SIZE; i++) {
         nodes.add(new VBox());
      }

      GridPane grid = createGrid();

      wsClient.load(response -> {
         if (response.isPresent()) {
            ClassroomOccupancy[] classroomOccupancies = response.get();
            for (int i = 0; i < classroomOccupancies.length; i++) {
               int row = i / 6;
               int column = i - row * 6;
               grid.add(createLabel(classroomOccupancies[i]), column, row);
            }
         } else {
            App.displayWarning("No response from server!");
         }
      });

      setCenter(grid);
      setBottom(new Footer());
   }

   private GridPane createGrid() {
      GridPane grid = new GridPane();
      grid.setHgap(40);
      grid.setVgap(106);
      grid.setGridLinesVisible(true);
      grid.setPadding(new Insets(30));
      return grid;
   }

   private Node createLabel(ClassroomOccupancy classroomOccupancy) {
      VBox box = new VBox();
      box.setStyle(
            classroomOccupancy.isOccupied()
                  ? "-fx-background-color: red"
                  : "-fx-background-color: green"
      );

      String number = String.valueOf(classroomOccupancy.getClassroomNumber());

      Node textNode = createTextNode(number);
      box.getChildren().add(textNode);
      return box;
   }

   private Node createTextNode(String number) {
      Text textNode = new Text(number);
      textNode.setFont(Font.font("SansSerif", FontWeight.NORMAL, 145));
      return textNode;
//      return new Label(number);
   }
}
