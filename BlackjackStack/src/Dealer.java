import java.util.List;

public class Dealer extends Player {
	// creating field of Deck, fields store state of object
	private Deck deck;



	// generally, all any constructor should do is initiate the fields of the
	// class (well, at least in many cases)
	public Dealer() {
		super("Dealer");
		// the deck field to our Deck object
		deck = new Deck();
	}

	public void shuffle() {
		deck.shuffle();
	}

	// Having list if we later on want to add more players to play

	public void initialDeal(Player player) {
		
		deal(player, 2);
		deal(this, 1);
		
	}

	public void deal(Player player, int amountOfCards) {

		player.addCards(deck.getCards(amountOfCards));
		
	}

	

	@Override
	// return super since we extend from Player, and Player is the super class
	public String toString() {
		return super.toString();
	}


	public Action getAction() {
		if(getHand().calculateHandValue() > 17){
		return Action.STAY;
		}
		else {
		return Action.HIT;
		}
		
	}
}
