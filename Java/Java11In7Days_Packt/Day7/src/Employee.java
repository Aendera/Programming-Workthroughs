

public class Employee {
	private String firstName;
	private String surname;
	private double salary;
	private int age;
	public Employee(String firstName, String surname) {
		this.firstName = firstName;
		this.surname = surname;
		this.salary = 0;
		this.age = 30;
	}
	public Employee(String firstName, String surname, int age, double salary) throws EmployeeException {
		this.firstName = firstName;
		this.surname = surname;
		this.salary = salary;
		if (age>70) {
			throw new EmployeeException("Employee too old to work");}
		if (age<18) {
			throw new EmployeeException("Employee too young to work");}
		this.age = age;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getsurname() {
		return surname;
	}
	public void setsurname(String surname) {
		this.surname = surname;
	}
	public double getsalary() {
		return salary;
	}
	public void setsalary(double salary) {
		this.salary = salary;
	}
	public int getage() {
		return age;
	}
	public void setage(int age) {
		this.age =age;
	}
	public String toString() {
		return "\tName: "+ this.surname
				+"\tFirst Name: "+this.firstName
				+"\tSalary: " + this.salary
				+"\tAge: " + this.age ;
	}
}
