package day5;
import java.io.*;
public class TestingIO {

	public static void main(String[] args) {
		// Reading
		String text = null;
		File file = new File("resources/MyCV.txt");
		
		FileReader fileReader = null;
		BufferedReader br = null;
		try {
			fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);
			text = br.readLine();
			while (text!= null) {
				System.out.println(text);
				text = br.readLine();
			}
			br.close();
			
			fileReader.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		//Writing
		text = "JAVA JAVA HAVA \n"
				+ "C++ C++ C++\n"
				+"Python Python\n"
				+"Do the Prolog!\n";
		file = new File("resources/Info.txt");
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			if (!(file.exists()))
				file.createNewFile();
			
			fw = new FileWriter(file);
			pw = new PrintWriter(fw);
			pw.println(text);
			pw.flush();
			System.out.println("File Saved...>>>");
			pw.close();
			fw.close();
			
		}catch (IOException e) {
			System.out.println("File NOT saved.. >>>");
		}
	}

}
