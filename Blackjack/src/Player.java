import java.util.Scanner;



public class Player extends Dealer  {
static int playerTotal;

@SuppressWarnings("resource")
public void displayPerson() throws InterruptedException {
	

	Thread.sleep(2000);
	System.out.println("\nShuffling cards... Will deal in 2 seconds.");
	Thread.sleep(1000);
	System.out.println("\n-------------------------\n");
	Thread.sleep(1000);
	
	
	System.out.println("You drew the cards: ");
	Thread.sleep(800);
	Deck.getCardfromDeck("Player");
	Thread.sleep(800);
	System.out.println("\n    & ");
	Thread.sleep(800);
	Deck.getCardfromDeck("Player");

	Thread.sleep(1000);
	System.out.println("\nYour total is: " + playerTotal + "!");
	Thread.sleep(1000);
	System.out.println("\nThe dealer drew the card");
	Thread.sleep(500);
	Deck.getCardfromDeck("Dealer");
	Thread.sleep(800);
	System.out.println("And a secret card he wont show yet");
	Thread.sleep(1200);
	System.out.println(" ______");
	System.out.println("|?     |");
	System.out.println("|   ?  |");
	System.out.println("| ?  ? |");
	System.out.println("|      |");
	System.out.println("|_____?|");
	Thread.sleep(1000);
	// asking them if they want to stay or hit again
	System.out.println("Would you like to 'hit' or 'stay'?");
	Scanner scan = new Scanner(System.in);
	String hitorstay = scan.nextLine();
	Thread.sleep(800);

	// if they want to hit, do this
	if (hitorstay.equalsIgnoreCase("hit")) {

		System.out.println("You drew an ");
		Deck.getCardfromDeck("Player");
		System.out.println("\n Your total is now " + playerTotal);
		Thread.sleep(800);
		if (playerTotal > 21) {
			Thread.sleep(800);
			System.out
					.println("You busted, total is over 21, you lost, and you got "
							+ playerTotal);
			System.exit(1);

		}
		Thread.sleep(800);
		System.out.println("Would you like to 'hit' or 'stay?'");
		hitorstay = scan.nextLine();
	}
	else if (hitorstay.equals("stay")) {
		System.out.println("Okay, dealers turn");
		Thread.sleep(800);
		Dealer.displayDealer();
	}
else{
	 Scanner errorScan = new Scanner(System.in);
		System.out.println("You typed wrong. Would you like to play again? Y/N");
	String playagain = errorScan.nextLine();
		if(playagain.equalsIgnoreCase("Y")){
			System.out.println("Would you like to 'hit' or 'stay'?");
			hitorstay = scan.nextLine();}
		else
			System.out.println("Good bye. Have a nice day!");
			System.exit(0);
	}
	
}


}
