package geometry;

public class Circle extends Shape {

	private Point center;
	private int r;
	
	//Konstruktor 
	
	public Circle() {
		
	}
	
	public Circle(Point center, int r) {
		this.center = center;
		this.r = r;
	}
	
	public Circle(Point center, int r, boolean selected) {
		this.center = center;
		this.r = r;
		this.selected = selected;
	}
	
	//Metode
	
	public double circumference() {
		return 2*r*Math.PI;
	}
	
	public double area() {
		return r*r*Math.PI;
	}
	
	public boolean contains (int x, int y) {
		return center.distance(x, y) <= r;
	}
	
	public boolean contains (Point p) {
		return center.distance(p.getX(), p.getY()) <=r;
	}
	
	
	@Override
	public String toString() {
		return "Center: " + center + ", radius" + r;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Circle) {
			Circle temp = (Circle) obj;
			if(temp.getCenter().equals(center) && temp.getR() == r) {
				return true;
			}
		}
		return false;
	}
	
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	
}
