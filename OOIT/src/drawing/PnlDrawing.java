package drawing;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import geometry.Shape;

public class PnlDrawing extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public PnlDrawing() {
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(Shape s: shapes) {
			if(s.isSelected())
			{
				g.setColor(s.getColor());
				s.draw(g);
			}
			else {
				g.setColor(s.getColor());
				s.draw(g);
			}
		}
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}


	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}
	
}