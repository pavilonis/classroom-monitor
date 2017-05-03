package lt.pavilonis.scan.cmm.client.ui;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import static javafx.animation.Interpolator.EASE_IN;

public class ClassroomNode extends VBox {
   private final FadeTransition transition = new FadeTransition(Duration.millis(3_000), this);
   private static final int WIDTH = 220;

   public ClassroomNode() {
      setPadding(new Insets(7));
      setMinWidth(WIDTH);
      setMaxWidth(WIDTH);
      transition.setInterpolator(EASE_IN);
      setAlignment(Pos.CENTER);
   }

   private void fadeIn() {
      transition.setFromValue(0);
      transition.setToValue(1);
      transition.play();
   }

   private void fadeOut() {
      transition.setFromValue(1);
      transition.setToValue(0);
      transition.play();
   }

   public void fadedAction(EventHandler<ActionEvent> eventHandler) {
      transition.setOnFinished(event -> {
         eventHandler.handle(event);
         transition.setOnFinished(null);
         fadeIn();
      });
      fadeOut();
   }
}
