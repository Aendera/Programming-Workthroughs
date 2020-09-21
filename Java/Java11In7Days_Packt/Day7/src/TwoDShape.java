

public abstract class TwoDShape {
	private int xPos, yPos;
	
	public TwoDShape ( int x, int y)
	{
		xPos = x;
		yPos = y;
		
	}
	public int getXPos() {
		return xPos;
	}
	public void setXPos(int xPos) {
		this.xPos = xPos;
	}
	public int getYPos() {
		return yPos;
	}
	public void setYPos(int yPos) {
		this.yPos = yPos;
	}
	public abstract double calculateArea();
	public abstract double calculatePerimeter();
	public String toString() {
		return "TwoDShape [x="+xPos+", y="+yPos+"]";
	}
}
