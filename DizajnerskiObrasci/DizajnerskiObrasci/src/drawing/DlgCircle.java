package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DlgCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * @wbp.nonvisual location=-28,169
	 */
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtR;
	private Circle circle;
	private boolean confirm;
	private JButton btnInnerColor;
	private JButton btnOutlineColor;
	private JLabel lblCenter;
	private JLabel lblX;
	private JLabel lblY;
	private JLabel lblRadius;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setModal(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setTitle("Add/Modify circle");
		setResizable(false);
		setModal(true);
		setBackground(Color.WHITE);
		
		setBounds(100, 100, 476, 338);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.PINK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblCenter = new JLabel("CENTER OF CIRCLE");
			lblCenter.setFont(new Font("SansSerif", lblCenter.getFont().getStyle(), lblCenter.getFont().getSize() + 3));
		}
		{
			lblX = new JLabel("COORDINATE X:");
			lblX.setFont(new Font("SansSerif", lblX.getFont().getStyle(), lblX.getFont().getSize() + 2));
		}
		{
			txtX = new JTextField();
			txtX.setTransferHandler(null);
			txtX.setColumns(10);
		}
		{
			lblY = new JLabel("COORDINATE Y:");
			lblY.setFont(new Font("SansSerif", lblY.getFont().getStyle(), lblY.getFont().getSize() + 2));
		}
		{
			txtY = new JTextField();
			txtY.setTransferHandler(null);
			txtY.setColumns(10);
		}
		{
			lblRadius = new JLabel("RADIUS:");
			lblRadius.setFont(new Font("SansSerif", lblRadius.getFont().getStyle(), lblRadius.getFont().getSize() + 2));
		}
		{
			txtR = new JTextField();
			txtR.setText("");
			txtR.setTransferHandler(null);
			txtR.setColumns(10);
		}

		btnInnerColor = new JButton("INNER COLOR");
		btnInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color innerColor = JColorChooser.showDialog(null, "Choose inner color", btnInnerColor.getBackground());
				if (innerColor != null)
					btnInnerColor.setBackground(innerColor);

			}
		});
		btnInnerColor.setBackground(Color.WHITE);

		btnOutlineColor = new JButton("OUTLINE COLOR");
		btnOutlineColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color outlineColor = JColorChooser.showDialog(null, "Choose outline color",
						btnOutlineColor.getBackground());
				if (outlineColor != null)
					btnOutlineColor.setBackground(outlineColor);

			}
		});
		btnOutlineColor.setBackground(Color.WHITE);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCenter)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblX)
										.addComponent(lblY)
										.addComponent(lblRadius))
									.addGap(40)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtR)
										.addComponent(txtY)
										.addComponent(txtX, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)))))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(64)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnInnerColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnOutlineColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(131, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(lblCenter)
					.addGap(5)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblX)
						.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblY)
						.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRadius)
						.addComponent(txtR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addComponent(btnInnerColor)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOutlineColor)
					.addGap(59))
		);
		contentPanel.setLayout(gl_contentPanel);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.PINK);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(Color.RED);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtX.getText().trim().isEmpty() || txtY.getText().trim().isEmpty()
								|| txtR.getText().trim().isEmpty()) {
							setConfirm(false);
							JOptionPane.showMessageDialog(null, "All fields are required!", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else {
							try {
								if (Integer.parseInt(txtR.getText().toString()) <= 0
										|| Integer.parseInt(txtX.getText().toString()) < 0
										|| Integer.parseInt(txtY.getText().toString()) < 0) {
									JOptionPane.showMessageDialog(null, "Insert values greather than 0!", "ERROR",
											JOptionPane.ERROR_MESSAGE);
								} else {
									circle = new Circle(

											new Point(Integer.parseInt(txtX.getText().toString()),
													Integer.parseInt(txtY.getText().toString())),
											Integer.parseInt(txtR.getText().toString()), false,
											btnOutlineColor.getBackground(), btnInnerColor.getBackground());
															setConfirm(true);
									setVisible(false);
								}
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "Enter numbers only", "Error",
										JOptionPane.ERROR_MESSAGE);
							}

						}

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("CANCEL");
				cancelButton.setBackground(Color.GREEN);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();

					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getTxtX() {
		return txtX;
	}

	public void setTxtX(JTextField txtX) {
		this.txtX = txtX;
	}

	public JTextField getTxtY() {
		return txtY;
	}

	public void setTxtY(JTextField txtY) {
		this.txtY = txtY;
	}

	public JTextField getTxtR() {
		return txtR;
	}

	public void setTxtR(JTextField txtR) {
		this.txtR = txtR;
	}

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

	public JButton getBtnInnerColor() {
		return btnInnerColor;
	}

	public void setBtnInnerColor(JButton btnInnerColor) {
		this.btnInnerColor = btnInnerColor;
	}

	public JButton getBtnOutlineColor() {
		return btnOutlineColor;
	}

	public void setBtnOutlineColor(JButton btnOutlineColor) {
		this.btnOutlineColor = btnOutlineColor;
	}

}
