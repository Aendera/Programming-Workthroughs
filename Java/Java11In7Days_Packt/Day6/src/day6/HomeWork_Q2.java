package day6;

import java.util.ArrayList;

public class HomeWork_Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Employee> employees= new ArrayList<Employee>();
		for (int i=0; i<20; i++) {
			Employee employee = new Employee("A"+i,"B"+i);
			employee.setsalary(i*500+5000);
			employees.add(employee);
			
		}
		employees.forEach(employee -> System.out.println(employee));
		System.out.println("Filter1");
		employees.stream()
		.filter(employee -> employee.getsalary() <7000)
		.forEach(employee -> System.out.println(employee.getsurname() + " "+ employee.getFirstName()));
		System.out.println("Filter2");
		employees.stream()
		.filter(employee -> employee.getsurname().endsWith("9"))
		.forEach(employee -> System.out.println(employee));
	}

}
