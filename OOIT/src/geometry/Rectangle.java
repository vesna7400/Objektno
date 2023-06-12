package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape2 {

	private Point upperLeft;
	private int width;
	private int height;
	
	//Konstruktori
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point upperLeft, int width, int height) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle (Point upperLeft, int width, int height, boolean selected) {
		this(upperLeft, width, height);
		this.selected = selected;
	}
	
	public Rectangle (Point upperLeft, int width, int height, boolean selected, Color color) {
		this(upperLeft, width, height, selected);
		this.color = color;
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height, Color color) {
    	this (upperLeftPoint, width, height);
    	this.color = color;
    }
    
    public Rectangle(Point upperLeftPoint, int width, int height,  Color color, Color innerColor) {
    	this (upperLeftPoint, width, height, color);
    	this.innerColor = innerColor;
    }
    
    public Rectangle(Point upperLeftPoint, int width, int height,  boolean selected, Color color, Color innerColor) {
    	this (upperLeftPoint, width, height, color, innerColor);
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
		return (upperLeft.getX() < x && upperLeft.getX() + width > x 
				&& upperLeft.getY() < y && upperLeft.getY() + width > y);
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
			if(this.upperLeft.equals(temp.getUpperLeft()) && this.width == temp.getWidth() 
					&& this.height == temp.getHeight()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawRect(upperLeft.getX(), upperLeft.getY(), width, height);
		this.fill(g);
		if(isSelected()) {
			g.setColor(getColor());
	        g.drawRect(upperLeft.getX() - 3,upperLeft.getY() - 3, 6, 6);
	        g.drawRect(upperLeft.getX() + width - 3,upperLeft.getY() - 3, 6, 6);
	        g.drawRect(upperLeft.getX() - 3,upperLeft.getY() + height - 3, 6, 6);
	        g.drawRect(upperLeft.getX() + width - 3,upperLeft.getY() + height - 3, 6, 6);
		}
	}
	
	public void fill (Graphics g) {
		g.setColor(getInnerColor());
		g.fillRect(this.getUpperLeft().getX() + 1, this.getUpperLeft().getY() + 1, this.width - 1, this.height - 1);
	}
	
	@Override
	public void moveTo(int x, int y) {
		upperLeft.moveTo(x, y);
		
	}

	@Override
	public void moveBy(int byX, int byY) {
		upperLeft.moveBy(byX, byY);
		
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			Rectangle temp = (Rectangle)o;
			return this.area() - temp.area();
		}
		return 0;
	}
	

	// Getters & Setters
	
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
