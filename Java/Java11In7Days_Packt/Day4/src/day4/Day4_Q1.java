package day4;

import java.util.Arrays;

public class Day4_Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double [] salaries;
		salaries = new double[200];
		for (int pos=0;pos<salaries.length;pos++)
			salaries[pos]=Math.random()*20001 + 5000;
		System.out.println(salaries);//This should be the address
		double maximum = 0;
		double minimum = 500000;
		double total=0;
		for (int pos=0;pos<salaries.length;pos++) {
			maximum=Math.max(maximum, salaries[pos]);
			minimum=Math.min(minimum, salaries[pos]);
			System.out.println(salaries[pos]);
			total+=salaries[pos];
		}
		System.out.println("Maximum salary: "+maximum);
		System.out.println("Minimum salary: "+minimum);
		System.out.println("Average salary: "+total/salaries.length);
		Arrays.sort(salaries);
		minimum =5000000;
		for (int pos=0;pos<salaries.length;pos++) {
			salaries[pos]*=1.05;
			System.out.println(salaries[pos]);
			minimum=Math.min(minimum, salaries[pos]);
		}

		System.out.println("Minimum salary: "+minimum);
	}

}
