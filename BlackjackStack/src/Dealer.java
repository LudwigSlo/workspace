import java.util.Scanner;

public class Dealer extends Player {
	// creating field of Deck. Fields store state of object.
	private Deck deck;
	private ConsolePlayer cp;

	// Constructor to initiate the field of deck, and also putting in an
	// argument to match the super class (Player).
	public Dealer() {
		super("Dealer");
		deck = new Deck();
	}

	// Creating a method so we could call the class deck and their method
	// shuffle, so the dealer can shuffle the Cards
	public void shuffle() {
		deck.shuffle();
	}

	// A method for when the game starts, we should always deal 2 cards to
	// player and 1 to dealer
	public void initialDeal(Player player) {

		deal(player, 2);
		deal(this, 1);
		

	}

	// A method for when we want the dealer to deal cards to the object player
	// (either Dealer or Player)
	public void deal(Player player, int amountOfCards) {
		player.addCards(deck.getCards(amountOfCards));
	}

	@Override
	// return super since we extend from Player, and Player is the super class
	public String toString() {
		return super.toString();
	}

	// A subclass of the abstract class from Player, so the Dealer gets
	// "automated" on what it should do
	// Such as if the players handValue is under 17, he should hit, else Stay.
	public Action getAction() {
		if (getHand().calculateHandValue() > 10) {
			return Action.STAY;
		} else {
			return Action.HIT;
		}

	}
	public int determineWinnings(Player player) {
		
		System.out.println("Calculating a winner...");
	//	if (player.calculateHandValue() > this.calculateHandValue()) {
			System.out.println("The player won!");
			int calculateWinning = cp.getBet();
			calculateWinning = calculateWinning + getPlayerMoney();
			System.out.println("Your new balance is €" + calculateWinning);
		//	takePlayerMoney(calculateWinning);
			return calculateWinning;
	//	} else if (player.calculateHandValue() < this.calculateHandValue()) {
	//		System.out.println("The dealer won!");
//		} else {
		//	System.out.println("Draw, the Dealer won! Dealer wins all ties.");
	//	}
		
	}

	public int getBet() {
		throw new UnsupportedOperationException();
	}


}
