package blackjack;

/**
 * The Class WelcomeMessage.
 * 
 * Bonus Class only for the welcome message, only for looks.
 * 
 *@author Ludwig Slotte <a href="mailto:Ludwig_Slotte@hotmail.com">Ludwig_Slotte@hotmail.com</a>
 *@version 1.0
 */

public class WelcomeMessage{

/**
 * Display welcome message.
 *
 * @throws InterruptedException the interrupted exception
 */
public void displayWelcomeMessage()   {
	
	W();
	threadSleep();
	E();
	threadSleep();
	L();
	threadSleep();
	C();
	threadSleep();
	O();
	threadSleep();
	M();
	threadSleep();
	E2();
	threadSleep();
	T();
	threadSleep();
	O2();
	threadSleep();
	B();
	threadSleep();
	L2();
	threadSleep();	
	A();
	threadSleep();
	C2();
	threadSleep();
	K();
	threadSleep();
	J();
	threadSleep();
	A2();
	threadSleep();
	C3();
	threadSleep();
	K2();
	threadSleep();
	try {
		Explosion();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	

	/**
	 * Thread sleep.
	 * 
	 * We can set a value on how long we want the thread to sleep, from zero and up.
	 */

	public void threadSleep() {
		try {
		Thread.sleep(300);
		} catch (InterruptedException e) {

		e.printStackTrace();
	}
}
	/**
	 * W.
	 */
	public static void W(){
	//W
		System.out.print("| | | \n \\|\\| ");
	}
	
	/**
	 * E.
	 */
	public static void E(){
	//E
	System.out.print(" _ \n      (/_");
	}
	
	/**
	 * E2.
	 */
	public static void E2(){
		//E
		System.out.print(" _ \n                    (/_");
		}

	/**
	 * L.
	 */
	public static void L(){
	//L
	System.out.print(" | \n          |");
	}
	
	/**
	 * C.
	 */
	public static void C(){
	//C
	System.out.print(" _\n           (_");
	}
	
	/**
	 * O.
	 */
	public static void O(){
	//O
	System.out.print("\n              ()");}
	
	/**
	 * M.
	 */
	public static void M(){
	//M
	System.out.print(" ,_ \n                 |||");}
	
	//The word "To"
	/**
	 * T.
	 */
	public static void T(){
		//T
		System.out.print("\n      -|- \n       |_");}
	
	/**
	 * O2.
	 */
	public static void O2(){
		//O
		System.out.print("()");}
	
	/**
	 * B.
	 */
	public static void B(){
		//B
		System.out.print("\n\n|) \n|)");}
	
	/**
	 * L2.
	 */
	public static void L2(){
		//L
		System.out.print("| \n  |");}
	
	/**
	 * A.
	 */
	public static void A(){
		//A
		System.out.print(" (|");}
	
	/**
	 * C2.
	 */
	public static void C2(){
		//C
		System.out.print(" _\n      (_");}
	
	/**
	 * K.
	 */
	public static void K(){
		//K
		System.out.print(" |\n         |<");}
	
	/**
	 * J.
	 */
	public static void J(){
		//T
		System.out.print(" |\n           _|");}
	
	/**
	 * A2.
	 */
	public static void A2(){
		//A
		System.out.print(" (|");}
	
	/**
	 * C3.
	 */
	public static void C3(){
		//C
		System.out.print(" _\n                (_");}
	
	/**
	 * K2.
	 */
	public static void K2(){
		//K
		System.out.print(" |\n                   |<");}
	
	//Ascii For the firework-explosion
		/**
	 * Explosion.
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	public static void Explosion() throws InterruptedException{
			System.out.println();
			System.out.print(".");
			Thread.sleep(100);
			System.out.print(":");
			Thread.sleep(100);
			System.out.print("*");
			Thread.sleep(100);
			System.out.print("~");
			Thread.sleep(100);
			System.out.print("*");
			Thread.sleep(100);
			System.out.print(":");
			Thread.sleep(100);
			System.out.print(".");
			Thread.sleep(100);
			System.out.print("_");
			Thread.sleep(100);
			System.out.print("-");
			Thread.sleep(100);
			System.out.print(".");
			Thread.sleep(100);
			System.out.print(":");
			Thread.sleep(100);
			System.out.print("*");
			Thread.sleep(100);
			System.out.print("~");
			Thread.sleep(100);
			System.out.print("*");
			Thread.sleep(100);
			System.out.print(":");
			Thread.sleep(100);
			System.out.print(".");
			Thread.sleep(100);
			System.out.print("_");
			Thread.sleep(100);
			System.out.print("-");
			Thread.sleep(100);
			
			System.out.println(" *' '*");
			System.out.println("                 *  _\\/_ *");
			System.out.println("                 *   /\\  *");	
			System.out.println("                   *. .*");
			Thread.sleep(500);
			System.out.println("Made by Ludwig Slotte");
			Thread.sleep(300);
			System.out.println(" - Javautvecklare, Teknikhögskolan, 2014.");
		}

}


