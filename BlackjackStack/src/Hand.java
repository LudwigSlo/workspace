import java.util.ArrayList;
import java.util.List;

public class Hand {

	private List<Card> cards; 

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

	//A method for calculating hand value. Iterating over our cards and calling the getters for Rank and Value from the Class Card.
	//Then setting that value to our total variable, so that every time a card gets added, it will iterate over the cards and get the total of those cards.
	public int calculateHandValue() {
		int total = 0;
		for (Card card : cards) {
			
			total += card.getRank().getValue();

			}
			return total;
		}

	//toString method for printing out the cards from the current hand (either player or dealer)
	@Override
	public String toString() {
		List<String[]> splitCards = new ArrayList<>();               // Creating a new ArrayList
		String cardsString = "";									 // Creating a String variable 	
		for (Card card : cards) {									 // A for each loop - looping over the object cards				
			splitCards.add(card.toString().split("\n"));			 // Adding the splitted Strings to splitCards everytime "\n" is found.
		}
		for (int i = 0; i < splitCards.get(0).length; i++) {         // A for loop that will loop through splitCards, starting at index 0 
			for (String[] splitCard : splitCards) {					 // For each loop that will loop through splitCards, and add them to an String Array.
				cardsString += splitCard[i];						 // Setting our String to the Array splitCard, and also getting its Index, so we get it in the right order.
			}
			cardsString += "\n"      ;                               //After every
		}
		return cardsString;
	}
}