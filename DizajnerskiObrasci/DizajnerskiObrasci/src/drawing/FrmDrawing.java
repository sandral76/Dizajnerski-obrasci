package drawing;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

import javax.swing.ButtonGroup;

import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JRadioButton;

public class FrmDrawing extends JFrame {

	private JPanel contentPane;
	private PnlDrawing pnlDrawing = new PnlDrawing(this);
	JRadioButton rdbtnPoint = new JRadioButton("POINT");
	JRadioButton rdbtnLine = new JRadioButton("LINE");
	JRadioButton rdbtnCircle = new JRadioButton("CIRCLE");
    JRadioButton rdbtnDonut = new JRadioButton("DONUT");
	JRadioButton rdbtnRectangle = new JRadioButton("RECTANGLE");
	private JToggleButton tglbtnSelect = new JToggleButton("SELECT");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDrawing frame = new FrmDrawing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmDrawing() {
		tglbtnSelect.setFont(new Font("SansSerif", tglbtnSelect.getFont().getStyle(), tglbtnSelect.getFont().getSize() + 2));
		tglbtnSelect.setBackground(new Color(0, 204, 255));

		setTitle("Lazarevic Sandra IT76/2019");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 567);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		pnlDrawing.setBackground(Color.WHITE);
		GroupLayout gl_pnlDrawing = new GroupLayout(pnlDrawing);
		gl_pnlDrawing.setHorizontalGroup(
			gl_pnlDrawing.createParallelGroup(Alignment.LEADING)
				.addGap(0, 674, Short.MAX_VALUE)
		);
		gl_pnlDrawing.setVerticalGroup(
			gl_pnlDrawing.createParallelGroup(Alignment.LEADING)
				.addGap(0, 463, Short.MAX_VALUE)
		);
		pnlDrawing.setLayout(gl_pnlDrawing);

		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(new Color(255, 175, 175));

		ButtonGroup btnGroup = new ButtonGroup();//da samo jedan moze biti selektovan

		btnGroup.add(rdbtnPoint);
		btnGroup.add(rdbtnLine);
		btnGroup.add(rdbtnCircle);
	    btnGroup.add(rdbtnDonut);
	    btnGroup.add(rdbtnRectangle);
		
		
				JButton btnModify = new JButton("MODIFY");
				btnModify.setFont(new Font("SansSerif", btnModify.getFont().getStyle(), btnModify.getFont().getSize() + 2));
				btnModify.setBackground(new Color(51, 204, 204));
				btnModify.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if (pnlDrawing.getSelectedShape() != null) {
							modify();
							pnlDrawing.getSelectedShape().setSelected(false); //kad se se zavrsi modifakcija nece vise biti selektovan

						} else {
							JOptionPane.showMessageDialog(null, "Please, select what you want to modify!", "Error",
									JOptionPane.ERROR_MESSAGE);
							tglbtnSelect.setSelected(true);
						}
						
						pnlDrawing.setSelectedShape(null);
						tglbtnSelect.setSelected(false);

					}
				});
				
		btnGroup.add(btnModify);
				JButton btnDelete = new JButton("DELETE");
				btnDelete.setFont(new Font("SansSerif", btnDelete.getFont().getStyle(), btnDelete.getFont().getSize() + 2));
				btnDelete.setBackground(new Color(51, 204, 204));
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						delete();
						tglbtnSelect.setSelected(false);
					}
				});
				btnGroup.add(btnDelete);
				
		GroupLayout gl_pnlNorth = new GroupLayout(pnlNorth);
		gl_pnlNorth.setHorizontalGroup(
			gl_pnlNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNorth.createSequentialGroup()
					.addGroup(gl_pnlNorth.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlNorth.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pnlNorth.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnPoint, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnLine, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnCircle, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnDonut, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_pnlNorth.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_pnlNorth.createParallelGroup(Alignment.LEADING)
								.addComponent(tglbtnSelect)
								.addGroup(gl_pnlNorth.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnDelete)
									.addComponent(btnModify))))
						.addGroup(gl_pnlNorth.createSequentialGroup()
							.addContainerGap()
							.addComponent(rdbtnRectangle, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		gl_pnlNorth.setVerticalGroup(
			gl_pnlNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNorth.createSequentialGroup()
					.addGap(25)
					.addComponent(rdbtnPoint)
					.addGap(18)
					.addComponent(rdbtnLine)
					.addGap(18)
					.addComponent(rdbtnCircle)
					.addGap(18)
					.addComponent(rdbtnDonut)
					.addGap(18)
					.addComponent(rdbtnRectangle)
					.addGap(116)
					.addComponent(tglbtnSelect)
					.addGap(18)
					.addComponent(btnModify)
					.addGap(18)
					.addComponent(btnDelete)
					.addContainerGap(86, Short.MAX_VALUE))
		);
		pnlNorth.setLayout(gl_pnlNorth);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnlNorth, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(pnlDrawing, GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlNorth, GroupLayout.PREFERRED_SIZE, 515, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlDrawing, GroupLayout.PREFERRED_SIZE, 515, GroupLayout.PREFERRED_SIZE))
					.addGap(129))
		);
		contentPane.setLayout(gl_contentPane);

		pnlDrawing.repaint();
	}

	protected void delete() {

		Shape selectedShape = pnlDrawing.getSelectedShape();

		if (selectedShape != null) {
			int selectedOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Warning message",
					JOptionPane.YES_NO_OPTION);
			if (selectedOption == JOptionPane.YES_OPTION) {
				pnlDrawing.getShapes().remove(selectedShape);//lista 
			}
		} else {
			JOptionPane.showMessageDialog(null, "You haven't selected any shape!", "Error",
					JOptionPane.WARNING_MESSAGE);
		}
		pnlDrawing.setSelectedShape(null);
		pnlDrawing.repaint();
	}

	protected void modify() {

		Shape selectedShape = pnlDrawing.getSelectedShape();

		if (selectedShape != null) {

			if (selectedShape instanceof Point) {

				Point p = (Point) selectedShape;
				DlgPoint dialog = new DlgPoint();

				dialog.getTxtX().setText("" + Integer.toString(p.getX()));
				dialog.getTxtY().setText("" + Integer.toString(p.getY()));
				dialog.getBtnColor().setBackground(p.getColor());
				dialog.setVisible(true);

				if (dialog.isConfirm()) {
					pnlDrawing.getShapes().remove(selectedShape);//uklanja nemodifikovani
					pnlDrawing.getShapes().add(dialog.getP());//doaje novi modifikovani u panel
					repaint();
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
					pnlDrawing.getShapes().remove(selectedShape);
					pnlDrawing.getShapes().add(dialogd.getDonut());
					repaint();
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
					pnlDrawing.getShapes().remove(selectedShape);
					pnlDrawing.getShapes().add(dialog.getCircle());
					repaint();
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

					pnlDrawing.getShapes().remove(selectedShape);
					pnlDrawing.getShapes().add(dialog.getLine());
					repaint();
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
					pnlDrawing.getShapes().remove(selectedShape);
					pnlDrawing.getShapes().add(dialog.getRect());
					repaint();
				}
			}

		}
	}

	public PnlDrawing getPnlDrawing() {
		return pnlDrawing;
	}

	public void setPnlDrawing(PnlDrawing pnlDrawing) {
		this.pnlDrawing = pnlDrawing;
	}


	public JToggleButton getTglbtnSelect() {
		return tglbtnSelect;
	}

	public void setTglbtnSelect(JToggleButton tglbtnSelect) {
		this.tglbtnSelect = tglbtnSelect;
	}

	public JRadioButton getRdbtnPoint() {
		return rdbtnPoint;
	}

	public void setRdbtnPoint(JRadioButton rdbtnPoint) {
		this.rdbtnPoint = rdbtnPoint;
	}

	public JRadioButton getRdbtnLine() {
		return rdbtnLine;
	}

	public void setRdbtnLine(JRadioButton rdbtnLine) {
		this.rdbtnLine = rdbtnLine;
	}

	public JRadioButton getRdbtnCircle() {
		return rdbtnCircle;
	}

	public void setRdbtnCircle(JRadioButton rdbtnCircle) {
		this.rdbtnCircle = rdbtnCircle;
	}

	public JRadioButton getRdbtnDonut() {
		return rdbtnDonut;
	}

	public void setRdbtnDonut(JRadioButton rdbtnDonut) {
		this.rdbtnDonut = rdbtnDonut;
	}

	public JRadioButton getRdbtnRectangle() {
		return rdbtnRectangle;
	}

	public void setRdbtnRectangle(JRadioButton rdbtnRectangle) {
		this.rdbtnRectangle = rdbtnRectangle;
	}

	
}
