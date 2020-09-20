package day4;

import java.util.ArrayList;
import java.util.Collections;

public class Day4_Q2 {
	public static void main(String[] args) {
		ArrayList<String> countries = new ArrayList<String>();
		countries.add("France");
		countries.add("Spain");
		countries.add("England");
		countries.add("Germany");
		countries.add("Switzerland");
		countries.add("America");
		for (int pos=0;pos<countries.size();pos++)
			System.out.println(countries.get(pos));
		Collections.sort(countries);
		System.out.println();
		for (int pos=0;pos<countries.size();pos++)
			System.out.println(countries.get(pos));
	}
}
