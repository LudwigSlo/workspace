package projectTestSnake;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.scene.*;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;

public class  WelcomeScreen  {
	Main main;
	
	
	public void startSnake(){
		main = new Main();
		main.createContent();
		main.startGame();
	}
	
	public Parent scene(Scene name){
		
		StackPane root = new StackPane();
		root.setPrefSize(800, 600);
		Text text = new Text("This will be the guide for snake, click to play");
		root.setOnMouseClicked(event -> {
			
		    Stage stage = new Stage();
		       stage.setScene(name);
		        stage.show();
		       System.out.println("CLICKED ON WELCOME SCREEN");
		       
		       /* --------------------------------------------
		        *  Here I want it to start the main.startGame
		        *  -------------------------------------------
		        */

//		       startSnake();

		
		});
		

		
//		SnakeMenu btnStart = new SnakeMenu("START");
//		btnStart.setOnMouseClicked(event -> {
//			main = new Main();
//		    Stage stage = new Stage();
//		       stage.setScene(name);
//		        stage.show();
//		        main.Hej();
//		        ((Node)(event.getSource())).getScene().getWindow().hide();
//
//		});
		
//		Button b = new Button("Button");
//		b.setOnAction(new EventHandler<ActionEvent>() {
//		    @Override 
//		    public void handle(ActionEvent e) {
//		    
//		        Stage stage = new Stage();
//		       stage.setScene(name);
//		        stage.show();
//		       
//		    }
//		});
		
	        root.getChildren().addAll( text);
		return root;
	}
}
