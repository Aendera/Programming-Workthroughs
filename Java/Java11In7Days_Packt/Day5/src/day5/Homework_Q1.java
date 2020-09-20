package day5;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Homework_Q1 {
	public static void main(String[] args) {
		String text = null;
		File oldFile = new File("resources/old_names.txt");
		FileReader fileReader = null;
		BufferedReader br = null;
		ArrayList<String> lines = new ArrayList<String>();
		try {
			fileReader = new FileReader(oldFile);
			br = new BufferedReader(fileReader);
			text = br.readLine();
			while(text!= null) {
				System.out.println(text);
				lines.add(text);
				text = br.readLine();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		Collections.sort(lines);
		FileWriter fw = null;
		PrintWriter pw = null;
		File newFile = new File("resources/new_names.txt");
		try {
			if (!(newFile.exists()))
				newFile.createNewFile();
				fw = new FileWriter(newFile);
				pw = new PrintWriter(fw);
			for(int pos=0; pos<lines.size();pos++)
				pw.println(lines.get(pos));
			pw.flush();
			System.out.println("FileSaved");
			pw.close();
			fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
