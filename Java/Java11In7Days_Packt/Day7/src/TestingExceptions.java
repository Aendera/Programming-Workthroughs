import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TestingExceptions {
	public static void main(String[] args) {
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
				names.add(text);}
		}catch(IOException e) {
			e.printStackTrace();}
		System.out.println("Reaced circles");
		try {
		Circle c2=new Circle(-2);

		System.out.println(c2.toString());
		}catch(CircleException c) {
			c.printStackTrace();
			System.out.println("Circle Exception caught");
		}
	}
	
}
