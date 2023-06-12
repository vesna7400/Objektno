package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {
	
	// Obelezja
	
	private int innerR;
	
	// Konstruktori
	
	public Donut() {
		
	}
	 
	public Donut(Point center, int r, int innerR) {
		super(center, r);
		this.innerR = innerR;
	}
	
	public Donut(Point center, int r, int innerR, boolean selected) {
		this(center, r, innerR);
		this.selected = selected;
	}
	
	public Donut(Point center, int r, int innerR, boolean selected, Color color) {
	 	this(center, r, innerR, selected);
	 	this.color = color;
	}
	    
	public Donut (Point center, int r, int innerR , Color color) {
	 	this(center, r, innerR);
	 	this.color = color;
	}
	    
	public Donut (Point center, int r, int innerR, Color color, Color innerColor) {
	  	this(center, r, innerR,color);
	  	this.innerColor = innerColor;
	}
	    
	public Donut(Point center, int r, int innerR, boolean selected, Color color, Color innerColor) {
	  	this(center, r, innerR, selected, color);
	  	this.innerColor = innerColor;
	}

	// Metode
	
	@Override
	public double circumference() {
		return super.circumference() + 2 * innerR * Math.PI;
	}
	
	@Override
	public double area() {
		return super.area() - innerR * innerR * Math.PI;
	}

	@Override
	public String toString() {
		return super.toString() + ", inner radius: " + innerR;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Donut) {
			Donut temp = (Donut) obj;
			if(this.center.equals(temp.getCenter()) &&
					this.r == temp.getR() &&
					this.innerR == temp.getInnerR()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g); //crtanje spoljasnjeg kruga
		g.setColor(getColor());
		g.drawOval(super.center.getX()-innerR, super.center.getY()-innerR,
				innerR*2, innerR*2);
		if (isSelected()) {
        g.drawRect(this.getCenter().getX() - innerR - 2,this.getCenter().getY() - 2, 4, 4);
        g.drawRect(this.getCenter().getX() + innerR - 2,this.getCenter().getY() - 2, 4, 4);
        g.drawRect(this.getCenter().getX() - 2,this.getCenter().getY() - innerR - 2, 4, 4);
        g.drawRect(this.getCenter().getX() - 2,this.getCenter().getY() + innerR - 2, 4, 4);
		}
	}
	
    public void fill(Graphics g) {
    	g.setColor(getInnerColor());
    	super.fill(g);
    	g.setColor(Color.WHITE);
    	g.fillOval(this.getCenter().getX() - this.getInnerR() + 1, this.getCenter().getY() - this.getInnerR() + 1, this.getInnerR()*2 - 1, this.getInnerR()*2 - 1);
    }
    
	@Override
	public int compareTo(Object o) {
		if (o instanceof Donut) {
		return (int)(this.area() - ((Donut)o).area());
		}
		return 0;
	}
	
	@Override
	public boolean contains (int x, int y) {
		return super.contains(x, y) && super.getCenter().distance(x, y) >= innerR; 
	}
	
	@Override
	public boolean contains (Point p) {
		return this.contains(p.getX(), p.getY());
	}
	
	
	// Getters & Setters
	
	public int getInnerR() {
		return innerR;
	}

	public void setInnerR(int innerR) {
		this.innerR = innerR;
	}
	
}