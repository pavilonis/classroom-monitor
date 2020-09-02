package lt.pavilonis.scan.cmm.client.ui;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import lt.pavilonis.scan.cmm.client.App;
import lt.pavilonis.scan.cmm.client.service.ClassroomOccupancy;
import lt.pavilonis.scan.cmm.client.service.MessageSourceAdapter;
import lt.pavilonis.scan.cmm.client.service.WebServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
public class MainView extends BorderPane {

   static final String FONT = "SansSerif";
   static final int FONT_SIZE_SMALL = 56;
   private static final Logger LOGGER = LoggerFactory.getLogger(MainView.class);
   private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm");
   private static final String STYLE_BASE = "-fx-border-color: black; -fx-border-width:4px;" +
         " -fx-border-radius: 30px; -fx-background-radius: 30px; ";
   private static final String STYLE_RED = "-fx-background-color: rgba(255, 0, 0, .66)";
   private static final String STYLE_GREEN = "-fx-background-color: rgba(0, 255, 0, .66)";
   private static final int INTERVAL_MIN = 1000;
   private static final int COUNTER_STEP = 50;
   public static final int GRID_SIZE = 24;
   private static final int GRID_COLUMNS = 8;
   private final List<ClassroomNode> nodes = initEmptyNodes();
   private final WebServiceClient wsClient;
   private final int updateInterval;
   private final Footer footer = new Footer();
   private final MessageSourceAdapter messages;
   private final int offsetPositive;
   private final int offsetNegative;
   private final int fontSizeTitle;
   private int counter;
   private boolean busy;

   public MainView(WebServiceClient wsClient,
                   @Value("${api.request.interval:5000}") int updateInterval,
                   @Value("${font.size.title:94}") int fontSizeTitle,
                   MessageSourceAdapter messages,
                   Header header) {

      if (updateInterval < INTERVAL_MIN) {
         LOGGER.error("Update interval is too small. Should be more than {}", INTERVAL_MIN);
         throw new IllegalArgumentException("Update interval is too small");
      }
      this.wsClient = wsClient;
      this.messages = messages;
      this.updateInterval = updateInterval;
      this.offsetPositive = updateInterval + COUNTER_STEP * 2;
      this.offsetNegative = updateInterval - COUNTER_STEP * 2;
      this.fontSizeTitle = fontSizeTitle;

      setCenter(createGrid(nodes));
      setPadding(new Insets(36, 20, 20, 20));

      setTop(header);
      setBottom(footer);
   }

   @Scheduled(fixedRate = COUNTER_STEP)
   public void count() {

      if (busy) {
         LOGGER.debug("Skipping update: busy");
         return;
      }

      counter += COUNTER_STEP;

      if (counter > offsetNegative && counter < offsetPositive) {

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
            items.sort(Comparator.comparingInt(ClassroomOccupancy::getClassroomNumber));
            regularUpdate(items);

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

         Optional<ClassroomOccupancy> item = i < items.size()
               ? Optional.of(items.get(i))
               : Optional.empty();

         updateNode(node, item);
      }
   }

   private void updateNode(ClassroomNode boxNode, Optional<ClassroomOccupancy> item) {
      ObservableList<Node> contents = boxNode.getChildren();
      contents.clear();

      if (item.isPresent()) {
         ClassroomOccupancy classroom = item.get();
         Node labelClassroomNumber = createLabel(String.valueOf(classroom.getClassroomNumber()), fontSizeTitle);

         if (classroom.isOccupied()) {
            boxNode.setStyle(STYLE_BASE + STYLE_RED);

            LocalDateTime occupancyPeriodStart = classroom.getDateTime();
            String time = TIME_FORMAT.format(occupancyPeriodStart);

            Node labelTime = createLabel(time, FONT_SIZE_SMALL);
            Node labelState = createLabel(messages.get(this, "occupied"), FONT_SIZE_SMALL);

            contents.addAll(labelTime, labelClassroomNumber, labelState);

         } else {
            boxNode.setStyle(STYLE_BASE + STYLE_GREEN);

            Node labelState = createLabel(messages.get(this, "free"), FONT_SIZE_SMALL);
            contents.addAll(createLabel("", FONT_SIZE_SMALL), labelClassroomNumber, labelState);
         }

      } else {
         boxNode.setStyle("-fx-background-color: #fafafa");
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
}
