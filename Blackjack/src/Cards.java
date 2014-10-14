import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Cards extends Deck {
	
	public static void newCard(int i) {
		
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
				if (i == 1){
				playerTotal = playerTotal + 10;}
				else if (i == 2){
				dealerTotal = dealerTotal + 10;
				}
				System.out.println(" ______");
				System.out.println("|"+getValor+"     |");
			}
			else{
				
				if(i == 1)
				playerTotal = currentcard + playerTotal;
				else if(i == 2)
				dealerTotal = currentcard + dealerTotal;
				
		
				System.out.println(" ______");
				System.out.println("|"+currentcard+"     |");
				
			}

	}
}
