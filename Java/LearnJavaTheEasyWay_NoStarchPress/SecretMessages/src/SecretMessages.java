import java.util.Scanner;

public class SecretMessages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String message;
		Scanner scan = new Scanner(System.in);
		int keyVal=13;
		char key = (char) keyVal;
		
		do {
		System.out.println("Enter a message to encode or decode:");
		message = scan.nextLine();
		
		if (message.length() == 0) {
			System.out.println("Program ended. Goodbye!");
			continue;
		}//Set it to use a do while loop
		//if i redid it, probably would do 
		//while (True) if (condition) break;
		
		String output = "";
		do {
			try {
				System.out.println("Enter a secret key (-25 to 25):");
				keyVal = Integer.parseInt(scan.nextLine());
				key = (char) keyVal;
				if (keyVal < -25 || keyVal > 25)
					System.out.println("Enter a number between -25 and 25!");
			} catch(Exception e) {System.out.println("Enter a number!");}
		}while (keyVal < -25 || keyVal > 25);
		
		for (int x = message.length() - 1; x >= 0; x--) {
			char input = message.charAt(x);
			if (input >= 'A' && input <= 'Z') {
				input += key;
				if (input > 'Z')
					input -= 26;
				if (input < 'A')
					input += 26;
			}
			else if (input >= 'a' && input <= 'z') {
				input += key;
				if (input > 'z')
					input -=26;
				if (input < 'a')
					input += 26;
			}
			else if (input >= '0' && input <= '9')
			{
				input += (keyVal %10);
				if (input > '9')
					input -= 10;
				if (input < '0')
					input +=10;
			}
			output += input;
		}
		System.out.println(output);
		} while (message.length()>0);
		scan.close();
	}

}
