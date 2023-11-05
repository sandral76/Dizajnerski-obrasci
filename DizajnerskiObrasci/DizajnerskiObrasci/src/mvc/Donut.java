package mvc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

// extends-prosirujemo klasu circle,samo jednom klasom mozemo prosiriti, klasa Donut nasledjuje sve sto ima Circle plus joj dodajemo jos 
public class Donut extends Circle {
	private int innerRadius;
	// private boolean selected;

	public Donut() {
	}

	public Donut(Point center, int radius, int innerRadius) {
		// super koristimo umesto this kod kontruktora
		super(center, radius);// konstrukotr druge metode iz klase Circle, mora biti prva linija koda
		this.innerRadius = innerRadius;

	}

	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center, radius, innerRadius); // pozivamo vec inicijalizovane iz metode iznad
		// this.selected=selected;
		setSelected(selected);
	}
	public Donut(Point center, int radius, int innerRadius, boolean selected,Color color) {
		this(center, radius, innerRadius,selected); 
	setColor(getColor());
	}
	public Donut(Point center, int radius, int innerRadius, boolean selected, Color color, Color innerColor) {
		this(center, radius, innerRadius, selected, color);
		setInnerColor(innerColor);
	}
	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}

	/*
	 * public boolean isSelected() { return selected; }
	 
	 * public void setSelected(boolean selected) { this.selected = selected; }
	 */

	// ispis donuta
	public String toString() {
		return super.toString() + ", inner radius=" + this.innerRadius;
	}

	// area

	public double area() {
		return super.area() - this.innerRadius * this.innerRadius * Math.PI;
	}

	// equals

	// koristi SUPER

	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut pomocna = (Donut) obj;
			// moze i super samo ako posaljemo krug vratice tacno a to necemo
			if (this.getCenter().equals(pomocna.getCenter()) && this.getRadius() == pomocna.getRadius()
					&& this.getInnerRadius() == pomocna.getInnerRadius()) {
				return true;
			} else
				return false;
		}
		return false;
	}

	public boolean contains(int x, int y) {
		double dFromCenter = this.getCenter().distance(x, y);
		return super.contains(x, y) && dFromCenter > innerRadius;
	}
	/*public void fill(Graphics g) {
		g.fillOval(this.getCenter().getX()-this.getRadius()+1,this.getCenter().getY()+1, )
	}*/
	public void draw(Graphics g) {
		
		Graphics2D g2D=(Graphics2D)g;
		Shape out=new Ellipse2D.Double(this.getCenter().getX()-this.getRadius()-2, this.getCenter().getY()-this.getRadius()-2, this.getRadius()*2, this.getRadius()*2);
		Shape inner=new Ellipse2D.Double(this.getCenter().getX()-this.getInnerRadius()-2, this.getCenter().getY()-this.getInnerRadius()-2,this.getInnerRadius()*2,this.getInnerRadius()*2);
		Area circle=new Area(out);
		circle.subtract(new Area(inner));
		
		g2D.setColor(getInnerColor());
		g2D.fill(circle);
		g2D.setColor(getColor());
		g2D.draw(circle);
	}
	    /*super.draw(g);
	    g.setColor(getColor());
		g.drawOval(this.getCenter().getX()-this.getInnerRadius(), this.getCenter().getY()-this.getInnerRadius(),this.getInnerRadius()*2,this.getInnerRadius()*2);
		
		
	}
	
	public void fill(Graphics g) {
        
		g.setColor(getInnerColor());
		super.fill(g);
		g.setColor(Color.WHITE);
		g.fillOval(this.getCenter().getX()-this.getInnerRadius()+1, this.getCenter().getY()-this.getInnerRadius()+1, this.getInnerRadius()*2-2, this.getInnerRadius()*2-2);
		
	}*/
	@Override
	public int compareTo(Object o) {
		if (o instanceof Donut) {
			return (int) (this.area() - ((Donut) o).area());
		}
		return 0;
	}
	
}
