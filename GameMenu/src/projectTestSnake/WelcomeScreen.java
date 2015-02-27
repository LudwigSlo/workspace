package projectTestSnake;

import java.awt.Dimension;
import java.awt.Toolkit;
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
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

public class  WelcomeScreen  {
	private static final AudioClip START_AUDIOCLIP = new AudioClip(WelcomeScreen.class.getResource("/start.wav").toString());
	Main main;
	
	public void startSnake(){
		main = new Main();

		main.getTimeline().play();
		main.createContent();
		main.startGame();
	}
	
	public Parent scene(){

        Pane root = new Pane();

        
//		 
		final Menu menu1 = new Menu("_Game");
		final Menu menu2 = new Menu("_Exit");
		
		 
		MenuItem menuStart = new MenuItem("_Start Game");
		MenuItem menuExit = new MenuItem("_Exit");
		 
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(menu1, menu2);
		menuBar.prefWidthProperty().bind(root.widthProperty());
		menuBar.prefHeightProperty().bind(root.heightProperty());
		menuBar.getStylesheets().add("/myStyle.css");
		
		menuStart.setMnemonicParsing(true);
		menuStart.setAccelerator(new KeyCodeCombination(KeyCode.X,KeyCombination.CONTROL_DOWN));
		menu1.getItems().addAll(menuStart);
		menuExit.setAccelerator(new KeyCodeCombination(KeyCode.Z,KeyCombination.CONTROL_DOWN));
		
		 menuExit.setOnAction(new EventHandler<ActionEvent>() {
			    @Override 
			    public void handle(ActionEvent e) {
			    	System.exit(0);
			    }
			});
		
		
		 
		 
		 menu1.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	System.out.println("Inside action");
		    	SnakeLauncher sl = new SnakeLauncher();
		    	
		
		    	Stage stage = new Stage();
		    	
		    	
		    	
			    WelcomeScreen.START_AUDIOCLIP.play();
			    
		    	

		    	stage.setScene(sl.snakeCreateScene());
		    	stage.show();
		        stage.getIcons().add(new Image("/images/snake-icon.png"));
		        stage.setResizable(false);
		        startSnake();
		    }
		 });
	        menu2.getItems().addAll(menuExit);
//
	        root.setPrefSize(450, 420);
//		Text text = new Text("This will be the guide for snake, click to play");

		Label label=new Label("\n Welcome to Snake! \n \n \n To play use the controllers: \n W for Up. \n S for Down. \n A for Left.  \n D for Right. \n \n \n Press Escape in-game to access \n the in-game menu. \n \n \n Made by, \n Ludwig Slotte. \n ");
		ScrollPane scroll=new ScrollPane(label);
		scroll.setPrefViewportHeight(340);
		scroll.setPrefViewportWidth(400);
		scroll.setTranslateX(16);
		scroll.setTranslateY(49);

		label.setStyle("-fx-font-size: 15pt;");
		scroll.setStyle("-fx-background: black;");
		label.getStyleClass().add("labelText");
		System.out.println(label.getStyleClass());
		
//		stage.setScene(scene);
		root.getChildren().addAll(menuBar, scroll);
//		stage.show();
//scene.getChildren().addAll(menuBar);
		return root;
	}
}
