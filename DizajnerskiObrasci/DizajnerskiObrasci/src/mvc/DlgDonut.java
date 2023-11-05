package mvc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mvc.Donut;
import mvc.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DlgDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtR;
	private JTextField txtInnerR;
	public boolean confirm;
	public Donut donut;
	public JButton btnInnerColor;
	public JButton btnOutlineColor;
	private JLabel lblCd;
	private JLabel lblX;
	private JLabel lblY;
	private JLabel lblR;
	private JLabel lblIR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut() {
		setTitle("Add/Modify donut");
		setBackground(Color.WHITE);
		setModal(true);
		setResizable(false);
		
		setBounds(100, 100, 464, 386);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.PINK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblCd = new JLabel("CENTER OF DONUT");
			lblCd.setFont(new Font("SansSerif", lblCd.getFont().getStyle(), lblCd.getFont().getSize() + 3));
		}
		{
			lblX = new JLabel("COORDINATE X:");
			lblX.setFont(new Font("SansSerif", lblX.getFont().getStyle(), lblX.getFont().getSize() + 2));
		}
		{
			txtX = new JTextField();
			txtX.setColumns(10);
		}
		{
			lblY = new JLabel("COORDINATE Y:");
			lblY.setFont(new Font("SansSerif", lblY.getFont().getStyle(), lblY.getFont().getSize() + 2));
		}
		{
			txtY = new JTextField();
			txtY.setColumns(10);
		}
		{
			lblR = new JLabel("RADIUS:");
			lblR.setFont(new Font("SansSerif", lblR.getFont().getStyle(), lblR.getFont().getSize() + 2));
		}
		{
			txtR = new JTextField();
			txtR.setColumns(10);
		}
		{
			lblIR = new JLabel("INNER RADIUS:");
			lblIR.setFont(new Font("SansSerif", lblIR.getFont().getStyle(), lblIR.getFont().getSize() + 2));
		}
		{
			txtInnerR = new JTextField();
			txtInnerR.setColumns(10);
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
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCd)
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblX, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(73))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblY, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(lblR)
								.addComponent(lblIR))
							.addGap(20)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtInnerR)
								.addComponent(txtY, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
								.addComponent(txtR)
								.addComponent(txtX))
							.addGap(96)))
					.addGap(526))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(56)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnInnerColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnOutlineColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(lblCd)
					.addGap(5)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblX)
						.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblY))
					.addGap(35)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblR)
						.addComponent(txtR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIR)
						.addComponent(txtInnerR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addComponent(btnInnerColor)
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addComponent(btnOutlineColor)
					.addGap(46))
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
								|| txtR.getText().trim().isEmpty() || txtInnerR.getText().trim().isEmpty()) {
							setConfirm(false);
							JOptionPane.showMessageDialog(null, "All values are required!", "Error",
									JOptionPane.ERROR_MESSAGE);

						} else {
							try {
								if (Integer.parseInt(txtInnerR.getText().toString()) <= 0
										|| Integer.parseInt(txtR.getText().toString()) <= 0
										|| Integer.parseInt(txtX.getText().toString()) < 0
										|| Integer.parseInt(txtY.getText().toString()) < 0)
									JOptionPane.showMessageDialog(null, "Insert values greater then 0!", "Error",
											JOptionPane.ERROR_MESSAGE);
								else {
									if (Integer.parseInt(txtInnerR.getText().toString()) < Integer
											.parseInt(txtR.getText().toString())) {
										donut = new Donut(
												new Point(Integer.parseInt(txtX.getText().toString()),
														Integer.parseInt(txtY.getText().toString())),
												Integer.parseInt(txtR.getText().toString()),
												Integer.parseInt(txtInnerR.getText().toString()), false,
												btnOutlineColor.getBackground(), btnInnerColor.getBackground());

										setConfirm(true);
										setVisible(false);
									} else {
										JOptionPane.showMessageDialog(null,
												"Please insert inner radius less than outher radius!", "Error",
												JOptionPane.ERROR_MESSAGE);
									}

								}
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "Enter numbers only!", "Error",
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

	public JTextField getTxtInnerR() {
		return txtInnerR;
	}

	public void setTxtInnerR(JTextField txtInnerR) {
		this.txtInnerR = txtInnerR;
	}

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

	public Donut getDonut() {
		return donut;
	}

	public void setDonut(Donut donut) {
		this.donut = donut;
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
