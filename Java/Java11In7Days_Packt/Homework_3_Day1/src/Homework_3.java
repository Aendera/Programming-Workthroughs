
public class Homework_3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double fahrExample=32.0, celsExample=32.0;
		double newcels, newfahr;
		newcels=(fahrExample - 32)*(5.0/9.0);
		newfahr=(celsExample * (9.0/5)) + 32;
		System.out.println(fahrExample + " in Fahrenheit is "+ newcels +" in celsius");
		System.out.println(celsExample + " in Celsius is "+ newfahr +" in Fahrenheit");
	}

}
