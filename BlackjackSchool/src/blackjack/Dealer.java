package blackjack;


/**
 * The Class Dealer.
 * 
 @author Ludwig Slotte <a href="mailto:Ludwig_Slotte@hotmail.com">Ludwig_Slotte@hotmail.com</a>
 @version 1.0
 */

public class Dealer extends Player {
	// creating field of Deck. Fields store state of object.
	/** The deck. */
	private Deck deck;
	

	// Constructor to initiate the field of deck, and also putting in an
	// argument to match the super class (Player).
	/**
	 * Instantiates a new dealer.
	 */
	public Dealer() {
		super("Dealer");
		deck = new Deck();
		
	}

	// Creating a method so we could call the class deck and their method
	// shuffle, so the dealer can shuffle the Cards
	/**
	 * Shuffle.
	 */
	public void shuffle() {
		deck.shuffle();
	}

	// A method for when the game starts, we should always deal 2 cards to
	// player and 1 to dealer
	/**
	 * Initial deal.
	 *
	 * @param player the player
	 */
	public void initialDeal(Player player) {

		deal(player, 2);
		deal(this, 1);
		

	}

	// A method for when we want the dealer to deal cards to the object player
	// (either Dealer or Player)
	/**
	 * Deal.
	 *
	 * @param player the player
	 * @param amountOfCards the amount of cards
	 */
	public void deal(Player player, int amountOfCards) {
		player.addCards(deck.getCards(amountOfCards));
	}

	/**
	 * toString for super
	 */
	@Override
	// return super since we extend from Player, and Player is the super class
	public String toString() {
		return super.toString();
	}

	// A subclass of the abstract class from Player, so the Dealer gets
	// "automated" on what it should do
	// Such as if the dealer handValue is under 17, he should hit, else Stay.
	/**
	 * Dealer automated getAction, hit if above 17.
	 */
	public Action getAction() {
		if (getHand().calculateHandValue() > 17) {
			return Action.STAY;
		} else {
			return Action.HIT;
		}

	}
	

	


}
