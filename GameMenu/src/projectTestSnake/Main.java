package projectTestSnake;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.util.Duration;

public class Main  {
	 private static final AudioClip ALERT_AUDIOCLIP = new AudioClip(Main.class.getResource("/alert.wav").toString());
	 private static final AudioClip MENU_AUDIOCLIP = new AudioClip(Main.class.getResource("/menuClick.wav").toString());
	 private static final AudioClip GAMEOVER_AUDIOCLIP = new AudioClip(Main.class.getResource("/gameOver.wav").toString());
	public static final int BLOCK_SIZE = 40;
	public static final int APP_W = 24 * BLOCK_SIZE;
	public static final int APP_H = 19 * BLOCK_SIZE;
	public static final int POINTS = 10;
	private SimpleIntegerProperty gamePoints = new SimpleIntegerProperty();
	private GameMenu gameMenu;
	private Direction direction;
	private boolean moved = false;
	private boolean running = false;
	private boolean pressedStart = false;
	private Timeline timeline = new Timeline();
	private ObservableList<Node> snake;
	private Rectangle food = new Rectangle(BLOCK_SIZE, BLOCK_SIZE);
	// <---------------------------------------- START OF GETTERS / SETTERS ------------------------------------------>


	public ObservableList<Node> getSnake() {
		return snake;
	}

	public void setSnake(ObservableList<Node> snake) {
		this.snake = snake;
	}

	public SimpleIntegerProperty getGamePoints() {
		return gamePoints;
	}

	public void setGamePoints(SimpleIntegerProperty gamePoints) {
		this.gamePoints = gamePoints;
	}

	public void addGamePoints(SimpleIntegerProperty gamePoints) {
		this.gamePoints = gamePoints;

	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public Timeline getTimeline() {
		return timeline;
	}
	
	public void setTimeline(Timeline timeline) {
		this.timeline = timeline;
	}
	
	public boolean isMoved() {
		return moved;
	}
	
	public void setMoved(boolean moved) {
		this.moved = moved;
	}
	
	public boolean isPressedStart() {
		return pressedStart;
	}
	
	public void setPressedStart(boolean pressedStart) {
		this.pressedStart = pressedStart;
		
	}
	
	// <---------------------------------------- END OF GETTERS / SETTERS ------------------------------------------>


	public Parent createContent() {
		
		
		  Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
		
		
		Pane root = new Pane();
		root.setPrefSize(visualBounds.getWidth() / 2, visualBounds.getHeight() / 1.41);
		String css = Main.class.getResource("/game.css").toExternalForm();
		root.getStylesheets().clear();
		root.getStylesheets().add(css);
	       
		Group snakeBody = new Group();
		snake = snakeBody.getChildren();

		gameMenu = new GameMenu();
		gameMenu.setVisible(false);

//		Circle food = new Circle(BLOCK_SIZE / 2);
//		food.setFill(Color.RED);
//		food.setTranslateX((int) (Math.random() * (APP_W - BLOCK_SIZE))
//				/ BLOCK_SIZE * BLOCK_SIZE);
//		food.setTranslateY((int) (Math.random() * (APP_H - BLOCK_SIZE))
//				/ BLOCK_SIZE * BLOCK_SIZE);
		generateFood();
		KeyFrame frame = new KeyFrame(
				Duration.seconds(0.2),
				event -> {
					if (!running) {

						return;
					}
					
					
					boolean toRemove = snake.size() > 1;

					Node tail = toRemove ? snake.remove(snake.size() - 1)
							: snake.get(0);

					double tailX = tail.getTranslateX();
					double tailY = tail.getTranslateY();

					switch (getDirection()) {
					case UP:
						tail.setTranslateX(snake.get(0).getTranslateX());
						tail.setTranslateY(snake.get(0).getTranslateY()
								- BLOCK_SIZE);
						break;
					case DOWN:
						tail.setTranslateX(snake.get(0).getTranslateX());
						tail.setTranslateY(snake.get(0).getTranslateY()
								+ BLOCK_SIZE);
						break;
					case LEFT:
						tail.setTranslateX(snake.get(0).getTranslateX()
								- BLOCK_SIZE);
						tail.setTranslateY(snake.get(0).getTranslateY());
						break;
					case RIGHT:
						tail.setTranslateX(snake.get(0).getTranslateX()
								+ BLOCK_SIZE);
						tail.setTranslateY(snake.get(0).getTranslateY());
						break;
					case CONTINUE:
						System.out.println("HERE");
						tail.setTranslateX(snake.lastIndexOf(tailX)
								+ BLOCK_SIZE);
						tail.setTranslateY(snake.lastIndexOf(tailY));
						getTimeline().playFromStart();
						break;
					case PAUSE:
						System.out.println("PAUSE");

						if (!gameMenu.isVisible()) {

							FadeTransition ft = new FadeTransition(Duration
									.seconds(0.5), gameMenu);
							ft.setFromValue(0);
							ft.setToValue(1);

							gameMenu.setVisible(true);
							ft.play();
							getTimeline().pause();
						}

						else {
							FadeTransition ft = new FadeTransition(Duration
									.seconds(0.5), gameMenu);
							ft.setFromValue(1);
							ft.setToValue(0);
							ft.setOnFinished(evt -> gameMenu.setVisible(false));
							ft.play();

						}
						break;
					}

					setMoved(true);

					if (toRemove) {
						snake.add(0, tail);
					}

					// Snake hits self
					for (Node rect : snake) {
						if (rect != tail
								&& tail.getTranslateX() == rect.getTranslateX()
								&& tail.getTranslateY() == rect.getTranslateY()) {
							restartGame();
							Main.GAMEOVER_AUDIOCLIP.play();
							break;
						}
					}
					
					// Snake hits wall/border

					if (tail.getTranslateX() < 0 || tail.getTranslateX() >= visualBounds.getWidth() / 2 || tail.getTranslateY() < 0 || tail.getTranslateY() >= visualBounds.getHeight()/ 1.43) {

						restartGame();
//						Main.GAMEOVER_AUDIOCLIP.play();
					}

					if (tail.getTranslateX() == food.getTranslateX()
							&& tail.getTranslateY() == food.getTranslateY()) {
	
						generateFood();
						
					    Main.ALERT_AUDIOCLIP.play();
						Rectangle rect = new Rectangle(BLOCK_SIZE, BLOCK_SIZE);
						rect.getStyleClass().add("rectSnake");
						rect.setTranslateX(tailX);
						rect.setTranslateY(tailY);

						gamePoints.set(gamePoints.get() + (int) POINTS);
						System.out.println(getGamePoints());
						snake.add(rect);

					}
				});

		getTimeline().setCycleCount(Timeline.INDEFINITE);
		getTimeline().getKeyFrames().add(frame);

		Text textScore = new Text();
		textScore.textProperty().bind(
				new SimpleStringProperty("Points: ").concat(gamePoints
						.asString()));
		textScore.setFont(new Font(20));
		textScore.setTranslateX(20);
		textScore.setTranslateY(730);
		
		textScore.getStyleClass().add("textScore");
	
		root.getChildren().addAll(textScore, food, snakeBody, gameMenu);
		return root;

	}

	public void generateFood(){
	
		food.setFill(Color.RED);
		food.setTranslateX((int) (Math.random() * (APP_W - BLOCK_SIZE))
				/ BLOCK_SIZE * BLOCK_SIZE);
		food.setTranslateY((int) (Math.random() * (APP_H - BLOCK_SIZE))
				/ BLOCK_SIZE * BLOCK_SIZE);
		food.getStyleClass().add("rectFood");
	}

	public void restartFromMenu() {
		generateFood();
		setDirection(Direction.CONTINUE);
		getTimeline().play();
		System.out.println(getDirection());
		running = true;

	}

	private void removeAllPoints() {
		gamePoints.set(0);

	}

	public void restartGame() {
		stopGame();
		startGame();
	}

	public void startGame() {
		
		setDirection(Direction.RIGHT);
		Rectangle head = new Rectangle(BLOCK_SIZE, BLOCK_SIZE);

		snake.add(head);
		head.getStyleClass().add("rectSnake");
		getTimeline().play();
		running = true;
	}

	public void stopGame() {
		running = false;
		getTimeline().stop();
		removeAllPoints();
		snake.clear();
	}



	
	
	private class GameMenu extends Parent {

		public GameMenu() {
			VBox menu0 = new VBox(10);
			VBox menu1 = new VBox(10);

			menu0.setTranslateX(50);
			menu0.setTranslateY(200);

			menu1.setTranslateX(50);
			menu1.setTranslateY(200);

			final int offset = 400;

			menu1.setTranslateX(offset);
			
			SnakeMenu btnSetLevel = new SnakeMenu("SET LEVEL");
			btnSetLevel.setOnMouseClicked(event -> {
				
				
				KeyFrame key = new KeyFrame(Duration.seconds(0.2));
				
		
				
				   timeline.stop();
				   timeline.getKeyFrames().setAll(
			                key
			        );
				   timeline.play();
				   
				
				
				
				});
			
			

			SnakeMenu btnResume = new SnakeMenu("RESTART");
			btnResume.setOnMouseClicked(event -> {
				Main.MENU_AUDIOCLIP.play();
				
				FadeTransition ft = new FadeTransition(Duration.seconds(0.5),
						this);
				ft.setFromValue(1);
				ft.setToValue(0);
				ft.setOnFinished(evt -> setVisible(false));
				ft.play();
					timeline.stop();
				   timeline.play();
				setDirection(Direction.CONTINUE);
//				getTimeline().play();
				

			});

			SnakeMenu btnOptions = new SnakeMenu("OPTIONS");
			btnOptions.setOnMouseClicked(event -> {
				getChildren().add(menu1);
				Main.MENU_AUDIOCLIP.play();
				TranslateTransition tt = new TranslateTransition(Duration
						.seconds(0.25), menu0);
				tt.setToX(menu0.getTranslateX() - offset);

				TranslateTransition tt1 = new TranslateTransition(Duration
						.seconds(0.5), menu1);
				tt1.setToX(menu0.getTranslateX());

				tt.play();
				tt1.play();

				tt.setOnFinished(evt -> {
					getChildren().remove(menu0);
				});
			});

			SnakeMenu btnExit = new SnakeMenu("EXIT");
			btnExit.setOnMouseClicked(event -> {
				
				Main.MENU_AUDIOCLIP.play();
				System.exit(0);
			});

			SnakeMenu btnBack = new SnakeMenu("BACK");
			btnBack.setOnMouseClicked(event -> {
				Main.MENU_AUDIOCLIP.play();
				
				getChildren().add(menu0);
				TranslateTransition tt = new TranslateTransition(Duration
						.seconds(0.25), menu1);
				tt.setToX(menu1.getTranslateX() + offset);

				TranslateTransition tt1 = new TranslateTransition(Duration
						.seconds(0.5), menu0);
				tt1.setToX(menu1.getTranslateX());
				tt.play();
				tt1.play();

				tt.setOnFinished(evt -> {
					getChildren().remove(menu1);
				});
				
				
				
				
			});
			
			

			Text textScore = new Text();
			textScore.textProperty().bind(
					new SimpleStringProperty("Your final score: ")
							.concat(gamePoints.asString()));
			textScore.setFont(new Font(20));

			menu0.getChildren().addAll(textScore, btnResume, btnOptions,
					btnExit);
			menu1.getChildren().addAll(btnBack, btnSetLevel);
			Rectangle bg = new Rectangle(1000, 800);
			bg.setFill(Color.GREY);
			bg.setOpacity(0.4);

			getChildren().addAll(bg, menu0);
		}

	}

}
