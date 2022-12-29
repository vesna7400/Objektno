package geometry;

public class Rectangle extends Shape {

	public Point upperLeft;
	public int width;
	public int height;
	
	//Konstruktor
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point upperLeft, int width, int height) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(Point upperLeft, int width, int height, boolean selected) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;
		this.selected = selected;
	}
	
	//Metode
	
	public int circumference() {
		return 2*(width+height);
	}
	
	public int area() {
		return width*height;
	}
	
	public boolean contains(int x, int y) {
		return upperLeft.getX() < x && (upperLeft.getX() + width > x) && upperLeft.getX() < y && upperLeft.getY() + height<y;
	}
	
	public boolean contains (Point p) {
		return this.contains(p.getX(), p.getY());
	}
	

	@Override
	public String toString() {
		return "upper left point: " + upperLeft + ", width: " + width + ", height: " + height;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Rectangle) {
			Rectangle temp = (Rectangle)obj;
			if(temp.getUpperLeft().equals(upperLeft) && 
					temp.getHeight() == height &&
					temp.getWidth() == width) {
				return true;
			}
		}
		return false;
	}
	
	public Point getUpperLeft() {
		return upperLeft;
	}
	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
}
