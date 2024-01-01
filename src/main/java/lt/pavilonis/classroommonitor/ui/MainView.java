package lt.pavilonis.classroommonitor.ui;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import lombok.extern.slf4j.Slf4j;
import lt.pavilonis.classroommonitor.dto.ClassroomOccupancy;
import lt.pavilonis.classroommonitor.service.GridComposerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.util.Comparator.comparing;
import static lt.pavilonis.classroommonitor.util.LabelUtils.createLabel;

@Component
@Slf4j
public final class MainView extends BorderPane {

   private static final double CONTENT_TO_PADDING_RATIO = 0.9;
   private static final double CONTENT_VERTICAL_RATIO = 0.89;
   private static final double GAP_TO_NODE_WIDTH_RATIO = 0.08;
   private static final double FONT_TO_NODE_WIDTH_RATIO = 0.35;
   private static final double FONT_SMALL_TO_NODE_WIDTH_RATIO = 0.25;
   private static final Color RED = Color.web("rgba(255, 0, 0, .66)", 1);
   private static final Color GREEN = Color.web("rgba(0, 255, 0, .66)", 1);
   private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm");

   private final String messageOccupied;
   private final String messageFree;
   private final int classroomLimit;

   public MainView(MessageSource messages, Footer footer, Header header,
                   @Value("${screen.classrooms.limit}") int classroomLimit) {

      this.classroomLimit = classroomLimit;
      this.messageOccupied = messages.getMessage("MainView.occupied", null, null);
      this.messageFree = messages.getMessage("MainView.free", null, null);

      setTop(header);
      setBottom(footer);
//      setPadding(new Insets(36, 20, 20, 20));
   }

   public void update(List<ClassroomOccupancy> items) {

      List<ClassroomOccupancy> displayItems = items.stream()
            .sorted(comparing(ClassroomOccupancy::getName))
            .limit(classroomLimit)
            .toList();

      if (displayItems.size() < items.size()) {
         log.warn("Displaying only {}/{} classes because of configured limit", displayItems.size(), items.size());
      }

      Rectangle2D bounds = Screen.getPrimary().getBounds();
      double screenWidth = bounds.getWidth();

      List<List<Integer>> gridModel =
            GridComposerService.createGrid(screenWidth, bounds.getHeight() * CONTENT_VERTICAL_RATIO, displayItems.size());

      int longestRowSize = gridModel.stream()
            .mapToInt(List::size)
            .max()
            .orElseThrow();

      int itemIndex = 0;

      double nodeWidth = screenWidth / longestRowSize * CONTENT_TO_PADDING_RATIO;

      GridPane grid = new GridPane();
      double gap = nodeWidth * GAP_TO_NODE_WIDTH_RATIO;
      grid.setHgap(gap);
      grid.setVgap(gap);
      grid.setAlignment(Pos.CENTER);

      for (int rowIndex = 0; rowIndex < gridModel.size(); rowIndex++) {
         List<Integer> row = gridModel.get(rowIndex);

         for (int columnIndex = 0; columnIndex < row.size(); columnIndex++) {
            ClassroomOccupancy classroomOccupancy = displayItems.get(itemIndex++);
            ClassroomNode node = createNode(classroomOccupancy, nodeWidth);
            grid.add(node, columnIndex, rowIndex);
         }
      }

      setCenter(grid);
   }

   private ClassroomNode createNode(ClassroomOccupancy classroom, double nodeWidth) {
      ClassroomNode boxNode = new ClassroomNode(nodeWidth);
      ObservableList<Node> contents = boxNode.getChildren();
      contents.clear();

      double fontSize = nodeWidth * FONT_TO_NODE_WIDTH_RATIO;
      double fontSizeSmall = nodeWidth * FONT_SMALL_TO_NODE_WIDTH_RATIO;

      Node labelClassroomNumber = createLabel(formatString(classroom), fontSize);
      var radius = new CornerRadii(nodeWidth * 0.13);
      var stroke = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, radius, new BorderWidths(nodeWidth * 0.018));
      boxNode.setBorder(new Border(stroke));

      if (classroom.isOccupied()) {
         boxNode.setBackground(new Background(new BackgroundFill(RED, radius, null)));

         LocalDateTime occupancyPeriodStart = classroom.getDateTime();
         String time = TIME_FORMAT.format(occupancyPeriodStart);

         Node labelTime = createLabel(time, fontSizeSmall);
         Node labelState = createLabel(messageOccupied, fontSizeSmall);

         contents.addAll(labelTime, labelClassroomNumber, labelState);

      } else {
         boxNode.setBackground(new Background(new BackgroundFill(GREEN, radius, null)));

         Node labelState = createLabel(messageFree, fontSizeSmall);
         contents.addAll(createLabel("", fontSizeSmall), labelClassroomNumber, labelState);
      }

      return boxNode;
   }

   private String formatString(ClassroomOccupancy classroom) {
      return classroom.getName();
//      int number = classroom.getName();
//      return number < 100
//            ? "0" + number
//            : String.valueOf(number);
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
