package geometry;

import java.awt.Color;
import java.awt.Graphics;


public abstract class SurfaceShape extends Shape {

	//surface shape-oblik sa povrsinom ali nasledjuje osobine shape
	
	private Color innerColor;

	public abstract boolean contains(Point p);
	
	public abstract void fill(Graphics g);
	//public abstract double area();
	
	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}
	
	
	
	
}
