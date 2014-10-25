import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Deck extends Player {

//Get the card from the Deck
	public static void getCardfromDeck(String name) {

		newValor(name);	

	}
	
	//Parameter 'name' for whom the card should go to.
	public static void newValor(String name) {
		 Random rng = new Random();
		 int currentcard = rng.nextInt(13);
		 currentcard++;
		
			Map<Integer, String> nameMap = new HashMap<Integer, String>();
	
		    nameMap.put(1, "A");
		    nameMap.put(10, "T");
		    nameMap.put(11, "J");
		    nameMap.put(12, "Q");
		    nameMap.put(13, "K");
		    

		    String getValor;
			if (currentcard >= 10 || currentcard == 1) {
				getValor = nameMap.get(currentcard);
				if (name.equals("Player")){
				playerTotal = playerTotal + 10;}
				else if (name.equals("Dealer")){
				dealerTotal = dealerTotal + 10;
				}
				System.out.println(" ______");
				System.out.println("|"+getValor+"     |");
				newSuit();
				System.out.println("|_____"+getValor+"|");
				
			}
			else{
				
				if(name.equals("Player"))
				playerTotal = currentcard + playerTotal;
				else if(name.equals("Dealer"))
				dealerTotal = currentcard + dealerTotal;
				
		
				System.out.println(" ______");
				System.out.println("|"+currentcard+"     |");
				newSuit();
				System.out.println("|_____"+currentcard+"|");
				
			}

	}
	
	
	public static void newSuit() {

		Random rng = new Random();
		int generateSuit = rng.nextInt(4);
		generateSuit++;
		
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
