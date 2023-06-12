package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Moveable, Comparable {

	protected boolean selected;
	protected Color color;
	
	public Shape() {
		
	}
	
	public Shape(boolean selected) {
		this.selected = selected;
	}
	
	public Shape (boolean selected, Color color) {
    	this(selected);
    	this.color = color;
    }
	
	public Shape (Color color) {
		this.color = color;
	}

	public abstract boolean contains(int x, int y);
	
	public abstract void draw (Graphics g);

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor (Color color) {
		this.color = color;
	}	
	
}
