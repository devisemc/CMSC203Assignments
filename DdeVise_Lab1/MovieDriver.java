/*
 * Donovan deVise
 * Prof Tsai
 * Lab 1
 * 9/12/2021
 */
import java.util.Scanner;

public class MovieDriver {
	public static void main(String[] args)
	{
		//Initialize scanner and movie object
		Scanner myScanner = new Scanner(System.in);
		Movie movieObj = new Movie();
		//Start Loop
		do {
			//Get and Set Title
			System.out.println("Enter the name of a movie");
			movieObj.setTitle(myScanner.nextLine());
			
			//Get and Set Rating
			System.out.println("Enter the rating of the movie");
			movieObj.setRating(myScanner.nextLine());
			
			//Get and Set Tickets Sold
			System.out.println("Enter the number of tickets sold for this movie");
			movieObj.setSoldTickets(myScanner.nextInt());
			
			//Display Movie's Data
			System.out.println(movieObj.toString());
			
			//Clear Buffer
			myScanner.nextLine();
			
			//Ask to Repeat
			System.out.println("Do you want to enter another? (y or n)");
		}while(myScanner.nextLine().equalsIgnoreCase("y"));
		//Ends when user says to stop repeating
		System.out.println("Goodbye");
	}
}
