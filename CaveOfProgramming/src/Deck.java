
import java.util.Random;

public class Deck {


	String[] currentsuit = { "Spades", "Heart", "Diamonds", "Clubs" };
	String[] currentcard = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
			"Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };

	int generateSuit = (int) (Math.random() * 3);
	int generateCard = (int) (Math.random() * 12);
	String suit = currentsuit[generateSuit];
	String value = currentcard[generateCard];


	public String toString() {

		return suit + ": " + value;
	}

}
