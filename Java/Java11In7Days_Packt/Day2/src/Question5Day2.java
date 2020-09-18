
public class Question5Day2 {
	public static void main(String[] args) {
		int counter = 0;
		while (counter<3) {
			char character='a';
			while (character<'d') {
				System.out.print(character+" ");
				character++;
			}
			System.out.println();
			counter++;
		}
	}
}
