package lt.pavilonis.classroommonitor.ui;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import lombok.extern.slf4j.Slf4j;
import lt.pavilonis.classroommonitor.dto.ClassroomOccupancy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;
import static lt.pavilonis.classroommonitor.util.LabelUtils.createLabel;

@Component
@Slf4j
public final class MainView extends BorderPane {

   static final int FONT_SIZE_SMALL = 56;
   private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm");
   private static final String STYLE_BASE = "-fx-border-color: black; -fx-border-width:4px;" +
         " -fx-border-radius: 30px; -fx-background-radius: 30px; ";
   private static final String STYLE_RED = "-fx-background-color: rgba(255, 0, 0, .66)";
   private static final String STYLE_GREEN = "-fx-background-color: rgba(0, 255, 0, .66)";
   public static final int GRID_SIZE = 24;
   private static final int GRID_COLUMNS = 8;
   private final List<ClassroomNode> nodes = initEmptyNodes();
   private final String messageOccupied;
   private final String messageFree;
   private final int titleSize;
   private final int classroomLimit;

   public MainView(MessageSource messages, Footer footer, Header header,
                   @Value("${font.size.title}") int titleSize,
                   @Value("${screen.classrooms.limit}") int classroomLimit) {

      this.titleSize = titleSize;
      this.classroomLimit = classroomLimit;
      this.messageOccupied = messages.getMessage("MainView.occupied", null, null);
      this.messageFree = messages.getMessage("MainView.free", null, null);

      setTop(header);
      setCenter(createGrid(nodes));
      setBottom(footer);

      setPadding(new Insets(36, 20, 20, 20));
   }

   public void update(List<ClassroomOccupancy> items) {
      List<ClassroomOccupancy> sortedItems = items.stream()
            .sorted(comparing(ClassroomOccupancy::getName))
            .limit(classroomLimit)
            .toList();

      for (int i = 0; i < GRID_SIZE; i++) {
         ClassroomNode node = nodes.get(i);

         ClassroomOccupancy item = i < sortedItems.size()
               ? sortedItems.get(i)
               : null;

         updateNode(node, item);
      }
   }

   private void updateNode(ClassroomNode boxNode, ClassroomOccupancy classroom) {
      ObservableList<Node> contents = boxNode.getChildren();
      contents.clear();

      if (classroom == null) {
         boxNode.setStyle("-fx-background-color: #fafafa");
         return;
      }

      Node labelClassroomNumber = createLabel(formatString(classroom), titleSize);

      if (classroom.isOccupied()) {
         boxNode.setStyle(STYLE_BASE + STYLE_RED);

         LocalDateTime occupancyPeriodStart = classroom.getDateTime();
         String time = TIME_FORMAT.format(occupancyPeriodStart);

         Node labelTime = createLabel(time, FONT_SIZE_SMALL);
         Node labelState = createLabel(messageOccupied, FONT_SIZE_SMALL);

         contents.addAll(labelTime, labelClassroomNumber, labelState);

      } else {
         boxNode.setStyle(STYLE_BASE + STYLE_GREEN);

         Node labelState = createLabel(messageFree, FONT_SIZE_SMALL);
         contents.addAll(createLabel("", FONT_SIZE_SMALL), labelClassroomNumber, labelState);
      }
   }

   private String formatString(ClassroomOccupancy classroom) {
      return classroom.getName();
//      int number = classroom.getName();
//      return number < 100
//            ? "0" + number
//            : String.valueOf(number);
   }

   private List<ClassroomNode> initEmptyNodes() {
      List<ClassroomNode> result = new ArrayList<>(GRID_SIZE);
      for (int i = 0; i < GRID_SIZE; i++) {
         result.add(new ClassroomNode());
      }
      return result;
   }

   private Node createGrid(List<? extends Node> nodes) {
      GridPane grid = new GridPane();
      grid.setHgap(18);
      grid.setVgap(18);
//      grid.setGridLinesVisible(true);
//      grid.setPadding(new Insets(20, 20, 20, 20));

      for (int i = 0; i < GRID_SIZE; i++) {
         int row = i / GRID_COLUMNS;
         int column = i - row * GRID_COLUMNS;

         Node node = nodes.get(i);
         grid.add(node, column, row);
      }
      return grid;
   }

   public void displayWarning(Exception exception) {
      var warningBox = new WarningBox(extractMessage(exception));

      warningBox.setOnMouseClicked(click -> getElements().remove(warningBox));
      getElements().add(warningBox);
   }

   private String extractMessage(Exception e) {
      if (e instanceof HttpClientErrorException) {
         return "Unexpected HTTP response code: " + ((HttpClientErrorException) e).getStatusCode();

      } else if (e instanceof ResourceAccessException) {
         return "Could not access resource: " + (e.getCause() == null ? e.getMessage() : e.getCause().getMessage());

      } else {
         return "Unknown error: " + (e == null ? "" : e.getMessage());
      }
   }

   public void clearWarnings() {
      List<Node> elements = getElements();
      if (!elements.isEmpty()) {
         elements.removeIf(child -> child instanceof WarningBox);
      }
   }

   private List<Node> getElements() {
      StackPane rootPane = (StackPane) getParent();
      return rootPane == null ? List.of() : rootPane.getChildren();
   }
}
