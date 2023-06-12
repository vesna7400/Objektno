package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {

	private Point startPoint;
	private Point endPoint;
	
	//Konstruktori
	
	public Line() {
		
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line (Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		this.selected = selected;
	}
	
	public Line(Point startPoint, Point endPoint, Color color) {
		this(startPoint, endPoint);
		this.color = color;
	}
	
	public Line (Point startPoint, Point endPoint, boolean selected, Color color) {
		this (startPoint, endPoint, color);
		this.selected = selected;
	}
	
	
	//Metode
	
	public double length() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	
	public boolean contains(int x, int y) {
		return (startPoint.distance(x, y) + endPoint.distance(x, y)) - length() <=2;
	}
	
	public boolean contains(Point p) {
		return contains(p.getX(),p.getY());
	}
	
	@Override
	public String toString() {
		return startPoint + "-->" + endPoint;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Line) {
			Line temp = (Line) obj;
			if(this.startPoint.equals(temp.getStartPoint()) &&
					this.endPoint.equals(temp.getEndPoint())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(startPoint.getX(), startPoint.getY(), 
				endPoint.getX(), endPoint.getY());
		if (isSelected()) {
			g.drawRect(startPoint.getX()-3, startPoint.getY()-3, 6, 6);
			g.drawRect(endPoint.getX()-2, endPoint.getY()-3, 6, 6);
		}
	}
	
	@Override
	public void moveTo(int x, int y) {
		//Prazna metoda, ne implementiramo
	}
	
	@Override
	public void moveBy(int byX, int byY) {
		startPoint.moveBy(byX, byY);
		endPoint.moveBy(byX, byY);
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Line) {
			Line temp = (Line)o;
			return ((int)(this.length()-temp.length()));
		}
		return 0;
	}	
	
	// Getters & Setters
	
	public Point getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	public Point getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

}
