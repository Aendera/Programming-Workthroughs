package day4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

public class TestingArrays {
	public static void main(String[] args) {
		//Array intro
		double [ ] temperatures;
		temperatures = new double[3];
		temperatures[0] = 25.6;
		temperatures[1] = 13;
		System.out.println(temperatures[0]);
		String[] names = new String[] {"A","B","C"};
		//ArrayList
		System.out.println(names[2]);
		ArrayList list_One;
		list_One = new ArrayList();
		list_One.add(Integer.valueOf(99));
		list_One.add(new String("Hello World"));
		list_One.add(new Date());
		
		for (int pos = 0; pos < list_One.size(); pos++) {
			System.out.println(list_One.get(pos).toString());
		}
		ArrayList<String> nameList;
		nameList = new ArrayList<String> ();
		nameList.add("Dave");
		nameList.add("Ravi");
		nameList.add("Mike");
		nameList.add("Ala");
		nameList.contains("Ravi");
		nameList.add(3,"Ral");
		for (int pos = 0; pos < nameList.size(); pos++) {
			System.out.println(nameList.get(pos).toString());
		}
		//Sorting
		ArrayList<Circle> circles = new ArrayList<Circle>();
		circles.add(new Circle(99.8));
		circles.add(new Circle(9.8));
		circles.add(new Circle(7.2));;
		circles.add(new Circle(4));
		circles.add(new Circle(949.8));
		circles.add(new Circle(44));
		circles.add(new Circle(33));
		System.out.println("Before sorting");
		for(int pos =0; pos < circles.size(); pos++) {
			Circle tempCircle = circles.get(pos);
			double tempRadius = tempCircle.getRadius();
			System.out.println("circles["+pos+"] radius = "+tempRadius);
		}
		
		Collections.sort(circles);
		System.out.println("After sorting");
		for(int pos =0; pos < circles.size(); pos++) {
			Circle tempCircle = circles.get(pos);
			double tempRadius = tempCircle.getRadius();
			System.out.println("circles["+pos+"] radius = "+tempRadius);
		}
		
		//Autoboxing
		int score =20;
		int intValue = 99;
		Integer iScore = new Integer(score);
		Integer i_Value = intValue;
		System.out.println(iScore);
		System.out.println(score);
		HashMap<Integer, String> cityNamesMap = new HashMap<Integer, String> ();
		cityNamesMap.put(1, "Paris");
		print(cityNamesMap);
		cityNamesMap.putIfAbsent(8,"Cape Town");
		print(cityNamesMap);
		
		
	}
	public static void print(HashMap cityNamesMap) {
		if (cityNamesMap.isEmpty())
			System.out.println("Empty");
		else
			System.out.println("\n" +cityNamesMap);
	}
}
