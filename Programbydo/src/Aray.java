import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Aray {
	public static ArrayList<String> array = new ArrayList<>();
	
	
	static Random ran = new Random();
	static int rng = ran.nextInt(100);
	Set<String> set = new HashSet<>(array);
	static Scanner scan = new Scanner(System.in);
	static String count;
	
	static ArrayList<String> aListNumbers = new ArrayList<String> (Arrays.asList());


	public static void main(String[] args) {
		
		System.out.println("Sentence: ");
		count = scan.nextLine();
	String[] strValues1 = count.split(" ");
	aListNumbers = new ArrayList<String>(Arrays.asList(strValues1));
		Sorting();
		
		

		
		
			}
	
	public static void Sorting(){
		 
		Collections.sort(aListNumbers);
		System.out.println(aListNumbers);
		
	}
}
