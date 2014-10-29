package blackjack;

/**
 * The Class Card.
 * 
 *@author Ludwig Slotte <a href="mailto:Ludwig_Slotte@hotmail.com">Ludwig_Slotte@hotmail.com</a>
 *@version 1.0
 */

public class Card {

	/** The rank. */
	private Rank rank;

	/** The suit. */
	private Suit suit;

	// Constructor for Cards, it will include Rank and Suit.
	/**
	 * Instantiates a new card.
	 *
	 * @param rank The rank
	 * @param suit The suit
	 */
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	// Getters for Rank and Suit, to get them from the enum instances
	/**
	 * Gets the rank.
	 *
	 * @return the rank
	 */
	public Rank getRank() {
		return rank;
	}

	/**
	 * Gets the suit.
	 *
	 * @return the suit
	 */
	public Suit getSuit() {
		return suit;
	}


	/**
	 * toString for part of ascii art, suit.toString and rank.toString.
	 * 
	 * 
	 */
	@Override
	public String toString() {
		return " \n ______ \n|" + rank.toString() + "     |\n"
				+ suit.toString() + "\n|_____" + rank.toString() + "|";
	}

	// Enum for Rank of the cards, 2-11 (With valor as J/Q/K/A)
	/**
	 * The Enum Rank.
	 */
	public enum Rank {

		/** The two. */
		TWO(2), 
		/** The three. */
		THREE(3),
		/** The four. */
		FOUR(4), 
		/** The five. */
		FIVE(5), 
		/** The six. */
		SIX(6), 
		/** The seven. */
		SEVEN(7), 
		/** The eight. */
		EIGHT(8),
		/** The nine. */
		NINE(9), 
		/** The ten. */
		TEN(10),
		/** The jack. */
		JACK(10),
		/** The queen. */
		QUEEN(10),
		/** The king. */
		KING(10),
		/** The ace. */
		ACE(11);

		
		/**
		 * toString for Values, including T-J-Q-K-A.
		 */
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

		/** The value. */
		private int value;

		
		/**
		 * Instantiates a new rank.
		 *
		 * @param value
		 *            the value
		 */
		private Rank(final int value) {
			this.value = value;
		}

		// Getter for value
		/**
		 * Gets the value.
		 *
		 * @return the value
		 */
		public int getValue() {
			return value;
		}
	}

	// Enum for our 4 suits
	/**
	 * The Enum Suit.
	 */
	public enum Suit {

		/** The spades. */
		SPADES, 
		/** The hearts. */
		HEARTS, 
		/** The diamonds. */
		DIAMONDS, 
		/** The clubs. */
		CLUBS;

	
	
		/** 
		 * toString for Suit ascii art.
		 */
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
