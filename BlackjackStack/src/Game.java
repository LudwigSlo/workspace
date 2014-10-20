import java.util.Scanner;

public class Game {

	private Dealer dealer; // dealer has a Deck
	private Player player; // player has a hand,

	public Game() {
		this.dealer = new Dealer();
		player = new ConsolePlayer("Player");

	}

	// The actual game being played one round
	public void playOneRound() {

		dealer.shuffle();
		dealer.initialDeal(player);
		threadSleep();
		System.out.println(player.toString());
		System.out.println(dealer.toString());
		threadSleep();
		performAction(player);
		threadSleep();
		performAction(dealer);
		threadSleep();
		whoWon();
	}
	
	public void threadSleep(){
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	//Method if the player wants to play again or not, creating a new Game instance to flush out the old data.
	@SuppressWarnings("resource")
	public void playAgain() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to play again? Yes/No");
		String playAgain = scan.nextLine();
		if (playAgain.equalsIgnoreCase("Yes")) {
			Game game = new Game();
			game.playOneRound();
		} else {
			System.out
					.println("The game will shut down. \nThanks for playing!");
			System.exit(1);
		}

	}
	//Method for who won, and calling the playAgain method if they want to play again or not.
	public void whoWon() {
		System.out.println("Calculating a winner...");
		if (player.calculateHandValue() > dealer.calculateHandValue()) {
			System.out.println("The player won!");
		} else if (player.calculateHandValue() < dealer.calculateHandValue()) {
			System.out.println("The dealer won!");
		} else {
			System.out.println("Draw!");
		}
		playAgain();
	}
	
	//Performing the action for Player(Player/Dealer), made in that way that both the Dealer and the "Player" is a player
	public void performAction(Player player) {
		
		System.out.println("The score for " + player.getName() + " is "
				+ player.calculateHandValue());

		if (player.calculateHandValue() == 21) {
			System.out.println(player.getName() + " won, " + player.getName()
					+ " got 21!");
			playAgain();
		}

		//Switch for the getAction, such as HIT, STAY, or INVALID, depending on the user input
		switch (player.getAction()) {
		//If the player wants to Hit (or if the dealer has under 17 in score, then make the dealer hit)
		case HIT:
			dealer.deal(player, 1);
			System.out.println(player.toString());

			if (player.calculateHandValue() < 21) {
				performAction(player);}
			else {
				System.out.println(player.getName()
						+ " got over 21, and busted. " + player.getName()
						+ " lose!");
				playAgain();}
			//If Stay, just return
		case STAY:
			return;
			//If the user tries to input something strange, or mistypes, then call the performAction method again.
		case INVALID:
			System.out.println("Something went wrong. Try again.");
			performAction(player);
		}
	}
}
