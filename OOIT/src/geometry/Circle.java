package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape2 {

	protected Point center;
	protected int r;
	
	// Konstruktori
	
	public Circle() {
		
	}
	
	public Circle(Point center, int r) {
		this.center = center;
		this.r = r;
	}
	
	public Circle(Point center, int r, boolean selected) {
		this(center, r);
		this.selected = selected;
	}
	
	public Circle (Point center, int r, boolean selected, Color color) {
		   this (center, r, selected);
		   this.color = color;
	   }
	
	public Circle (Point center, int r,  Color color) {
		   this (center, r);
		   this.color = color;
	   }
	   
	public Circle (Point center, int r,  Color color, Color innerColor) {
		   this (center, r, color);
		   this.innerColor = innerColor;
	   }
	
	 public Circle (Point center, int r, boolean selected, Color color, Color innerColor) {
		   this (center, r, selected, color);
		   this.innerColor = innerColor;
	   }
	 
	// Metode
	
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
			if (this.center.equals(temp.getCenter()) 
					&& r == temp.getR()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawOval(center.getX()-r, center.getY()-r, r*2, r*2);
		this.fill(g);
		if (isSelected()) {
			g.setColor(getColor());
			g.drawRect(center.getX()-3, center.getY()-3, 6, 6);
			g.drawRect(center.getX()- r -3, center.getY()-3, 6, 6);//lijevi kvadrat
			g.drawRect(center.getX()+ r -3, center.getY()-3, 6, 6);//desni kvadrat
			g.drawRect(center.getX()-3, center.getY()-r-3, 6, 6);//gornji kvadrat
			g.drawRect(center.getX()-3, center.getY()+r-3, 6, 6);//donji kvadrat
		}
	}
	
	public void fill (Graphics g) {
		g.setColor(getInnerColor());
		//dodajemo i oduzimamo 1 da se ne bi preklopilo sa ivicom
		g.fillOval(this.center.getX() - this.r + 1, this.center.getY() - this.r + 1, this.r*2 - 2, this.r*2 - 2);
	}
	
	@Override
	public void moveTo(int x, int y) {
		center.moveTo(x, y);
		
	}
	
	@Override
	public void moveBy(int byX, int byY) {
		center.moveBy(byX, byY);
		
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Circle) {
			Circle temp = (Circle)o;
			return ((int)(this.area() - temp.area()));
		}
		return 0;
	}
	

	// Getters & Setters
	
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
