package geometry;

public class Test {

	public static void main(String[] args) {
		
		Point p = new Point(3,5);
		System.out.println(p.toString());
		Point p3 = new Point(3,5);
		Line l = new Line(new Point(5,6), new Point(7,8));
		System.out.println(l.toString());
		Circle c = new Circle(new Point(5,7),6);
		System.out.println(c.toString());
		System.out.println(p.equals(p3));
		
		Point p1 = new Point();
		p1.setX(5);
		p1.setY(7);
		p1.setSelected(true);
		
		System.out.println("X koordinata tacke p1 je: " + p1.getX());
		System.out.println("Y koordinata tacke p1 je: " + p1.getY());
		System.out.println("Selected je postavljeno na: " + p1.isSelected());
		
		Point p2 = new Point();
		p2.setX(4);
		p2.setY(7);
		
		System.out.println("Udaljenost izmedju p1 i p2 je: " + p1.distance(p2.getX(), p2.getY()));
		
		Line l1 = new Line();
		l1.setStartPoint(p1);
		l1.setEndPoint(p2);
		System.out.println(l1.getStartPoint().getX());
		
		Line l2 = new Line();
		l2.setStartPoint(new Point());
		l2.getStartPoint().setX(8);
		System.out.println(l2.getStartPoint().getX());

		Line l3 = new Line();
		l3.setStartPoint(new Point());
		l3.setEndPoint(new Point());
		l3.getStartPoint().setX(7);
		l3.getStartPoint().setY(9);
		l3.getEndPoint().setX(11);
		l3.getEndPoint().setY(19);
		double d = l3.getStartPoint().distance(l3.getEndPoint().getX(), l3.getEndPoint().getY());
		System.out.println(d);
		
		Circle c1 = new Circle();
		c1.setCenter(p2);
		c1.setR(2);
		
		Rectangle r1 = new Rectangle();
		r1.setWidth(5);
		r1.setHeight(3);
		
		Point point = new Point();
		Point myPoint = new Point(3,5);
		System.out.println(myPoint.getX());
		Point myOtherPoint = new Point(3,5,true);
		
		Object o1 = new Point();
		
		Point p4 = new Point(5,5);
		Point p5 = new Point(5,5);
		Line l4 = new Line(p4,p5);
		Rectangle r2 = new Rectangle(p5,50,50,false);
		Circle c2 = new Circle(p4,50,true);
		
		System.out.println(p4 == p5); 
		System.out.println(15 == 15); 
		System.out.println(p4.equals(p5)); 
		System.out.println(p4.equals(c2)); 
		System.out.println(l4.equals(p4)); 
		
	}

}
