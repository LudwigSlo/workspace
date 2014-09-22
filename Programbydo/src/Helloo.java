import java.util.Scanner;
public class Helloo
{
	public static void main( String[] args )
	{

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Welcome to Mr. Mitchell's fantastic birth-o-meter!");
		System.out.println();
		System.out.println("All you have to do is enter your birth date, and it will");
		System.out.println("tell you the day of the week on which you were born.");
		System.out.println();
		System.out.println("Some automatic tests....");
		System.out.println("12 10 2003 => " + weekday(12,10,2003));
		System.out.println(" 2 13 1976 => " + weekday(2,13,1976));
		System.out.println(" 2 13 1977 => " + weekday(2,13,1977));
		System.out.println(" 7  2 1974 => " + weekday(7,2,1974));
		System.out.println(" 1 15 2003 => " + weekday(1,15,2003));
		System.out.println("10 13 2000 => " + weekday(10,13,2000));
		System.out.println();

		System.out.println("Now it's your turn!  What's your birthday?");
		System.out.print("Birth date (mm dd yyyy): ");
		int mm = keyboard.nextInt();
		int dd = keyboard.nextInt();
		int yyyy = keyboard.nextInt();

		// put a function call for weekday() here
		System.out.println("You were born on " + weekday(mm, dd, yyyy));
	}


	public static String weekday( int mm, int dd, int yyyy )
	{
		int yy, total;
		String date = "";

		// bunch of calculations go here

		date = month_name(mm) + ", " + yyyy;

		return date;
	}

	public static String month_name( int month)
	{	String monthString;
		switch (month) {
        case 1:  monthString = "January";       break;
        case 2:  monthString = "February";      break;
        case 3:  monthString = "March";         break;
        case 4:  monthString = "April";         break;
        case 5:  monthString = "May";           break;
        case 6:  monthString = "June";          break;
        case 7:  monthString = "July";          break;
        case 8:  monthString = "August";        break;
        case 9:  monthString = "September";     break;
        case 10: monthString = "October";       break;
        case 11: monthString = "November";      break;
        case 12: monthString = "December";      break;
        default: monthString = "Invalid month"; break;
    }
		return monthString;
	}
	public static String weekday_name( int month)
	{	String monthString;
		switch (month) {
        case 1:  monthString = "January";       break;
        case 2:  monthString = "February";      break;
        case 3:  monthString = "March";         break;
        case 4:  monthString = "April";         break;
        case 5:  monthString = "May";           break;
        case 6:  monthString = "June";          break;
        case 7:  monthString = "July";          break;
        case 8:  monthString = "August";        break;
        case 9:  monthString = "September";     break;
        case 10: monthString = "October";       break;
        case 11: monthString = "November";      break;
        case 12: monthString = "December";      break;
        default: monthString = "Invalid month"; break;
    }
		return monthString;
	}
	// paste your functions from MonthName, WeekdayName, and MonthOffset here
		
	public static boolean is_leap( int year )
	{
		// years which are evenly divisible by 4 are leap years,
		// but years divisible by 100 are not leap years,
		// though years divisible by 400 are leap years
		boolean result;

		if ( year%400 == 0 )
			result = true;
		else if ( year%100 == 0 )
			result = false;
		else if ( year%4 == 0 )
			result = true;
		else
			result = false;
		
		return result;
	}
}