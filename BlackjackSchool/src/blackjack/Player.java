package blackjack;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 * 
 *@author Ludwig Slotte <a href="mailto:Ludwig_Slotte@hotmail.com">Ludwig_Slotte@hotmail.com</a>
 *@version 1.0
 */

public abstract class Player {
	
	/** The hand. */
	private Hand hand;
	
	/** The player money. */
	private int playerMoney = 100;
	
	/** The name. */
	private String name;
	
	
	// Constructor for Player, referencing our hand field and setting it to our
	// hand object
	/**
	 * Instantiates a new player.
	 *
	 * @param name the name
	 */
	public Player(String name) {
		hand = new Hand();
		this.name = name;

	}
	
	/**
	 * Gets the hand.
	 *
	 * @return the hand
	 */
	public Hand getHand() {
		return hand;
	}

	// Getter for our name that we set to Player
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Adds the cards.
	 *
	 * @param cards the cards
	 */
	
	public void addCards(List<Card> cards) {

		hand.addCards(cards);

	}
	
	/**
	 * Calculate hand value.
	 *
	 * @return the int
	 */
	// Delegation method for Hand's calculateHandValue
	public int calculateHandValue() {
		return hand.calculateHandValue();
	}

	// toString method for our name, and the class Hand's toString method.
	/**
	 * toString for our name, and hand.
	 */
	@Override
	public String toString() {

		return name + ": " + hand.toString();
	}

	
	/**
	 * The Enum Action.
	 */
	public enum Action {
		
		/** The hit. */
		HIT, 
		/** The stay. */
		STAY, 
		/** The invalid. */
		INVALID
	}

	
	/**
	 * Abstract method to get Action later on.
	 *
	 * @return the action
	 */
	public abstract Action getAction();

}
