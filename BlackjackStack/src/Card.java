public class Card {

	private Rank rank;
	private Suit suit;

	// boolean hidden;

	// Constructor for Cards, it will include Rank and Suit.
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	// Getters for Rank and Suit, to get them from the enum instances
	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	// asci art
	// @Override
	// public Suit toString() {

	// }
	@Override
	public String toString() {
		return " \n ______ \n|" + rank.toString() + "     |\n"
				+ suit.toString() + "\n|_____" + rank.toString() + "|";
	}

	// Enum for Rank of the cards, 2-14 (With valor as J/Q/K/A)
	public enum Rank {

		TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(
				10), JACK(10), QUEEN(10), KING(10), ACE(11);
		@Override
		public String toString() {
			switch (this) {
			case TWO:
				return "2";
			case THREE:
				return "3";
			case FOUR:
				return "4";
			case FIVE:
				return "5";
			case SIX:
				return "6";
			case SEVEN:
				return "7";
			case EIGHT:
				return "8";
			case NINE:
				return "9";
			case TEN:
				return "T";
			case JACK:
				return "J";
			case QUEEN:
				return "Q";
			case KING:
				return "K";
			case ACE:
				return "A";
				// etc
			default:
				return "error";
			}
		}

		private int value;

		// Constructor for value, since our cards need to hold a value depending
		// on their card
		private Rank(final int value) {
			this.value = value;
		}

		// Getter for value
		public int getValue() {
			return value;
		}
	}

	// Enum for our 4 suits
	public enum Suit {

		SPADES, HEARTS, DIAMONDS, CLUBS;

		// use "Spades" for toString (for debug), and add a print() method,
		// which uses the asci art

		@Override
		public String toString() {
			switch (this) {
			case SPADES:
				return "|  /\\  |\n" + "| (__) |\n" + "|  /\\  |";

			case DIAMONDS:
				return "|  /\\  |\n" + "|  \\/  |\n" + "|      |";

			case CLUBS:
				return "|  &   |\n" + "| &|&  |\n" + "|  |   |";

			case HEARTS:
				return "| (\\/) |\n" + "|  \\/  |\n" + "|      |";

			default:
				return "error ";
			}
		}
	}

}

//
// call it boolean hidden
// add a setter for it
// in the toString method of card, check if the card is hidden. if so, return ??
// or something, else return whats currently returned
// and then use the setter when dealing cards to hide the cards you want to
// hide.