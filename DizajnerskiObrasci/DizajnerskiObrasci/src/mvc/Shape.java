package mvc;

import java.awt.Color;
import java.awt.Graphics;

import geometry.Moveable;
public abstract class Shape implements Moveable, Comparable{

	private boolean selected;
	private Color color;

	public Shape() {
	}

	public Shape(Color color) {
		this.color = color;
	}

	public Shape(boolean selected, Color color) {
		this(color);
		this.selected = selected;

	}
    //apstraktna metoda-obezbedjujemo da se implementira u vise klasa, ne moze da ima svoju implementaciju
	public abstract boolean contains(int x, int y);
	public abstract void draw(Graphics g);
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
