package mvc;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class DrawingFrame extends JFrame {

	private DrawingView view = new DrawingView();// moze da keira jer je top level panel,moze a ne mora sa novim kreiranjem
	private DrawingController controller;
	
	
	JRadioButton rdbtnPoint = new JRadioButton("POINT");
	JRadioButton rdbtnLine = new JRadioButton("LINE");
	JRadioButton rdbtnCircle = new JRadioButton("CIRCLE");
    JRadioButton rdbtnDonut = new JRadioButton("DONUT");
	JRadioButton rdbtnRectangle = new JRadioButton("RECTANGLE");
	JToggleButton tglbtnSelect = new JToggleButton("SELECT");
 
	public DrawingFrame() {
		view.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.mouseClicked(e); // iz kontr poziva neku metodu
			}
		});
         
		// JPanel panel = new JPanel();
		setTitle("Lazarevic Sandra IT76/2019");
		setBounds(100, 200, 929, 567);
		getContentPane().add(view, BorderLayout.CENTER);// umesto jpanela ubacili smo nas view na koji cemo smestati crteze
		view.setBackground(Color.white);
        
		view.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(new Color(255, 175, 175));
		
		ButtonGroup btnGroup = new ButtonGroup();//da samo jedan moze biti selektovan
		btnGroup.add(rdbtnPoint);
		btnGroup.add(rdbtnLine);
		btnGroup.add(rdbtnCircle);
	    btnGroup.add(rdbtnDonut);
	    btnGroup.add(rdbtnRectangle);
	    
	    tglbtnSelect.setFont(new Font("SansSerif", tglbtnSelect.getFont().getStyle(), tglbtnSelect.getFont().getSize() + 2));
		tglbtnSelect.setBackground(new Color(0, 204, 255));
	    
	    JButton btnModify = new JButton("MODIFY");
	    btnModify.setHorizontalAlignment(SwingConstants.LEFT);
		btnModify.setFont(new Font("SansSerif", btnModify.getFont().getStyle(), btnModify.getFont().getSize() + 2));
		btnModify.setBackground(new Color(51, 204, 204));
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.buttonModify(e);
			}
		});
		btnGroup.add(btnModify);
		
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("SansSerif", btnDelete.getFont().getStyle(), btnDelete.getFont().getSize() + 2));
		btnDelete.setBackground(new Color(51, 204, 204));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.buttonDelete(e);
			}
		});
		btnGroup.add(btnDelete);
		
        view.add(pnlNorth);
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
        			.addGap(0))
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
		GroupLayout gl_contentPane = new GroupLayout(getContentPane());
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnlNorth, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(view, GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlNorth, GroupLayout.PREFERRED_SIZE, 515, GroupLayout.PREFERRED_SIZE)
						.addComponent(view, GroupLayout.PREFERRED_SIZE, 515, GroupLayout.PREFERRED_SIZE))
					.addGap(129))
		);
		getContentPane().setLayout(gl_contentPane);
		view.repaint();
	}
	    
	public DrawingView getView() {
		return view;
	}

	public void setController(DrawingController controller) {
		this.controller = controller;
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

	public JToggleButton getTglbtnSelect() {
		return tglbtnSelect;
	}

	public void setTglbtnSelect(JToggleButton tglbtnSelect) {
		this.tglbtnSelect = tglbtnSelect;
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
