package projectTestSnake;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
//import projectTestSnake.Main.Direction;
//import projectTestSnake.Main.MenuButton;
import projectTestSnake.Main;




	
	class SnakeMenu extends StackPane{
		private Text text;
		
		public SnakeMenu(String name){
			text = new Text(name);
			text.getFont();
			text.setFont(Font.font(22));
			text.setFill(Color.WHITE);
			
			
			Rectangle bg = new Rectangle(160,30);
			bg.setEffect(new GaussianBlur(2.5));
			bg.setArcHeight(13);
			
			bg.setArcWidth(13);
			bg.setOpacity(0.7);
			bg.setFill(Color.RED);
			
		
			
			
			this.setAlignment(Pos.CENTER);
			setRotate(-0.5);
			getChildren().addAll(bg, text);
			
			setOnMouseEntered(event-> {
				bg.setTranslateX(9);
				text.setTranslateX(9);
				bg.setFill(Color.WHITE);
				text.setFill(Color.BLACK);
			});
			
			
			setOnMouseExited(event-> {
				bg.setTranslateX(0);
				text.setTranslateX(0);
				bg.setFill(Color.RED);
				text.setFill(Color.WHITE);
			});
			
			DropShadow drop = new DropShadow(75, Color.GRAY);
			drop.setInput(new Glow());
			
			setOnMousePressed(event -> setEffect(drop));

			setOnMouseReleased(event -> setEffect(null));
			
		}
		
	
}
	