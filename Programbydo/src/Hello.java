import java.util.Scanner;
import java.util.Random;

public class Hello {

	private static double diameter;
	private static double omkrets;
	private static double area;
	private static double radie;

	public static void main(String[] args) throws InterruptedException {

		Hello obj = new Hello();
		
		obj.forLoop();

	}

	void CirkelOmkrets(double x) {

		omkrets = Math.PI * x * 2;
		System.out.println("Omkrets: " + omkrets);

	}

	void CirkelArea(double x) {

		area = Math.PI * Math.pow(x, 2);
		System.out.println("area : "+ area);

	}

	void forLoop() {
		Hello obj1 = new Hello();
		
		for (double rad = 1; rad < 11; rad++) {

			for (double kolumner = 1; kolumner < 11; kolumner++) {
				radie = kolumner + rad;
				obj1.CirkelOmkrets(radie);
				obj1.CirkelArea(radie);
				

			}

			System.out.println();
		}
		
	}
}
