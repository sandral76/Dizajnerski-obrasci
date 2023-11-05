package composite;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mvc.Shape;
public class SremBanatBacka extends Shape {
	private List<Shape> sremBanatBacka = new ArrayList<Shape>();

	public void add(Shape s) {
		sremBanatBacka.add(s);
	}

	public void remove(Shape s) {
		sremBanatBacka.remove(s);
	}

	@Override
	public void draw(Graphics g) {
		Iterator<Shape> it = sremBanatBacka.iterator();
		while (it.hasNext()) {
			it.next().draw(g);
		}
	}

	@Override
	public void moveBy(int byX, int byY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

}
