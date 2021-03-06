package blackjack;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Scanner;



/**
 * The Class Game.
 * 
 *@author Ludwig Slotte <a href="mailto:Ludwig_Slotte@hotmail.com">Ludwig_Slotte@hotmail.com</a>
 *@version 1.0
 */
 
public class Game {

	/** The dealer. */
	private Dealer dealer;
	
	/** The player. */
	private Player player;
	
	/**
	 * This constructs the player and dealer.
	 */ 
	
	public Game() {
		this.dealer = new Dealer();
		player = new ConsolePlayer("Player");

	}

	// The actual game being played one round

	/**
	 * Play one round.
	 */
	public void playOneRound() { 
		
		dealer.shuffle();
		dealer.initialDeal(player);
		threadSleep();

		System.out.println(player.toString());
		System.out.println(dealer.toString());
		System.out.println("Dealer also drew a hidden card he will reveal when it's his turn.");
		threadSleep();

		performAction(player);
		printToFile(player);
		threadSleep();
		
		performAction(dealer);
		printToFile(dealer);
		threadSleep();

		whoWon();
	}
	
	/**
	 * Thread sleep.
	 * 
	 * We can set a value on how long we want the thread to sleep, from zero and up.
	 */
	
	public void threadSleep() {
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Play again.
	 */
	
	@SuppressWarnings("resource") //Telling the compiler that what we are doing at execution time is legal
	public void playAgain() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to play again? 'Yes' or 'No'");
		String playAgain = scan.nextLine();
		if (playAgain.equalsIgnoreCase("Yes")) {
			Game game = new Game();
			game.playOneRound();

		} else if (playAgain.equalsIgnoreCase("No")) {
			System.out
					.println("The game will shut down. \nThanks for playing!");
			System.exit(1);
		} else {
			System.err.println("Something went wrong. Try again.");
			playAgain();
		}

	}

	
	/**
	 * Who won.
	 */
	public void whoWon() {
		System.out.println("Calculating a winner...");
		
		if(player.calculateHandValue() > 21){
			System.out.println("The dealer won! Player busted with the score: " + player.calculateHandValue());
		} else if(dealer.calculateHandValue() > 21){
			System.out.println("The player won! Dealer busted with the score: " + dealer.calculateHandValue());		
		} else if (player.calculateHandValue() > dealer.calculateHandValue()) {
			System.out.println("The player won!");
		} else if (player.calculateHandValue() < dealer.calculateHandValue()) {
			System.out.println("The dealer won!");
		} else {
			System.out.println("Draw, the Dealer won! Dealer wins all ties.");
		}
		playAgain();
	}

	/*
	 * Performing the action for Player(Player/Dealer), made in that way that
	 * both the Dealer and the "Player" is a player
	 */
	/**
	 * Perform action.
	 *
	 * @param player the player
	 */
	public void performAction(Player player) {

		System.out.println("The score for " + player.getName() + " is "
				+ player.calculateHandValue());

		if (player.calculateHandValue() == 21) {
			System.out.println(player.getName() + " won, " + player.getName()
					+ " got 21!");

			playAgain();
		}
	/*	else if(player.calculateHandValue() > 21){ 
			whoWon();
		}
*/
		// Switch for the getAction, such as HIT, STAY, or INVALID, depending on
		// the user input
		switch (player.getAction()) {

		// If the player wants to Hit 
		case HIT:
			dealer.deal(player, 1);
			System.out.println(player.toString());

			if (player.calculateHandValue() < 21) {
				performAction(player);
			} else {
				whoWon();
			}

			// If Stay, just return
		case STAY:
			return;

			// If the user tries to input something strange, or mistypes, then
			// call the performAction method again.
		case INVALID:
			System.err.println("Something went wrong. Try again.");
			performAction(player);
		}
	}
	/**
	 * Prints the results to file.
	 *
	 * @param player the player
	 */
	public void printToFile(Player player) {
		java.util.Date date = new java.util.Date();

		try {
			PrintWriter writer = new PrintWriter(new BufferedWriter(
					new FileWriter("C:\\Test\\BlackjackLog.txt", true)));
			writer.println((new Timestamp(date.getTime())) + " - "
					+ player.getName()
					+ " played a game of Blackjack and got the score: "
					+ player.calculateHandValue());
			writer.flush();
			writer.close();

			System.out.println("Printing " + player.getName()
					+ "'s score to the logg. Directory: C:\\Test\\BlackjackLog.txt");
		} catch (Exception e) {
			System.err
					.println("Something went wrong. Couldn't write the data to the specified file.");
		}
	}
}
