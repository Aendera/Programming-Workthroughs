
public class Rectangle extends TwoDShape {
	private int width, height;
	public Rectangle(int width, int height, int x, int y) {
		super(x,y);
		this.width=width;
		this.height=height;
	}
	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return width*height;
	}

	@Override
	public double calculatePerimeter() {
		// TODO Auto-generated method stub
		return 2*(width+height);
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String toString() {
		return "Rectangle: x,y="+ this.getXPos()+" "+ this.getYPos();//using protected would also work
	}

}
