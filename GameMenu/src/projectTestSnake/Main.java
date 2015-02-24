package projectTestSnake;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main  {

	public static final int BLOCK_SIZE = 40;
	public static final int APP_W = 20 * BLOCK_SIZE;
	public static final int APP_H = 15 * BLOCK_SIZE;
	public static final int POINTS = 10;
	private SimpleIntegerProperty gamePoints = new SimpleIntegerProperty();
	private GameMenu gameMenu;
	private Direction direction;
	private boolean moved = false;
	private boolean running = false;
	private boolean pressedStart = false;
	private Timeline timeline = new Timeline();
	private ObservableList<Node> snake;
	
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
		
		Pane root = new Pane();
		root.setPrefSize(APP_W, APP_H);

		Group snakeBody = new Group();
		snake = snakeBody.getChildren();

		gameMenu = new GameMenu();
		gameMenu.setVisible(false);

		Rectangle food = new Rectangle(BLOCK_SIZE, BLOCK_SIZE);
		food.setFill(Color.BLUE);
		food.setTranslateX((int) (Math.random() * (APP_W - BLOCK_SIZE))
				/ BLOCK_SIZE * BLOCK_SIZE);
		food.setTranslateY((int) (Math.random() * (APP_H - BLOCK_SIZE))
				/ BLOCK_SIZE * BLOCK_SIZE);
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

					// collision
					for (Node rect : snake) {
						if (rect != tail
								&& tail.getTranslateX() == rect.getTranslateX()
								&& tail.getTranslateY() == rect.getTranslateY()) {
							restartGame();
							break;
						}
					}

					if (tail.getTranslateX() < 0
							|| tail.getTranslateX() >= APP_W
							|| tail.getTranslateY() < 0
							|| tail.getTranslateY() >= APP_H) {
						restartGame();
					}

					if (tail.getTranslateX() == food.getTranslateX()
							&& tail.getTranslateY() == food.getTranslateY()) {
						food.setTranslateX((int) (Math.random() * (APP_W - BLOCK_SIZE))
								/ BLOCK_SIZE * BLOCK_SIZE);
						food.setTranslateY((int) (Math.random() * (APP_H - BLOCK_SIZE))
								/ BLOCK_SIZE * BLOCK_SIZE);

						Rectangle rect = new Rectangle(BLOCK_SIZE, BLOCK_SIZE);
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
		textScore.setTranslateY(20);
	
		root.getChildren().addAll(textScore, food, snakeBody, gameMenu);
		return root;

	}



	public void restartFromMenu() {

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
//		createContent();
		System.out.println("STARTED GAME");
		setDirection(Direction.RIGHT);
		Rectangle head = new Rectangle(BLOCK_SIZE, BLOCK_SIZE);
		System.out.println(head);
		System.out.println(snake );
		snake.add(head);
		
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

			SnakeMenu btnResume = new SnakeMenu("RESTART");
			btnResume.setOnMouseClicked(event -> {
				FadeTransition ft = new FadeTransition(Duration.seconds(0.5),
						this);
				ft.setFromValue(1);
				ft.setToValue(0);
				ft.setOnFinished(evt -> setVisible(false));
				ft.play();
				
				
				setDirection(Direction.CONTINUE);
				getTimeline().play();
				

			});

			SnakeMenu btnOptions = new SnakeMenu("OPTIONS");
			btnOptions.setOnMouseClicked(event -> {
				getChildren().add(menu1);

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
				System.exit(0);
			});

			SnakeMenu btnBack = new SnakeMenu("BACK");
			btnBack.setOnMouseClicked(event -> {
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
			menu1.getChildren().addAll(btnBack);
			Rectangle bg = new Rectangle(800, 600);
			bg.setFill(Color.GREY);
			bg.setOpacity(0.4);

			getChildren().addAll(bg, menu0);
		}

	}

}
