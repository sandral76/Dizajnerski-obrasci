package mvc;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends SurfaceShape implements Comparable{
	private Point upperLeft;
	private int width;
	private int height;
	// private boolean selected;

	public Rectangle() {
	}

	public Rectangle(Point upperLeft, int width, int height) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;
	}

	public Rectangle(Point upperLeft, int width, int height, boolean selected) {
		this(upperLeft, width, height);
		// this.selected=selected;
		setSelected(selected);
	}

	public Rectangle(Point upperLeft, int width, int height, boolean selected, Color color) {
		this(upperLeft, width, height, selected);
		setColor(color);
	}

	public Rectangle(Point upperLeft, int width, int height, boolean selected, Color color, Color innerColor) {
		this(upperLeft, width, height, selected, color);
		setInnerColor(innerColor);
	}

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

	public int area() {
		return width * height;
	}

	public boolean contains(int x, int y) {
		if (this.upperLeft.getX() <= x && this.upperLeft.getY() <= y && x <= this.upperLeft.getX() + this.width
				&& y <= this.upperLeft.getY() + this.height) {
			return true;
		} else {
			return false;
		}
	}
	/*public boolean contains(Point p) {
		if (this.upperLeft.getX() <= p.getX() &&
				this.upperLeft.getY() <= p.getY() &&
				p.getX() <= this.upperLeft.getX() + this.width &&
				p.getY() <= this.upperLeft.getY() + this.height) {
			return true;
		} else {
			return false;
		}
	}*/

	/*
	 * public boolean isSelected() { return selected; }
	 * 
	 * public void setSelected(boolean selected) { this.selected = selected; }
	 */

	public String toString() {
		// Upper left =(x,y), width=10, height=20
		return "Upper left point=" + upperLeft.toString() + ", width=" + width + " height=" + height;
		// moze i samo upperLeft-jer je ova tacka tipa Point pa ce se ispisati u tom
		// formatu
	}

	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle pomocna = (Rectangle) obj;
			if (this.upperLeft.equals(pomocna.getUpperLeft()) && this.width == pomocna.getWidth()
					&& this.height == pomocna.getHeight()) {
				return true;
			} else
				return false;

		} else
			return false;

	}

	@Override
	public boolean contains(Point p) {
		return false;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawRect(this.getUpperLeft().getX(), this.getUpperLeft().getY(), this.width, this.height);
		this.fill(g);
		
		//za seletovanje
		if(isSelected()) {
		g.setColor(Color.BLUE);
		g.drawRect(this.upperLeft.getX() - 3, this.upperLeft.getY() - 3, 6, 6);
		g.drawRect(this.upperLeft.getX() - 3, this.upperLeft.getY() + this.height - 3, 6, 6);// donji levi
		g.drawRect(this.upperLeft.getX() + this.width - 3, this.upperLeft.getY() + this.height - 3, 6, 6);// donji desni
		g.drawRect(this.upperLeft.getX() + this.width - 3, this.upperLeft.getY() - 3, 6, 6);// gornji desni
	}
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillRect(this.getUpperLeft().getX() + 1, this.getUpperLeft().getY() + 1, this.width - 2, this.height - 2);

	}

	@Override
	public void moveBy(int byX, int byY) {
		this.upperLeft.moveBy(byX, byY);
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			return this.area()-((Rectangle) o).area();
		}
		return 0;
	}
}
