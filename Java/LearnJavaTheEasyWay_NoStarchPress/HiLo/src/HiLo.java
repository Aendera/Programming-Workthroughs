
import java.util.Scanner;

public class HiLo {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String playAgain="";
		do {
			// Create a random number for the user to guess
			int theNumber = (int)(Math.random()*200-100);
			//System.out.println( theNumber );
			int guess=0;
			int tries=0;
			while (guess != theNumber) {
				tries=tries+1;
				System.out.println("Guess a number between -100 and 100:");
				guess=scan.nextInt();
				System.out.println("You entered " + guess+".");
				if (guess < theNumber)
					System.out.println(guess+ " is too low. Try again.");
				else if (guess > theNumber)
					System.out.println(guess+" is too high. Try again.");
				else {
					System.out.println(guess+" is correct. You win!");
					System.out.println("You guessed in "+tries+" tries.");}
			}//End of while loop
			System.out.println("Would you like to play again (y/n)?");
			playAgain=scan.next();
		}while (playAgain.equalsIgnoreCase("y"));
	    System.out.println("Thank you for playing! Goodbye.");
	    scan.close();
	}

}
