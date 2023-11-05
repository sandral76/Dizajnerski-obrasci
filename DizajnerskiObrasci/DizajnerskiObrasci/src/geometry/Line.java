package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
	private Point startPoint;
	private Point endPoint;
	// private boolean selected;

	public Line() {
	}

	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;

	}

	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		setSelected(selected);
	}
	public Line(Point startPoint, Point endPoint, boolean selected,Color color) {
		this(startPoint, endPoint,selected);
		setColor(color);
	}
	public double length() {
		return startPoint.distance(endPoint.getX(), endPoint. getY());
	}

	public boolean contains(int x, int y) {
		if ((startPoint.distance(x, y) + endPoint.distance(x, y)) - this.length() <= 0.05) {
			return true;
		} else {
			return false;

		}
	}

	public boolean equals(Object obj) {
		if (obj instanceof Line) {
			Line pomocna = (Line) obj;
			if (this.startPoint.equals(pomocna.getStartPoint()) && this.endPoint.equals(pomocna.getEndPoint())) {
				return true;
			} else {
				return false;
			}
		} else
			return false;
	}

	public Point getStartPoint() {
		return this.startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return this.endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	/*public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}*/

	public String toString() {
		// (x,y)-->(x,y)
		return startPoint.toString();
		// return startPoint + "--->" + endPoint; -moze i ovako
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(this.getStartPoint().getX(),this.getStartPoint().getY(), this.getEndPoint().getX(), this.getEndPoint().getY());
		
		if(isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.startPoint.getX()-3, this.startPoint.getY()-3, 6, 6);
			g.drawRect(this.endPoint.getX()-3,this.endPoint.getY()-3,6,6);
			g.drawRect((this.startPoint.getX()+this.endPoint.getX())/2, (this.startPoint.getY()+this.endPoint.getY())/2, 6, 6);
		}
		/*na ispitu moze doci metoda za vracanje sredine linije
		public Point middlePoint() {
		 int middlebyY=(this.startPoint.getY()+this.endPoint.getY())/2;
		 int middleByX=(this.startPoint.getX()+this.endPoint.getX())/2;
		 Point middlePoint=new Point(middleByX, middlebyY);
		 return middlePoint;
		 */
	 }

	@Override
	public void moveBy(int byX, int byY) {
		 this.startPoint.moveBy(byX, byY);
		 this.endPoint.moveBy(byX, byY);
		
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Line) {
			return (int) (this.length()- ((Line) o).length());
		}
		return 0;
	}
	
	
	
	
   
}
	
	
			
	
