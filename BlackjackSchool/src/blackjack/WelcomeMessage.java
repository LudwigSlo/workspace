package blackjack;

// TODO: Auto-generated Javadoc
/**
 * The Class WelcomeMessage.
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
public void displayWelcomeMessage() throws InterruptedException  {
	
	W();
	Thread.sleep(300);
	E();
	Thread.sleep(300);
	L();
	Thread.sleep(300);
	C();
	Thread.sleep(300);
	O();
	Thread.sleep(300);
	M();
	Thread.sleep(300);
	E2();
	Thread.sleep(300);
	T();
	Thread.sleep(300);
	O2();
	Thread.sleep(300);
	B();
	Thread.sleep(300);
	L2();
	Thread.sleep(300);	
	A();
	Thread.sleep(300);
	C2();
	Thread.sleep(300);
	K();
	Thread.sleep(300);
	J();
	Thread.sleep(300);
	A2();
	Thread.sleep(300);
	C3();
	Thread.sleep(300);
	K2();
	Thread.sleep(300);	
	Explosion();
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


