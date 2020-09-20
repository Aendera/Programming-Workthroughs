package day6;

public class Employee {
	private String firstName;
	private String surname;
	private double salary;
	public Employee(String firstName, String surname) {
		this.firstName = firstName;
		this.surname = surname;
		this.salary = 0;
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
	public String toString() {
		return "\nName: "+ this.surname
				+"\nFirst Name: "+this.firstName
				+"\nSalary: " + this.salary;
	}
}
