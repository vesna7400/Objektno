package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape2 extends Shape {

protected Color innerColor;
	
	//public abstract boolean contains(Point p);
	
	public abstract void fill (Graphics g);

	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}
}
