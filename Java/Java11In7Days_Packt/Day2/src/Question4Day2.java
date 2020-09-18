import java.util.Scanner;

public class Question4Day2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int mark;
		int counter=0;
		int sum=0;
		for( ; ;) {
			System.out.println("Enter mark");
			mark = scanner.nextInt();
			if (mark == -1)
				break;
			sum+=mark;
			counter++;
		}
		System.out.println("Average mark is " + ((float) sum/(float) counter));
	}

}
