package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * The Class Deck.
 * 
 *@author Ludwig Slotte <a href="mailto:Ludwig_Slotte@hotmail.com">Ludwig_Slotte@hotmail.com</a>
 *@version 1.0
 */

public class Deck {

	// Putting our Cards class into a list.
	/** The cards. */
	List<Card> cards;
	
	/**
	 * Instantiates a new deck.
	 * 
	 * Putting our ranks and suits from the class Card,
	 * into arrays that we can
	 * loop through, and get all the cards.
	 */
	
	public Deck() {
		cards = new ArrayList<>();
		Card.Rank[] ranks = Card.Rank.values();		// Getting the Rank values from	the Enum Rank and putting them into an array.
		Card.Suit[] suits = Card.Suit.values();	    // Getting the Suit values from the Enum Suit and putting them into an array.
		for (Card.Rank rank : ranks) { 				// For each loop to loop through ranks.
			for (Card.Suit suit : suits) { 			// For each loop to loop through suits.
				cards.add(new Card(rank, suit)); 	// Create a new instance of the Card class and adding our cards.
			}
		}
	}

	/**
	 * Shuffle.
	 */
	
	public void shuffle() {
		Collections.shuffle(cards); 
	}
	
	/**
	 * Gets the cards.
	 *
	 * @param amount the amount
	 * @return the cards
	 */
	
	public List<Card> getCards(int amount) { //We return the amount of cards that is specified, from 1 to 52.
		if (cards.size() < amount) {
			throw new IllegalArgumentException("Not enough cards left");  //If all the cards are dealt, that means the deck is empty and we can't give out more cards
		}
		List<Card> selectedCards = new ArrayList<>();
		Iterator<Card> iterator = cards.iterator();
		int i = 0;
		while (iterator.hasNext() && i < amount) {
			selectedCards.add(iterator.next());
			iterator.remove();
			i++;
		}
		return selectedCards;
	}
	

}
