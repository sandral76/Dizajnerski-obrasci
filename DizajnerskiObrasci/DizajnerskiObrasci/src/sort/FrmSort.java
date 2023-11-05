package sort;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import javax.lang.model.util.Elements;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

import javax.swing.JLabel;

public class FrmSort extends JFrame {

	private JPanel contentPane;
	JList listSort = new JList();
	DefaultListModel<Rectangle> dlm = new DefaultListModel<Rectangle>();
	ArrayList<Rectangle> lista = new ArrayList<Rectangle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSort frame = new FrmSort();
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
	public FrmSort() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Lazarevic Sandra IT76/2019");
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(Color.PINK);
		
		JPanel panelSouth = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(panelCenter, GroupLayout.PREFERRED_SIZE, 532, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(26, Short.MAX_VALUE)
					.addComponent(panelSouth, GroupLayout.PREFERRED_SIZE, 506, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelCenter, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelSouth, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addGap(18))
		);
		
		JButton btnAdd = new JButton("Add rectangles");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DlgSort dlgRactk= new DlgSort();
				dlgRactk.setVisible(true);
				if(dlgRactk.isOk) {
					
						int x = Integer.parseInt(dlgRactk.getTextX().getText()); 
						int y = Integer.parseInt(dlgRactk.getTxtY().getText());
						int width = Integer.parseInt(dlgRactk.getTxtWidth().getText());
						int height = Integer.parseInt(dlgRactk.getTxtHeight().getText());
						
						Rectangle rct = new Rectangle(new Point(x,y), height, width); 
						
						dlm.add(0, rct);
						lista.add(rct);
						
					/*String element= ("Upper left point=( " + dlgRactk.getTextX().getText() + " "+ ","+ " " +  dlgRactk.getTxtY().getText() + " " + "), width= " + dlgRactk.getTxtWidth().getText() + " height= " + dlgRactk.getTxtHeight().getText());
					element.compareTo(element);*/
					
				}
				
			}

			
		});
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setFont(new Font("SansSerif", btnAdd.getFont().getStyle(), btnAdd.getFont().getSize() + 2));
		btnAdd.setBackground(Color.PINK);
		
		JButton btnSort = new JButton("Sort rectangles");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(dlm.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "List is empty!");
				}
				else {
					lista.sort(null);//sortira po svom normalnom redoled(od 1-10)
			    //compare to?
				dlm.clear();
				for(int i=0; i<lista.size();i++) {
					dlm.addElement(lista.get(i));
				}
						
					}
					
			
				}
			
		});
		btnSort.setFont(new Font("SansSerif", btnSort.getFont().getStyle(), btnSort.getFont().getSize() + 2));
		btnSort.setBackground(Color.PINK);
		btnSort.setForeground(Color.BLACK);
		GroupLayout gl_panelSouth = new GroupLayout(panelSouth);
		gl_panelSouth.setHorizontalGroup(
			gl_panelSouth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSouth.createSequentialGroup()
					.addGap(62)
					.addComponent(btnAdd)
					.addGap(110)
					.addComponent(btnSort)
					.addGap(138))
		);
		gl_panelSouth.setVerticalGroup(
			gl_panelSouth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSouth.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panelSouth.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(btnSort)))
		);
		panelSouth.setLayout(gl_panelSouth);
		
		JScrollPane scrollPaneSort = new JScrollPane();
		
		JLabel lblName = new JLabel("ADD AND SORT RACTANGLES");
		lblName.setBackground(Color.BLACK);
		lblName.setFont(new Font("SansSerif", lblName.getFont().getStyle(), lblName.getFont().getSize() + 3));
		GroupLayout gl_panelCenter = new GroupLayout(panelCenter);
		gl_panelCenter.setHorizontalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenter.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panelCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPaneSort, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelCenter.setVerticalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblName)
					.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
					.addComponent(scrollPaneSort, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JList listSort_1 = new JList();
		listSort_1.setForeground(Color.BLACK);
		scrollPaneSort.setViewportView(listSort_1);
		listSort_1.setModel(dlm);
		panelCenter.setLayout(gl_panelCenter);
		contentPane.setLayout(gl_contentPane);
		
		
	}
	public static void sort(Objects[] o) {
		
	}
}
