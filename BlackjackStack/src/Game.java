import java.util.Scanner;

public class Game {

	private Dealer dealer; // dealer has a Deck
	private Player player; // player has a hand,

	// methods such as getTotalValue, etc

	public Game() {
		this.dealer = new Dealer();
		player = new ConsolePlayer("Player");
		
	}

	public void playOneRound() {

		dealer.shuffle();
		dealer.initialDeal(player);
		System.out.println(player.toString());
		System.out.println(dealer.toString());
		performAction(player);
		performAction(dealer);
		whoWon();
	}
	public void whoWon(){
		System.out.println("Calculating a winner...");
		if(player.calculateHandValue() > dealer.calculateHandValue()){
			System.out.println("The player won!");
		}
		else if(player.calculateHandValue() < dealer.calculateHandValue()){
			System.out.println("The dealer won!");
		}
		else{
			System.out.println("Draw!");
		}
	}
	public void performAction(Player player) {
		switch (player.getAction()) {
		case HIT:
			dealer.deal(player, 1);
			System.out.println(player.toString());
			if(player.calculateHandValue() < 21){
				performAction(player);
			}
			else if(player.calculateHandValue() == 21){
				System.out.println(player +" won, you got 21!");
			}
			else{
				System.out.println(player+" got over 21, and busted. You lose!");
			System.exit(1);
			}
			
		case STAY:
			return;
		case INVALID:
			System.out.println("Something went wrong. Try again.");
			performAction(player);
		}
	}
}

// if you want to add another player, you just add this.player.add(new
// Player()); in the game constructor.
//
// you would need to get user input, to know if the player wants to hit or stay.
// and then either call the deal method in Dealer with the player and 1 as
// argument, or dont (if they want to stay)