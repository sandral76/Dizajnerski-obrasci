package mvc;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends SurfaceShape {
	private Point center;
	private int radius;
	// private boolean selected;

	public Circle() {
	}

	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		// this.selected = selected;
		setSelected(selected);
	}

	public Circle(Point center, int radius, boolean selected, Color color) {
		this(center, radius, selected);
		setColor(color);
	}

	public Circle(Point center, int radius, boolean selected, Color color, Color innerColor) {
		this(center, radius, selected, color);
		setInnerColor(innerColor);
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	// metosa baca izuzetak ako prosledimo npr negativan radisu
	public void setRadius(int radius) {
		if (radius > 0) {
			this.radius = radius;
		} else {
			throw new NumberFormatException("Radius has to be a value greater than 0!");
		}
	}

	/*
	 * public boolean isSelected() { return selected; }
	 * 
	 * public void setSelected(boolean selected) { this.selected = selected; }
	 */

	public double area() {
		return radius * radius * Math.PI;
	}

	public boolean contains(int x, int y) {
		return this.center.distance(x, y) <= this.radius;
	}

	// primer za overload
	public boolean contains(Point p) {
		return this.center.distance(p.getX(), p.getY()) <= this.radius;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle pomocna = (Circle) obj;
			if (this.center.equals(pomocna.getCenter()) && this.radius == pomocna.getRadius()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/*
	 * @Override public String toString() { return "Circle [center=" + center +
	 * ", radius=" + radius + "]"; }
	 */
	public String toString() {
		// Center=(x,y), radius=10
		return "Center=" + center + ", radius=" + radius;

	}

	@Override
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		// dodajemo /oduzimamo 1 da se ne bi prekolopilo sa ivicom
		g.fillOval(this.center.getX() - this.radius + 1, this.center.getY() - this.radius + 1, this.radius * 2 - 2,
				this.radius * 2 - 2);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		// kruznica-opisuje se kvadrat treba nam gornja leva tacka kvadrata i sirina i
		// visina kvadrata tog
		g.drawOval(this.center.getX() - this.radius, this.center.getY() - this.radius, this.radius * 2,
				this.radius * 2);
		this.fill(g);
		if (isSelected()) {
			// selekotvanje
			g.setColor(Color.BLUE);
			g.drawRect(this.center.getX() - 3, this.center.getY() - 3, 6, 6);
			g.drawRect(this.center.getX() + this.radius - 3, this.center.getY() - 3, 6, 6);// desni kv
			g.drawRect(this.center.getX() - this.radius - 3, this.center.getY() - 3, 6, 6);// levi kv
			g.drawRect(this.center.getX() - 3, this.center.getY() - this.radius - 3, 6, 6);// gornji kv
			g.drawRect(this.center.getX() - 3, this.center.getY() + this.radius - 3, 6, 6);// donji kv
		}
	}

	@Override
	public void moveBy(int byX, int byY) {
		this.center.moveBy(byX, byY);

	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Circle) {
			return this.radius - ((Circle) o).getRadius();
		} else {
			return 0;
		}
	}
}
