

public class Circle extends TwoDShape implements DrawShape, Comparable<Circle> {
	private double radius;
	

	public Circle(int x, int y) {
		super(x,y);
		radius=1.0;
	}
	public Circle( double newValue, int x, int y) {
		super(x,y);
		radius = newValue;
	}
	
	public Circle(double newValue) throws CircleException  {
		super(0,0);
		if (newValue < 0)
		{
			throw new CircleException("Radius cannot be negative");
			//System.out.println("Radius cannot be negative");
			//System.exit(0);
		}
		radius = newValue;
		// TODO Auto-generated constructor stub
	}
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double newRadiusValue) {
		if (newRadiusValue < 0)
			radius = 1;
		else
			radius = newRadiusValue;
	}
	public double calculateArea() {
		double area;
		area=Math.PI * radius *radius;
		return area;
	}
	public double calculatePerimeter() {
		double perimeter;
		perimeter=Math.PI * 2 *radius;
		return perimeter;
	}
	public String toString() {
		return "radius = " + radius;
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("    ***");
		System.out.println("   *   *");
		System.out.println("  *     *");
		System.out.println("  *     *");
		System.out.println("   *   *");
		System.out.println("    ***");
	}
	@Override
	public int compareTo(Circle o) {
		// TODO Auto-generated method stub
		if(this.radius == o.getRadius())
			return 0;
		else if (this.radius > o.getRadius())
			return 1;
		else
			return -1;
		
	}
}	

