package mvc;

import java.util.ArrayList;

import mvc.Point;
import mvc.Line;
import mvc.Shape;

//smesteni podaci nalaze se u ovoj klasi
//model-nezavisan, ne zna ni za sta drugo(ne referencira nike druge klase)

public class DrawingModel {
	
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private Point startPoint;
	private Shape selectedShape;
	
	public ArrayList<Shape> getShapes() {
		return shapes;
	}
	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}
	public void add(mvc.Shape newShape) {
		shapes.add(newShape);
	}

	public void remove(Shape p) {
		shapes.remove(p);
	}
	
	//vraca sa nekog konkretnog mesta u listi
	public Shape get(int index) {
		return shapes.get(index);
	}
	public Point getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	public Shape getSelectedShape() {
		return selectedShape;
	}
	public void setSelectedShape(Shape shape) {
		this.selectedShape = shape;
	}

	
	
	
}
