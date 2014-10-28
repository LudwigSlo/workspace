package blackjack;


/**
 * The Class Main.
 *
 * @author Ludwig Slotte <a href="mailto:Ludwig_Slotte@hotmail.com">Ludwig_Slotte@hotmail.com</a>
 */

public class Main {

	/**
	 * The main method.
	 *
	 * @param args The arguments
	 * @throws InterruptedException The interrupted exception
	 */
	public static void main(String[] args) throws InterruptedException {
		WelcomeMessage welcome = new WelcomeMessage();
		Game game = new Game();
	//	welcome.displayWelcomeMessage();
		game.playOneRound();
	}

}
