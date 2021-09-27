/*
 * Class: CMSC203 
 * Instructor: Prof Tsai
 * Description: Implement the design for assignment 2
 * Due: 9/26/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Donovan deVise
*/

import java.util.Scanner;

public class RandomNumberGuesser {
	public static void main(String[] args)
	{
		//Header
		System.out.println("Donovan deVise");
		System.out.println("Professor Tsai");
		System.out.println("Assignment 2 Implementation");
		System.out.println("9/26/2021\n\n");
		//Declare Vars
		Scanner stdin = new Scanner(System.in);
		int nextGuess;
		int lowGuess;
		int highGuess;
		int randNum;
		boolean firstGame = true;
		
		//Start Repeat loop
		do {
			//Reset Vars
			lowGuess = 0;
			highGuess = 100;
			RNG.resetCount();
			randNum = RNG.rand();
			
			//Add some space after the last game if it's a repeated one
			if (!firstGame)
				System.out.print("\n\n");
			
			//Start game loop
			System.out.println("Enter your first guess");
			while (true)
			{
				if (RNG.getCount() != 0)//Skip on the first loop
					System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
				
				//Get user's guess, validate, and print the guess count
				nextGuess = stdin.nextInt();
				if (!RNG.inputValidation(nextGuess, lowGuess, highGuess))
					continue;//Go back to start if guess fails validation
				System.out.println("Number of guesses is " + RNG.getCount());
				
				//Compare user's guess with the answer
				if (nextGuess > randNum)
				{
					System.out.println("Your guess is too high");
					highGuess = nextGuess;
				}
				else if (nextGuess < randNum)
				{
					System.out.println("Your guess is too low");
					lowGuess = nextGuess;
				}
				else
				{
					System.out.println("Congratulations, you guessed correctly");
					break;//Ends game
				}
			}
			//Set first game to false and ask to repeat
			firstGame = false;
			System.out.println("Try again? (yes or no)");
			stdin.nextLine();
		}while (stdin.nextLine().equalsIgnoreCase("yes"));//Repeat the game if user inputs yes
		//End of Program
		System.out.println("Thanks for playing...");
		System.out.println("\n\nName: Donovan deVise");
	}
}
