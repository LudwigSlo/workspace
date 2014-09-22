import java.util.Random;
import java.util.Scanner;

public class BlackjackConstructor {
	// Setting variables
	Scanner kb = new Scanner(System.in);
	Random rng = new Random();
	int currentcard;
	String hitorstay;
	int total = 0;
	int total1 = 0;
	String[] currentsuit = { "Spades", "Heart", "Diamonds", "Clubs" };
	int num = (int) (Math.random() * 5);

	// Display for the person's card
	public void displayPerson() throws InterruptedException {

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~	Welcome		~");
		Thread.sleep(500);
		System.out.println("~	to BlackJack!	~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		Thread.sleep(1000);
		System.out.println("\nShuffling cards... Will deal in 2 seconds.\n");
		Thread.sleep(2000);

		// printing out our new numbers that have just got drawn
		System.out.println("You drew the cards ");
		newCard();
		System.out.println(" & ");
		newCard();

		Thread.sleep(1000);
		System.out.println("Your total is: " + total + "!");
		Thread.sleep(1000);
		System.out.println("\nThe dealer drew the card");
		newCardDealer();
		Thread.sleep(800);
		System.out.println("and a secret card he wont show yet \n | ? | \n");
		Thread.sleep(1000);
		// asking them if they want to stay or hit again
		System.out.println("Would you like to 'hit' or 'stay?'");
		hitorstay = kb.nextLine();
		Thread.sleep(800);

		// if they want to hit, do this
		while (total < 21 && hitorstay.equalsIgnoreCase("hit")) {

			System.out.println("You drew an ");
			newCard();
			System.out.println("\n Your total is now " + total);
			Thread.sleep(800);
			if (total > 21) {
				Thread.sleep(800);
				System.out
						.println("You busted, total is over 21, you lost, and you got "
								+ total);
				System.exit(1);

			}
			Thread.sleep(800);
			System.out.println("Would you like to 'hit' or 'stay?'");
			hitorstay = kb.nextLine();
		}
		if (hitorstay.equals("stay")) {
			Thread.sleep(800);
			System.out.println("Okay, dealers turn");
			displayDealer();
		}
	}

	public void displayDealer() throws InterruptedException {

		System.out.println("The secretcard that the dealer had was: ");
		newCardDealer();
		System.out.println("Their total is now: " + total1);
		Thread.sleep(800);
		// printing out our new numbers that have just got drawn
		System.out.println("The dealer drew an ");
		newCardDealer();

		Thread.sleep(800);
		System.out.println("Their total is " + total1 + "\n");

		// The dealer should hit when his score is <17
		while (total1 < 17) {

			Thread.sleep(800);
			System.out.println("The dealer drew ");
			newCardDealer();
			System.out.println("\n Their total is now " + total1);

			if (total1 > 21) {
				Thread.sleep(800);
				System.out
						.println("They busted, total is over 21, and they lost, you won! Their total was "
								+ total1);
				System.exit(1);
			}

		}
		if (total1 > 17) {
			Thread.sleep(800);
			System.out.println("Okay, dealer stopped at " + total1);
			displayWhoWon();
		}
	}

	public void displayWhoWon() throws InterruptedException {
		if (total > total1) {
			Thread.sleep(800);
			System.out.println("The player won! Suck it dealer!!");
		} else if (total == total1) {
			Thread.sleep(800);
			System.out.println("Dealer won, you got the same score");
		} else {
			Thread.sleep(800);
			System.out.println("The dealer won, wooo!");
		}
	}

	public void newCard() {
		currentcard = rng.nextInt(14);

		String suit = currentsuit[num];
		while (currentcard == 0) {
			currentcard = rng.nextInt(14);
		}

		switch (currentcard) {
		case 11:
			System.out.println("Jack of " + suit);
			total = total + 10;
			break;

		case 12:
			System.out.println("Queen of " + suit);
			total = total + 10;
			break;

		case 13:
			System.out.println("King of " + suit);
			total = total + 10;
			break;
		default:
			System.out.println(currentcard + " of " + suit);
			total = total + currentcard;
		}

	}

	public void newCardDealer() {
		currentcard = rng.nextInt(14);
		String suit = currentsuit[num];
		while (currentcard == 0) {
			currentcard = rng.nextInt(14);
		}

		switch (currentcard) {
		case 11:
			System.out.println("Jack of " + suit);
			total1 = total1 + 10;
			break;

		case 12:
			System.out.println("Queen of " + suit);
			total1 = total1 + 10;
			break;

		case 13:
			System.out.println("King of " + suit);
			total1 = total1 + 10;
			break;
		default:
			System.out.println(currentcard + " of " + suit);
			total1 = total1 + currentcard;
		}

	}

}
