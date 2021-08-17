package lt.pavilonis.classroommonitor.ui;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import lt.pavilonis.classroommonitor.Spring;
import lt.pavilonis.classroommonitor.service.ClassroomOccupancy;
import lt.pavilonis.classroommonitor.service.PeriodicalRunner;
import lt.pavilonis.classroommonitor.service.WebServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public final class MainView extends BorderPane {

   static final String FONT = "SansSerif";
   static final int FONT_SIZE_SMALL = 56;
   private static final Logger LOGGER = LoggerFactory.getLogger(MainView.class);
   private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm");
   private static final String STYLE_BASE = "-fx-border-color: black; -fx-border-width:4px;" +
         " -fx-border-radius: 30px; -fx-background-radius: 30px; ";
   private static final String STYLE_RED = "-fx-background-color: rgba(255, 0, 0, .66)";
   private static final String STYLE_GREEN = "-fx-background-color: rgba(0, 255, 0, .66)";
   public static final int GRID_SIZE = 24;
   private static final int GRID_COLUMNS = 8;
   private final List<ClassroomNode> nodes = initEmptyNodes();
   private final WebServiceClient wsClient;
   private final MessageSource messages;
   private boolean busy;

   public MainView() {
      this.wsClient = Spring.getBean(WebServiceClient.class);
      this.messages = Spring.getBean(MessageSource.class);

      setCenter(createGrid(nodes));
      setPadding(new Insets(36, 20, 20, 20));
      setTop(new Header(Spring.getStringProperty("header.text"), Spring.getIntProperty("font.size.title")));

      var footer = new Footer();
      setBottom(footer);

      PeriodicalRunner runner = Spring.getBean(PeriodicalRunner.class);
      runner.setUpdateTask(this::performUpdate);
      runner.setProgressConsumer(footer::updateProgressValue);
   }

   private void performUpdate() {
      if (busy) {
         LOGGER.debug("Skipping update: busy");
         return;
      }
      busy = true;
      clearWarnings();
      wsClient.load(response -> {
         if (response == null) {
            displayWarning("No response from server!");

         } else {
            List<ClassroomOccupancy> items = Stream.of(response)
                  .sorted(Comparator.comparingInt(ClassroomOccupancy::getClassroomNumber))
                  .collect(toList());
            regularUpdate(items);
         }
         ((Footer) getBottom()).updateProgressValue(0);
         busy = false;
      });
   }

   private void regularUpdate(List<ClassroomOccupancy> items) {
      for (int i = 0; i < GRID_SIZE; i++) {

         ClassroomNode node = nodes.get(i);

         if (i < items.size()) {
            updateNode(node, items.get(i));
         } else {
            updateNode(node, null);
         }
      }
   }

   private void updateNode(ClassroomNode boxNode, ClassroomOccupancy classroom) {
      ObservableList<Node> contents = boxNode.getChildren();
      contents.clear();

      if (classroom == null) {
         boxNode.setStyle("-fx-background-color: #fafafa");

      } else {
         Node labelClassroomNumber = createLabel(formatString(classroom), Spring.getIntProperty("font.size.title"));

         if (classroom.isOccupied()) {
            boxNode.setStyle(STYLE_BASE + STYLE_RED);

            LocalDateTime occupancyPeriodStart = classroom.getDateTime();
            String time = TIME_FORMAT.format(occupancyPeriodStart);

            Node labelTime = createLabel(time, FONT_SIZE_SMALL);
            Node labelState = createLabel(messages.getMessage("MainView.occupied", null, null), FONT_SIZE_SMALL);

            contents.addAll(labelTime, labelClassroomNumber, labelState);

         } else {
            boxNode.setStyle(STYLE_BASE + STYLE_GREEN);

            Node labelState = createLabel(messages.getMessage("MainView.free", null, null), FONT_SIZE_SMALL);
            contents.addAll(createLabel("", FONT_SIZE_SMALL), labelClassroomNumber, labelState);
         }
      }
   }

   private String formatString(ClassroomOccupancy classroom) {
      int number = classroom.getClassroomNumber();
      return number < 100
            ? "0" + number
            : String.valueOf(number);
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

   static Node createLabel(String text, int size) {
      Text textNode = new Text(text);
      textNode.setFont(Font.font(FONT, FontWeight.NORMAL, size));
      return textNode;
   }

   public void displayWarning(String text) {
      clearWarnings();
      var textWithErrorMessage = wsClient.getLastErrorMessage()
            .map(message -> text + "\n" + message)
            .orElse(text);

      var warningBox = new WarningBox(textWithErrorMessage);
      warningBox.setOnMouseClicked(click -> getElements().remove(warningBox));

      Platform.runLater(() -> getElements().add(warningBox));
   }

   public void clearWarnings() {
      Platform.runLater(() -> getElements().removeIf(child -> child instanceof WarningBox));
   }

   private List<Node> getElements() {
      StackPane rootPane = (StackPane) getParent();
      return rootPane.getChildren();
   }
}
