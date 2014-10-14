import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CardsSuit extends Deck {

	public static void newSuit() {

		Random rng = new Random();
		int generateSuit = rng.nextInt(4);
		generateSuit++;
		String getSuit;
		

		Map<Integer, String> suitMap = new HashMap<Integer, String>();

		suitMap.put(1, "Spades");
		suitMap.put(2, "Diamonds");
		suitMap.put(3, "Clubs");
		suitMap.put(4, "Heart");
		
		if (generateSuit == 1) {
			
			System.out.println("|  /\\  |");
			System.out.println("| (__) |");
			System.out.println("|  /\\  |");		
		}
		else if (generateSuit == 2) {
		
			System.out.println("|  /\\  |");
			System.out.println("|  \\/  |");
			System.out.println("|      |");
		} else if (generateSuit == 3) {
			
			System.out.println("|  &   |");
			System.out.println("| &|&  |");
			System.out.println("|  |   |");
		} else if (generateSuit == 4) {
			
			System.out.println("| (\\/) |");
			System.out.println("|  \\/  |");	
			System.out.println("|      |");
		}

	}
}
