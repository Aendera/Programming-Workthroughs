import java.util.Scanner;

public class Homework {
	public static void main(String[] args)  {
		//Testing Employees
		Scanner scan = new Scanner(System.in);
		System.out.println("Employee age");
		int age = scan.nextInt();
		String name = "Ba";
		String surname = "Ra";
		Employee employee=null;
		try {
		employee = new Employee(name, surname,age,20000);
		System.out.println(employee.toString());}catch(Exception e) {
			e.printStackTrace();
		}
		employee.setage(1);
	}
}
