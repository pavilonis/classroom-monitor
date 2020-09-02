package lt.pavilonis.scan.cmm.client.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Header extends HBox {

   public Header(@Value("${header.text}") String title,
                 @Value("${font.size.title:94}") int fontSizeTitle) {

      setAlignment(Pos.CENTER);
      setPadding(new Insets(0, 0, 8, 0));

      Node textNode = MainView.createLabel(title, fontSizeTitle);
      getChildren().add(textNode);
   }
}
