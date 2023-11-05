package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {
	private int x;
	private int y;
	// private boolean selected;

	public Point() {
		
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(int x, int y, boolean selected) {
		this(x, y);
		// iz nadredjene klase Shape
		setSelected(selected);
	}

	public Point(int x, int y, boolean selected, Color color) {
		this(x, y, selected);
		setColor(color);
	}

//(10,20)p1.equals(p3)
//(10,50)
	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x; /*
					 * this ima VREDNOST OBJEKTA ZA KOJI JE OVA METODA POZVANA- tamo u tesu(
					 * p1.setX(5)-this.x je od p1, 5 je int x iz metode, p1 dobija 5)
					 */
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	/*
	 * public boolean isSelected() { return this.selected; }
	 * 
	 * public void setSelected(boolean selected) { this.selected = selected; }
	 */

	public double distance(int x2, int y2) {
		double dx = this.x - x2;
		double dy = this.y - y2;
		double d = Math.sqrt(dx * dx + dy * dy);
		return d;
	}

	public boolean contains(int x, int y) // tacke klika x i y
	{
		if (this.distance(x, y) <= 3) {
			// dozvoljenoo od 3 piksela odstupanje klika
			return true;
		} else
			return false;

		// moze i samo prva linija koda bez if sa return, svakako vraca boolean
	}

	// OVERRIDE-(razlika izmedju overload ili override-preklapanje metode toString
	// iz klase Object)
	public String toString() {
		// (x,y) -u ovom formatu hocemo
		return "(" + this.x + ", " + this.y + ")";
	}

//poredjenje dva objekta-instanceof da li je nesto tipa necega
	public boolean equals(Object obj) {
		// provera da li je uopste tipa tacke
		if (obj instanceof Point) {
			Point pomocna = (Point) obj;// kastovanje u Point
			if (this.x == pomocna.getX() && this.y == pomocna.getY())// moze i samo x ovde umesto getX)
			{
				return true;
			} else {
				return false;
			}

		} else
			return false;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(this.x - 2, this.y, this.x + 2, this.y);
		g.drawLine(this.x, this.y - 2, this.x, this.y + 2);
		//da se nacrta plavi kvadratic ako je tacka selekotvana
		if(isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.x-3, this.y-3, 6, 6);
		}

	}

	@Override
	public void moveBy(int byX, int byY) {
		this.x = this.x + byX;
		this.y = this.y + byY;

	}

	@Override
	public int compareTo(Object o) {
		//poredimo prema udaljenosti od koordinatnog p
		//vraca int jer vraca udaljenost 
		
		if(o instanceof Point) {
			Point pocetak=new Point(0,0);//koordinantni pocetak
			return (int) (this.distance(pocetak.getX(),pocetak.getY())-((Point) o).distance(pocetak.getX(), pocetak.getY()));
		}
		return 0;
	}

}
