import java.util.Scanner;

public class Question2Day2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("+" + "----------------------------------" + "+");
		System.out.println("|" + "     " + "1. Word                 " + "     " + "|");
		System.out.println("|" + "     " + "2. Games                " + "     " + "|");
		System.out.println("|" + "     " + "3. Study Notes          " + "     " + "|");
		System.out.println("|" + "     " + "4. Exit                 " + "     " + "|");
		System.out.println("+" + "----------------------------------" + "+");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Word");
			break;

		case 2:
			System.out.println("Games");
			break;

		case 3:
			System.out.println("Study Notes");
			break;

		case 4:
			System.out.println("Exit");
			break;
		default:
			System.out.println("Wrong answer");
			break;
		}
		scanner.close();
	}

}
