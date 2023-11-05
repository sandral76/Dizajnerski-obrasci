package mvc;

import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JPanel;

public class DrawingView extends JPanel {
	private DrawingModel model=new DrawingModel(); //da frame ne bi bio null

	public void setModel(DrawingModel model) {
		this.model = model;
	}
	//poziva java virt masina(stalno se poziva kas pozevmo)
	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Shape> it=model.getShapes().iterator();
		while(it.hasNext()) {
			it.next().draw(g);
		}
		//repaint();
		}

}
