package lt.pavilonis.scan.cmm.client.ui;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import static javafx.animation.Interpolator.EASE_IN;

public class ClassroomNode extends VBox {
   private final FadeTransition transition = new FadeTransition(Duration.millis(3_000), this);

   public ClassroomNode() {
      transition.setInterpolator(EASE_IN);
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
