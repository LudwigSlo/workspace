import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Hand {

	private List<Card> cards; // note the Card class, it's a lot more practical
								// than a string

	// oh, and you need a constructor, so you can initiate the list. because
	// right now, you declared it, but havent assigned a value to it
	// that way, every time you create a new instance of the Hand class, the
	// constructor will be called, and a new empty list will be created.

	Hand() {
		this.cards = new ArrayList<Card>();

	}

	// Adding cards
	public void addCards(List<Card> cardstoAdd) {
		cards.addAll(cardstoAdd);
	}

	// Getter for cards
	public List<Card> getCards() {
		return cards;
	}

	// so to later calculate the value of a hand, you would just iterate over
	// all cards in the hand, call card.getRank().getValue() which gets the
	// value, and add all those up
	// public SomeEnumOrClass calculateHandValue() {
	// // calculate the best possible hand
	// }
	public int calculateHandValue() {
		int total = 0;
		for (Card card : cards) {

			total += card.getRank().getValue();

		}

		return total;

	}

	   @Override
	    public String toString() {
	        List<String[]> splitCards = new ArrayList<>();
	        String cardsString = "";
	        for (Card card : cards) {
	            splitCards.add(card.toString().split("\n"));
	        }
	        for (int i = 0; i < splitCards.get(0).length; i++) {
	            for (String[] splitCard : splitCards) {
	                cardsString += splitCard[i];
	            }
	            cardsString += "\n";
	        }
	        return cardsString;
	    }
}