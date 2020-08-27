import java.util.Scanner;
public class MadLibs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter a color");
		String color=scan.next();
		System.out.println("Enter a past tense verb");
		String pastTenseVerb=scan.next();
		System.out.println("Enter an adjective");
		String adjective=scan.next();
		System.out.println("The "+color+" dragon "+pastTenseVerb+ " at the "+adjective+" knight.");
		scan.close();
	}

}
