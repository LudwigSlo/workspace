import java.util.Random;
import java.util.Scanner;

public class Hello1 {
	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		Random rng = new Random();
		int player1Card1 = 0;
		int player1Card2 = 0;
		int player1Cardx = 0;
		int player2Card1 = 0;
		int player2Card2 = 0;
		int player2Cardx = 0;

		int total = 0;
		int total1 = 0;
		String hitorstay;

		player1Card1 = rng.nextInt(10);
		player1Card2 = rng.nextInt(10);
		player1Cardx = rng.nextInt(10);
		player2Card1 = rng.nextInt(10);
		player2Card2 = rng.nextInt(10);
		player2Cardx = rng.nextInt(10);

		System.out.println("You drew " + (player1Card1 + 2) + " "
				+ (player1Card2 + 2));
		total = (player1Card1 + 2) + (player1Card2 + 2);
		System.out.println("Your total is " + total);

		System.out.println("The dealer drew " + (player2Card1 + 2));
		total1 = player2Card1 + player2Card2;
		System.out.println("Their card is " + (player2Card1 + 2));

		System.out.println("Would you like to 'hit' or 'stay?'");
		hitorstay = kb.nextLine();

		do {
			if (hitorstay.equals("hit")) {
				player1Cardx = rng.nextInt(10);
				total = (player1Cardx +=2) + total;
				System.out.println("You drew an " + (player1Cardx)
						+ "\n Your total is now" + total);

				System.out.println("Would you like to 'hit' or 'stay?'");
				hitorstay = kb.nextLine();
				if (total > 21) {
					System.out
							.println("You busted, total is over 21, it went to "
									+ total);
				}
			}
			if (hitorstay.equals("stay")) {
				System.out.println("Okay, dealers turn");
			}
			if (total > 21) {
				System.out.println("The dealers hidden card was "
						+ (player2Card2+2));
				if (total1 < 16) {
					player2Cardx = rng.nextInt(10);
					total1 = (player2Cardx +=2) + total;
					System.out.println("The dealer hits, and gets "
							+ player2Cardx + "\n His total is  " + total1);
					if (total > total1) {
						System.out.println("You win!!");
					} else if (total < total1) {
						System.out.println("They win!");
					}
				}
			}

		} while (hitorstay != null);
	}
}