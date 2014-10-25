
public class WhoWon extends Player{
	public static void displayWhoWon(){
		
		if(playerTotal > dealerTotal){
			System.out.println("The Player won! The players score was " + playerTotal + ", and the dealers score was " + dealerTotal);
		}
		else if(playerTotal < dealerTotal){
			System.out.println("The Dealer won! The players score was " + playerTotal + ", and the dealers score was " + dealerTotal);
		}
		else
		{
			System.out.println("Draw. Nobody won.");
		}
		
	}
}
