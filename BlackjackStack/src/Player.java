import java.util.List;
import java.util.Scanner;
import java.util.Set;

public abstract class Player {
	private Hand hand;
	private Dealer dealer;
	private String name;
	
	
	public Hand getHand() {
		return hand;
		}
	public Player(String name) {
		hand = new Hand();
		this.name = name;
	

	}

	public void addCards(List<Card> cards) {
		if(hand.calculateHandValue() > 21){
			System.out.println("You got over 21, you busted, and the Dealer won.");
			System.exit(0); 
		}
		else{
			
			hand.addCards(cards);
		}
		}
		
	// Delegation method for Hand's calculateHandValue
	public int calculateHandValue(){
		return hand.calculateHandValue();
	}
	
	
	
	// and player again doesn't need a cards field, the cards of a player are in their hand. 
	//so the toString of player would be: return "Player: " + hand.toString(); 
	//(later, you can add a name field to the player and print that instead of "Player". 
	//thats also how you will be able to print Dealer, without having to implement toString in dealer)
/**	public void userInput(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to hit again? y/n");
		String hitorstay = scan.nextLine();
		
		if(hitorstay.equals("y")){
			dealer.deal(null, 1);
		   
	    	System.out.println(dealer.toString());
		System.out.println("Dealt");
		}
		
	}
**/
	@Override
	public String toString() {
		
		return name + ": " + hand.toString();
	}
	
	public enum Action { 
		HIT, 
		STAY,
		INVALID
		} 
	//  its an abstract method. that means its basically saying: this is a method that needs to exist in all subclasses (but this class doesnt implement it)
		public abstract Action getAction(); 
		
		}


