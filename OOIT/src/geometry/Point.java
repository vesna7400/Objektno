package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {

	private int x;
	private int y;
	
	// Konstruktori
	
	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public Point(int x, int y, boolean selected) {
		this(x,y);
		this.selected=selected;
	}
	
	public Point (int x, int y, Color color) {
		this (x, y);
		this.color = color;
	}
	
	public Point (int x, int y, boolean selected, Color color) {
		this (x, y, selected);
		this.color = color;
	}
	
	//Metode
	
	public double distance(int x, int y) {
		int dX = this.x - x;
		int dY = this.y - y;
		double d = Math.sqrt(dX*dX + dY*dY);
		return d;
	}
	
	public boolean contains (int x, int y) {
		return this.distance(x, y)<=2; //this zato sto ne postoji obiljezje nad kojim mozemo da pozovemo, pozivamo nad objektom te klase
	}
	
	public boolean contains (Point p) {
		return contains(p.getX(), p.getY());
	}
	
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point temp = (Point) obj;
			if (this.x == temp.getX() && this.y == temp.getY()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(this.x - 2, this.y, this.x + 2, this.y);
		g.drawLine(this.x, this.y - 2, this.x, this.y + 2);
		
		if (isSelected()) {
			g.drawRect(this.x - 3, this.y - 3, 6, 6);
		}
	}
	
	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void moveBy(int byX, int byY) {
		this.x += byX;
		this.y = y + byY;
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Point) {
			Point temp = (Point)o;
			return ((int)(this.distance(0, 0) - temp.distance(0, 0)));
		}
		return 0;
	}
	
	// Getters & Setters
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

}
