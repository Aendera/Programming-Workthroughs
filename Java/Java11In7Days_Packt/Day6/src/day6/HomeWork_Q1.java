package day6;

import java.io.*;
import java.util.ArrayList;

public class HomeWork_Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> names = new ArrayList<String>();
		File file = new File("resources/companynames.txt");
		FileReader fileReader;
		BufferedReader bf;
		String text;
		try {
			fileReader = new FileReader(file);
			bf = new BufferedReader(fileReader);
			text = bf.readLine();
			System.out.println("Reached here");
			while((text=bf.readLine()) != null){
				//System.out.println(text);
				names.add(text);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		names.forEach(item-> System.out.println(item));
		System.out.println("Filtered names");
		names.stream()
		.filter(item -> item.startsWith("A"))
		.forEach(item -> System.out.println(item));
	}
	

}
