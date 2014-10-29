package blackjack;
import java.util.ArrayList;
import java.util.List;


/**
 * The Class Hand.
 * 
 *@author Ludwig Slotte <a href="mailto:Ludwig_Slotte@hotmail.com">Ludwig_Slotte@hotmail.com</a>
 *@version 1.0
 */

public class Hand {

	/** The cards. */
	private List<Card> cards;
	
	/**
	 * Instantiates a new hand.
	 */
	Hand() {
		this.cards = new ArrayList<Card>();
	}
	
	/**
	 * Adds the cards.
	 *
	 * @param cardstoAdd The cards to add
	 */
	public void addCards(List<Card> cardstoAdd) {
		cards.addAll(cardstoAdd);
	}
	
	/**
	 * Gets the cards.
	 *
	 * @return the cards
	 */
	public List<Card> getCards() {
		return cards;
	}
	
	/**
	 * Calculate hand value.
	 * 
	 * A method for calculating hand value. Iterating over our cards and calling
	 * the getters for Rank and Value from the Class Card.
	 * Then setting that value to our total variable, so that every time a card
	 * gets added, it will iterate over the cards and get the total of those
	 * cards.
	 *
	 * @return The cards total
	 */
	
	public int calculateHandValue() {
		int total = 0;
		for (Card card : cards) {
			total += card.getRank().getValue();
		}
		return total;
	}

	/**
	 * Splitting the cards and printing them out horizontally, line by line.
	 *
	 * @return the string
	 */
	
	@Override
	public String toString() {								
		List<String[]> splitCards = new ArrayList<>(); 		// Creating a new ArrayList.
		String cardsString = ""; 							// Creating a String variable.
		for (Card card : cards) {						 	// A for each loop - looping over the object cards.
			splitCards.add(card.toString().split("\n")); 	// Adding the splitted Strings to splitCards every time "\n" is found.
		}
		for (int i = 0; i < splitCards.get(0).length; i++) {	// A for loop that	will loop through splitCards, starting at index 0.
			for (String[] splitCard : splitCards) { 			// A For each loop that will loop through splitCards, and add them to an String Array.
				cardsString += splitCard[i]; 					// Setting our String to the Array splitCard, and also getting its Index, so we get it in the right order.
			}
			cardsString += "\n"; 								// Every time cardsString is called we print a new line after it.
		}
		return cardsString;
	}
}