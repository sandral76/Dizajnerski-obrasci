package mvc;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

import mvc.Point;
import mvc.Line;
import mvc.Circle;
import mvc.Donut;
import mvc.Rectangle;
import mvc.Shape;
import mvc.SurfaceShape;
import mvc.DlgPoint;
import mvc.DlgLine;
import mvc.DlgCircle;
import mvc.DlgDonut;
import mvc.DlgRectangle;
//kontroler zaduzen za dodavanje obj
public class DrawingController {

	private DrawingModel model;
	private DrawingFrame frame;

	public DrawingController(DrawingModel model, DrawingFrame frame) {
		//da ne budu null
		this.model = model;
		this.frame = frame;
	}

	public void mouseClicked(MouseEvent e) {
		Shape newShape = null;
		Point click = new Point(e.getX(), e.getY());

		if (frame.getTglbtnSelect().isSelected()) {
			model.setSelectedShape(null); // svaki oblik se deselektuje
			Iterator<Shape> iterator = model.getShapes().iterator();

			while (iterator.hasNext()) {
				Shape shape = iterator.next();
				shape.setSelected(false); // nije mogao nijedan bit seletovan dok nije pronadjen sa mestom klika,
											// njihovo seleted je false iz gemetry
				if (shape.contains(click.getX(), click.getY()))// prolazi kroz listu oblika i detektuje koji sadrzi
																// mesto klika
					model.setSelectedShape(shape);

			}

			if (model.getSelectedShape() != null)
				model.getSelectedShape().setSelected(true);

		} else if (frame.getRdbtnPoint().isSelected()) {

			newShape = new Point(click.getX(), click.getY(), false, Color.black);

		}
		else if (frame.getRdbtnLine().isSelected()) {

			if (model.getStartPoint() == null)
				model.setStartPoint(click);
			else {
				newShape = new Line(model.getStartPoint(), new Point(e.getX(), e.getY(), false, Color.black));
				model.setStartPoint(null);
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

		}else if (frame.getRdbtnDonut().isSelected()) {

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
		dialog.getTxtX().setText("" + Integer.toString(e.getX()));
		dialog.getTxtX().setEditable(false);
		dialog.getTxtY().setText("" + Integer.toString(e.getY()));
		dialog.getTxtY().setEditable(false);
		dialog.setVisible(true);

		if (dialog.isConfirm()) {
			newShape = dialog.getRect();
		}
	}
		if (newShape != null)
		model.add(newShape);
		
		frame.repaint();
		    
		/*SrembanatBacka sremBanatBacka=new SrembanatBacka();
		Point srem=new Point(20,20,false,Color.BLUE);
		Point banat=new Point(30,20,false,Color.BLUE);
		Point backa=new Point(20,20,false,Color.BLUE);
		
		sremBanatBacka.add(srem);
		sremBanatBacka.add(banat);
		sremBanatBacka.add(backa);
		    
		model.add(sremBanatBacka);*/
		
		
	}
	
	public void buttonModify(ActionEvent e) {
		if (model.getSelectedShape()!= null) {
			modify();
			model.getSelectedShape().setSelected(false); //kad se se zavrsi modifakcija nece vise biti selektovan

		} else {
			JOptionPane.showMessageDialog(null, "Please, select what you want to modify!", "Error",
					JOptionPane.ERROR_MESSAGE);
			frame.tglbtnSelect.setSelected(true);
		}
		
		model.setSelectedShape(null);
		frame.tglbtnSelect.setSelected(false);

	}
	
	protected void modify() {

		Shape selectedShape = model.getSelectedShape();

		if (selectedShape != null) {

			if (selectedShape instanceof Point) {

				Point p = (Point) selectedShape;
				DlgPoint dialog = new DlgPoint();

				dialog.getTxtX().setText("" + Integer.toString(p.getX()));
				dialog.getTxtY().setText("" + Integer.toString(p.getY()));
				dialog.getBtnColor().setBackground(p.getColor());
				dialog.setVisible(true);

				if (dialog.isConfirm()) {
					model.getShapes().remove(selectedShape);//uklanja nemodifikovani
					model.getShapes().add(dialog.getP());//doaje novi modifikovani u panel
					frame.repaint();
				}

			} else if (selectedShape instanceof Donut) {

				Donut donut = (Donut) selectedShape;
				DlgDonut dialogd = new DlgDonut();

				dialogd.getTxtX().setText("" + Integer.toString(donut.getCenter().getX()));
				dialogd.getTxtY().setText("" + Integer.toString(donut.getCenter().getY()));
				dialogd.getTxtR().setText("" + Integer.toString(donut.getRadius()));
				dialogd.getTxtInnerR().setText("" + Integer.toString(donut.getInnerRadius()));
				dialogd.getBtnInnerColor().setBackground(donut.getInnerColor());
				dialogd.getBtnOutlineColor().setBackground(donut.getColor());
				dialogd.setModal(true);
				dialogd.setVisible(true);

				if (dialogd.isConfirm()) {
					model.getShapes().remove(selectedShape);
					model.getShapes().add(dialogd.getDonut());
					frame.repaint();
				}
			} else if (selectedShape instanceof Circle && (selectedShape instanceof Donut) == false) {

				Circle circle = (Circle) selectedShape;
				DlgCircle dialog = new DlgCircle();

				dialog.getTxtX().setText("" + Integer.toString(circle.getCenter().getX()));
				dialog.getTxtY().setText("" + Integer.toString(circle.getCenter().getY()));
				dialog.getTxtR().setText("" + Integer.toString(circle.getRadius()));
				dialog.getBtnInnerColor().setBackground(circle.getInnerColor());
				dialog.getBtnOutlineColor().setBackground(circle.getColor());

				dialog.setVisible(true);
				dialog.setModal(true);

				if (dialog.isConfirm()) {
					model.getShapes().remove(selectedShape);
					model.getShapes().add(dialog.getCircle());
					frame.repaint();
				}

			} else if (selectedShape instanceof Line) {

				Line line = (Line) selectedShape;
				DlgLine dialog = new DlgLine();

				dialog.getTxtSPX().setText("" + Integer.toString(line.getStartPoint().getX()));
				dialog.getTxtSPY().setText("" + Integer.toString(line.getStartPoint().getY()));
				dialog.getTxtEPX().setText("" + Integer.toString(line.getEndPoint().getX()));
				dialog.getTxtEPY().setText("" + Integer.toString(line.getEndPoint().getY()));
				dialog.getBtnOutlineColor().setBackground(line.getColor());

				dialog.setVisible(true);

				if (dialog.isConfirm()) {

					model.getShapes().remove(selectedShape);
					model.getShapes().add(dialog.getLine());
					frame.repaint();
				}

			} else if (selectedShape instanceof Rectangle) {

				Rectangle rect = (Rectangle) selectedShape;
				DlgRectangle dialog = new DlgRectangle();

				dialog.getTxtX().setText("" + Integer.toString(rect.getUpperLeft().getX()));
				dialog.getTxtY().setText("" + Integer.toString(rect.getUpperLeft().getY()));
				dialog.getTxtHeight().setText("" + Integer.toString(rect.getHeight()));
				dialog.getTxtWidth().setText("" + Integer.toString(rect.getWidth()));
				dialog.getBtnInnerColor().setBackground(rect.getInnerColor());
				dialog.getBtnOutlineColor().setBackground(rect.getColor());
				dialog.setModal(true);
				dialog.setVisible(true);

				if (dialog.isConfirm()) {
					model.getShapes().remove(selectedShape);
					model.getShapes().add(dialog.getRect());
					frame.repaint();
				}
			}

		}
	}
	
	public void buttonDelete(ActionEvent e) {
		delete();
		frame.tglbtnSelect.setSelected(false);
	}
	protected void delete() {

		Shape selectedShape = model.getSelectedShape();

		if (selectedShape != null) {
			int selectedOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Warning message",
					JOptionPane.YES_NO_OPTION);
			if (selectedOption == JOptionPane.YES_OPTION) {
				model.getShapes().remove(selectedShape);//lista 
			}
		} else {
			JOptionPane.showMessageDialog(null, "You haven't selected any shape!", "Error",
					JOptionPane.WARNING_MESSAGE);
		}
		model.setSelectedShape(null);
		frame.repaint();
	}
	
	
}
	
	
	
	
	
	
	


