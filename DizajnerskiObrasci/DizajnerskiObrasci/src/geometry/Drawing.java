package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel {
	public Drawing() {
		setBackground(Color.WHITE);
	}

	public static void main(String[] args) {

		// povrsina na kojoj radimo(vezbe 6-2 kraj)
		
		JFrame frame = new JFrame("Drawing");
		frame.setSize(800, 600);
		Drawing drawing = new Drawing();
		frame.getContentPane().add(drawing);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void paint(Graphics g) {
		Point p = new Point(50, 60, false, Color.RED);
		p.draw(g);
		
		Line l = new Line(new Point(300, 250), new Point(240, 210), false, Color.BLUE);
		l.draw(g);

		Circle c = new Circle(new Point(450, 120), 40, false, Color.RED, Color.LIGHT_GRAY);
		c.draw(g);

		Rectangle r = new Rectangle(new Point(600, 300), 120, 170, true, Color.RED, Color.YELLOW);
		r.draw(g);
	
		Donut d = new Donut(new Point(400,300),50,30,true, Color.GREEN);
		d.draw(g);
		
		
		//ArrayList
		ArrayList<Shape> shapes= new ArrayList<Shape>();
		shapes.add(p);
		shapes.add(l);
		shapes.add(r);
		shapes.add(c);
		shapes.add(d);
		
		//za prsistp elementima arraya
		Iterator<Shape> it = shapes.iterator();
		while(it.hasNext()) {
			System.out.println("Selected:" + it.next().isSelected());// metoda next vrca naredni el u iteraciji
		}
		
		//treci el iz liste shape
		shapes.get(2).draw(g);
		shapes.get(shapes.size()-1).draw(g);
		 
		//dodati i iscrtati novu liniju u listu tako da ona bude 4. el element u listi
		 Line l1= new Line(new Point(30,30), new Point(60,60));
		 shapes.add(3, l1);
		 shapes.get(3).draw(g);
		 
		 //uklanjanje 3. elementa
		 shapes.remove(2);
		 
		 //setovanje svakog objketa iz liste kao selektovan pomocu iteratora
		 while(it.hasNext()) {
			 it.next().setSelected(true);
			 //it.next pristupanje svakom
		 }
		 
		 //iscrtavanje svakog objekta pomocu it
		 while(it.hasNext()) {
			 it.next().draw(g);
		 }

		 //setujemo kao selektovane samo povrsinske oblike
		 while(it.hasNext()) {
			 if(it.next() instanceof SurfaceShape) {
				 it.next().setSelected(true);
			 }
		 }
		 //umesto iteratora mozmeo koristiti foreach-iscrtavanje svih oblika
		 for(Shape s : shapes) {
			 s.draw(g);
		 }
		 for(Shape s : shapes) {
			 s.setSelected(true);
		 }
	}
}
