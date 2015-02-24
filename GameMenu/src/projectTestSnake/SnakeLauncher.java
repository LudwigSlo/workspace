package projectTestSnake;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SnakeLauncher extends Application {
	
	
	
	public static void main(String[] args) {
		launch(args);
	}

	
	
	
	
	public Scene snakeCreateScene(){
		Main main = new Main();
	Scene newScene = new Scene(main.createContent());

		
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
		
		main.startGame();		    
    	
		return newScene;
	}
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		WelcomeScreen ws = new WelcomeScreen();
		

	

		primaryStage.setTitle("Snake by Ludwig");
//		 primaryStage.setScene(newScene);
//		
	    primaryStage.setScene(new Scene(ws.scene(snakeCreateScene())));
//		primaryStage.setScene(snakeCreateScene());
	    primaryStage.show();
		
	
		
	}

}
