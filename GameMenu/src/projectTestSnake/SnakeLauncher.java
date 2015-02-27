package projectTestSnake;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class SnakeLauncher extends Application {
	
	private final static double RESIZE_X = 4;

	private final static double RESIZE_Y = 2.5;
	
	
	public static void main(String[] args) {
		launch(args);
	}

	
	
	
	
	public Scene snakeCreateScene(){
		
		
		Main main = new Main();
	Scene newScene = new Scene(main.createContent());


		
	
	main.startGame();

		newScene.setOnKeyPressed(event -> {
			if (!main.isMoved()) {
				return;
			}

			switch (event.getCode()) {
			case SPACE:
				
				main.startGame();
			case W:
				if (main.getDirection() != Direction.DOWN)
					main.setDirection(Direction.UP);
				break;
			case S:
				if (main.getDirection() != Direction.UP)
					main.setDirection(Direction.DOWN);
				break;
			case A:
				if (main.getDirection() != Direction.RIGHT)
					main.setDirection(Direction.LEFT);
				break;
			case D:
				if (main.getDirection() != Direction.LEFT)
					main.setDirection(Direction.RIGHT);
				break;
			case ESCAPE:
				main.setDirection(Direction.PAUSE);
				break;
			case P:
				main.restartFromMenu();
				break;

			default:
				break;
			}
			main.setMoved(false);
		});
		
		/* --------------------------------------------
		 * I don't want to start main.startGame here, because it starts before the user has clicked on "start" on the Welcome Screen
		 * --------------------------------------------
		 */
		
//		main.startGame();		    
    	
		return newScene;
	}
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		WelcomeScreen ws = new WelcomeScreen();
		  Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
	primaryStage.getIcons().add(new Image("/images/snake-icon.png"));


		primaryStage.setTitle("Snake by Ludwig");
//		primaryStage.set
//		 primaryStage.setScene(newScene);
//		
	    primaryStage.setScene(new Scene(ws.scene(), visualBounds.getWidth() / RESIZE_X,visualBounds.getHeight() / RESIZE_Y));
//		primaryStage.setScene(snakeCreateScene());
	    primaryStage.show();
		
	
		
	}

}
