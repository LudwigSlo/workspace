import java.util.Scanner;

public class ConsolePlayer extends Player {

	public ConsolePlayer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Action getAction() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Hit or stay?");
		String userInput = scan.nextLine(); // something
		
		
		if (userInput.equalsIgnoreCase("Hit")) {
			return Action.HIT;
		} else if (userInput.equalsIgnoreCase("Stay")) {
			return Action.STAY;
		}
		else
			return Action.INVALID;
	}
}
