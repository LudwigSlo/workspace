package blackjack;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class ConsolePlayer.
 * 
 *@author Ludwig Slotte <a href="mailto:Ludwig_Slotte@hotmail.com">Ludwig_Slotte@hotmail.com</a>
 *@version 1.0
 */

public class ConsolePlayer extends Player {

	/**
	 * Instantiates a new console player.
	 *
	 * @param name the name
	 */
	public ConsolePlayer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * User input from getAction
	 */
	@SuppressWarnings("resource")
	@Override
	public Action getAction() {

		Scanner scan = new Scanner(System.in);

		System.out.println("Hit or stay?");
		String userInput = scan.nextLine(); 

		if (userInput.equalsIgnoreCase("Hit")) {
			return Action.HIT;
		} else if (userInput.equalsIgnoreCase("Stay")) {
			return Action.STAY;
		} else
			return Action.INVALID;
	}
	
}
