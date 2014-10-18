import java.util.List;

import java.util.ArrayList;
import java.util.*;
import java.awt.*;

public class Deck {
	// Putting our Cards class into a list.
	// cards and amount (amount = how many cards to give).
	List<Card> cards;
	private List<Card> amount;

	// Deck constructor, putting our ranks and suits into arrays that we can
	// loop through, and get all the cards.
	public Deck() {
		cards = new ArrayList<>();
		Card.Rank[] ranks = Card.Rank.values(); //Getting the Rank values from the Enum Rank and putting them into an array.
		Card.Suit[] suits = Card.Suit.values(); //Getting the Suit values from the Enum Suit and putting them into an array.
		for (Card.Rank rank : ranks) {          //For each loop to loop through ranks.
			for (Card.Suit suit : suits) {		//For each loop to loop through suits.
				cards.add(new Card(rank, suit)); // create a new instance of the Card class and adding our cards.
			}
		}
	}

	// Shuffle our cards that we generated from Deck
	public void shuffle() {
		Collections.shuffle(cards); //Using the inbuilt shuffle function from Collections.
	}

	// Amount of cards that we want to return

	//there are basically two changes: the first thing we do is to check if there are even enough cards left.
	//if not, we throw an exception. the second thing is, that we actually only return amount cards, not all of them

	public List<Card> getCards(int amount) {
	    if (cards.size() < amount) {
	        throw new IllegalArgumentException("Not enough cards left");
	       
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
		// it just assigns the cards field to the value of the cards field
		// this.cards = cards;
		// return cards;

	}



// if you want to use more than one deck of cards (as would be typical for blackjack),
// run the for loops in the Deck constructor more than once, thus adding more cards
