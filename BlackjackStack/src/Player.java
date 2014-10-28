import java.util.List;

public abstract class Player {
	private Hand hand;
	
	// private Dealer dealer;
	private String name;

	// Constructor for Player, referencing our hand field and setting it to our
	// hand object
	public Player(String name) {
		hand = new Hand();
		this.name = name;

	}

	// Getter for Hand
	public Hand getHand() {
		return hand;
	}

	// Getter for our name that we set to Player
	public String getName() {
		return name;
	}

	// Add cards to our list of Cards
	public void addCards(List<Card> cards) {

		hand.addCards(cards);

	}

	// Delegation method for Hand's calculateHandValue
	public int calculateHandValue() {
		return hand.calculateHandValue();
	}

	// toString method for our name, and the class Hand's toString method.
	@Override
	public String toString() {

		return name + ": " + hand.toString();
	}

	// Creating enum for Action, so we have the predefined constants
	public enum Action {
		HIT, STAY, INVALID
	}

	// Creating an abstract method for the subclasses
	public abstract Action getAction();

}
