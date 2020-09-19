
public class lessonexample {

	public static void main(String[] args) {
		// Testing Circle - Defining a class
		Circle c1 = new Circle(19, 36);
		Circle c2 = new Circle(3.453, 5, 5);
		double c1Radius = c1.getRadius();
		System.out.println(c1Radius);

		double c2Radius = c2.getRadius();
		System.out.println(c2Radius);
		c1.setRadius(1.24);
		c1Radius = c1.getRadius();
		System.out.println(c1Radius);
		System.out.println("c2 area = "+ c2.calculateArea());
		System.out.println("c2 perimeter = "+ c2.calculatePerimeter());
		System.out.println("c1 toString() method = " + c1.toString());
		//Test inheritance
		int xpos,ypos;
		TwoDShape tds = c1;
		xpos = tds.getXPos();
		ypos = tds.getYPos();
		System.out.println("x, y(tds) = "+xpos+" "+ypos);
		
		tds.setXPos(77);
		xpos=tds.getXPos();
		System.out.println("x, y(tds) = "+xpos+" "+ypos);
		System.out.println("tds toString() method = "+tds.toString());
		xpos=c1.getXPos();
		ypos=c1.getYPos();
		System.out.println("x, y(c1) = "+xpos+" "+ypos);
		DrawShape ds;
		ds = c1;
		ds.draw();
		Rectangle r=new Rectangle(10,4,1,2);
		System.out.println("r area = "+ r.calculateArea());
		System.out.println("r perimeter = "+ r.calculatePerimeter());
		System.out.println("r toString() method = " + r.toString());
	}

}
