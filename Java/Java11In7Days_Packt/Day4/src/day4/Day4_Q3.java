package day4;

import java.util.HashMap;

public class Day4_Q3 {
	public static void main(String[] args) {
		HashMap<Integer,String> employeeIds =new HashMap<Integer,String>();
		print(employeeIds);
		employeeIds.put(12, "Simba Aral");
		employeeIds.put(2,"Jim Kana");
		print(employeeIds);
		employeeIds.remove(12);
		print(employeeIds);
	}
	public static void print(HashMap hashMap) {
		if (hashMap.isEmpty())
			System.out.println("Empty");
		else
			System.out.println("\n" +hashMap);
	}
}
