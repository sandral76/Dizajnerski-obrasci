package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import drawing.DlgCircle;
import drawing.DlgDonut;
import drawing.DlgLine;
import drawing.DlgRectangle;
import drawing.FrmDrawing;

public class PnlDrawing extends JPanel {

	private FrmDrawing frame;
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private Point startPoint;
	private Shape selectedShape;

	/**
	 * Create the panel.
	 */

	public PnlDrawing() {

	}

	public PnlDrawing(FrmDrawing frame) {
		this.frame = frame;
		setBackground(Color.WHITE);
		// preko adaptera se osluskuje sta je korisnik kliknuo
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				thisMouseClicked(me);
			}
		});
	}

	protected void thisMouseClicked(MouseEvent me) {
		Shape newShape = null;
		Point click = new Point(me.getX(), me.getY());

		if (frame.getTglbtnSelect().isSelected()) {
			selectedShape = null; // svaki oblik se deselektuje
			Iterator<Shape> iterator = shapes.iterator();

			while (iterator.hasNext()) {
				Shape shape = iterator.next();
				shape.setSelected(false); // nije mogao nijedan bit seletovan dok nije pronadjen sa mestom klika,
											// njihovo seleted je false iz gemetry
				if (shape.contains(click.getX(), click.getY()))// prolazi kroz listu oblika i detektuje koji sadrzi
																// mesto klika
					selectedShape = shape;

			}

			if (selectedShape != null)
				selectedShape.setSelected(true);

		} else if (frame.getRdbtnPoint().isSelected()) {

			newShape = new Point(click.getX(), click.getY(), false, Color.black);

		} else if (frame.getRdbtnLine().isSelected()) {

			if (startPoint == null)
				startPoint = click;
			else {
				newShape = new Line(startPoint, new Point(me.getX(), me.getY(), false, Color.black));
				startPoint = null;
			}

		} else if (frame.getRdbtnCircle().isSelected()) {

			DlgCircle dialog = new DlgCircle();

			dialog.getTxtX().setText("" + Integer.toString(click.getX()));
			dialog.getTxtX().setEditable(false);
			dialog.getTxtY().setText("" + Integer.toString(click.getY()));
			dialog.getTxtY().setEditable(false);
			dialog.setVisible(true);

			if (dialog.isConfirm()) {
				newShape = dialog.getCircle();
			}

		} else if (frame.getRdbtnDonut().isSelected()) {

			DlgDonut dialog = new DlgDonut();
			dialog.setModal(true);
			dialog.getTxtX().setText("" + Integer.toString(click.getX()));
			dialog.getTxtX().setEditable(false);
			dialog.getTxtY().setText("" + Integer.toString(click.getY()));
			dialog.getTxtY().setEditable(false);
			dialog.setVisible(true);

			if (dialog.isConfirm()) {

				newShape = dialog.getDonut();
			}
		} else if (frame.getRdbtnRectangle().isSelected()) {

			DlgRectangle dialog = new DlgRectangle();
			dialog.setModal(true);
			dialog.getTxtX().setText("" + Integer.toString(me.getX()));
			dialog.getTxtX().setEditable(false);
			dialog.getTxtY().setText("" + Integer.toString(me.getY()));
			dialog.getTxtY().setEditable(false);
			dialog.setVisible(true);

			if (dialog.isConfirm()) {
				newShape = dialog.getRect();
			}
		}
		if (newShape != null)
			shapes.add(newShape);

		repaint();

	}

	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Shape> iterator = shapes.iterator();
		while (iterator.hasNext())
			iterator.next().draw(g);

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

	public void setSelectedShape(Shape selectedShape) {
		this.selectedShape = selectedShape;
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

}
