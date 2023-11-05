package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Line;
import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DlgLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private boolean confirm;
	private JTextField txtSPX;
	private JTextField txtSPY;
	private JTextField txtEPX;
	private JTextField txtEPY;
	public Line line;
	private Color color = Color.BLACK;
	private JButton btnOutlineColor;
	private JLabel lblSp;
	private JLabel lblSY;
	private JLabel lblSX;
	private JLabel lblEp;
	private JLabel lblEY;
	private JLabel lblEX;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLine() {
		setModal(true);
		setTitle("Modify line");
		setBackground(Color.WHITE);
		setResizable(false);
		
		setBounds(100, 100, 513, 366);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.PINK);
		
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblSp = new JLabel("START POINT ");
			lblSp.setFont(new Font("SansSerif", lblSp.getFont().getStyle(), lblSp.getFont().getSize() + 3));
		}
		{
			lblSY = new JLabel("COORDINATE X:");
			lblSY.setFont(new Font("SansSerif", lblSY.getFont().getStyle(), lblSY.getFont().getSize() + 2));
		}
		{
			txtSPX = new JTextField();
			txtSPX.setColumns(10);
		}
		{
			lblSX = new JLabel("COORDINATE Y:");
			lblSX.setFont(new Font("SansSerif", lblSX.getFont().getStyle(), lblSX.getFont().getSize() + 2));
		}
		{
			txtSPY = new JTextField();
			txtSPY.setText("");
			txtSPY.setColumns(10);
		}
		{
			lblEp = new JLabel("END POINT");
			lblEp.setFont(new Font("SansSerif", lblEp.getFont().getStyle(), lblEp.getFont().getSize() + 3));
		}
		{
			lblEY = new JLabel("COORDINATE X:");
			lblEY.setFont(new Font("SansSerif", lblEY.getFont().getStyle(), lblEY.getFont().getSize() + 2));
		}
		{
			txtEPX = new JTextField();
			txtEPX.setColumns(10);
		}
		{
			lblEX = new JLabel("COORDINATE Y:");
			lblEX.setFont(new Font("SansSerif", lblEX.getFont().getStyle(), lblEX.getFont().getSize() + 2));
		}
		{
			txtEPY = new JTextField();
			txtEPY.setText("");
			txtEPY.setColumns(10);
		}

		btnOutlineColor = new JButton("OUTLINE COLOR");
		btnOutlineColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color outlineColor = JColorChooser.showDialog(null, "Choose outline color",
						btnOutlineColor.getBackground());
				if (outlineColor != null)
					btnOutlineColor.setBackground(outlineColor);

			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSp)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblSX, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblSY, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
									.addGap(28)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtEPY, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtSPY, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtSPX, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtEPX, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEp)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblEX, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblEY, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnOutlineColor))))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(17))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(lblSp)
					.addGap(7)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSY)
						.addComponent(txtSPX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSX)
						.addComponent(txtSPY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(lblEp)
					.addGap(9)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEY)
						.addComponent(txtEPX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEX)
						.addComponent(txtEPY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
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
				okButton.setBackground(new Color(0, 255, 0));
				okButton.setForeground(new Color(0, 0, 0));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtSPX.getText().trim().isEmpty() || txtSPY.getText().trim().isEmpty()
								|| txtEPX.getText().trim().isEmpty() || txtEPY.getText().trim().isEmpty()) {
							confirm = false;
							JOptionPane.showMessageDialog(null, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
						} else {
							try {
								if (Integer.parseInt(txtSPX.getText().toString()) < 0
										|| Integer.parseInt(txtSPY.getText().toString()) < 0
										|| Integer.parseInt(txtEPX.getText().toString()) < 0
										|| Integer.parseInt(txtEPY.getText().toString()) < 0) {
									JOptionPane.showMessageDialog(null, "Insert values greater than 0!", "Error",
											JOptionPane.ERROR_MESSAGE);

								} else {
									line = new Line(
											new Point(Integer.parseInt(txtSPX.getText().toString()),
													Integer.parseInt(txtSPY.getText().toString())),
											new Point(Integer.parseInt(txtEPX.getText().toString()),
													Integer.parseInt(txtEPY.getText().toString())),
											false, btnOutlineColor.getBackground());

									confirm = true;
									setVisible(false);

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
				cancelButton.setBackground(new Color(255, 0, 0));
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

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

	public JTextField getTxtSPX() {
		return txtSPX;
	}

	public void setTxtSPX(JTextField txtSPX) {
		this.txtSPX = txtSPX;
	}

	public JTextField getTxtSPY() {
		return txtSPY;
	}

	public void setTxtSPY(JTextField txtSPY) {
		this.txtSPY = txtSPY;
	}

	public JTextField getTxtEPX() {
		return txtEPX;
	}

	public void setTxtEPX(JTextField txtEPX) {
		this.txtEPX = txtEPX;
	}

	public JTextField getTxtEPY() {
		return txtEPY;
	}

	public void setTxtEPY(JTextField txtEPY) {
		this.txtEPY = txtEPY;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	public JButton getBtnOutlineColor() {
		return btnOutlineColor;
	}

	public void setBtnOutlineColor(JButton btnOutlineColor) {
		this.btnOutlineColor = btnOutlineColor;
	}

}
