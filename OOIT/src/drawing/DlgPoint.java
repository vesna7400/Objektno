package drawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class DlgPoint extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private Point p;
	protected boolean commited;
	private JButton btnColor;
	private Color outlineColor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPoint dialog = new DlgPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPoint() {
		setTitle("Modify Point");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(176, 196, 222));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblX = new JLabel("Coordinate X:");
			lblX.setForeground(new Color(0, 0, 128));
			lblX.setFont(new Font("Calibri", Font.BOLD, 13));
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.gridx = 2;
			gbc_lblX.gridy = 1;
			contentPanel.add(lblX, gbc_lblX);
		}
		{
			JLabel lblY = new JLabel("Coordinate Y:");
			lblY.setForeground(new Color(0, 0, 128));
			lblY.setHorizontalAlignment(SwingConstants.CENTER);
			lblY.setFont(new Font("Calibri", Font.BOLD, 13));
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 4;
			gbc_lblY.gridy = 1;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			txtX = new JTextField();
			GridBagConstraints gbc_txtX = new GridBagConstraints();
			gbc_txtX.insets = new Insets(0, 0, 5, 5);
			gbc_txtX.gridx = 2;
			gbc_txtX.gridy = 2;
			contentPanel.add(txtX, gbc_txtX);
			txtX.setColumns(10);
		}
		{
			{
				txtY = new JTextField();
				GridBagConstraints gbc_txtY = new GridBagConstraints();
				gbc_txtY.insets = new Insets(0, 0, 5, 5);
				gbc_txtY.gridx = 4;
				gbc_txtY.gridy = 2;
				contentPanel.add(txtY, gbc_txtY);
				txtY.setColumns(10);
			}
		}
		JButton btnColor_1 = new JButton("Select color");
		btnColor_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outlineColor = JColorChooser.showDialog(null, "Choose outline color ", btnColor_1.getBackground());
				if (outlineColor != null) {
					btnColor_1.setBackground(outlineColor);
				}
			}
		});
		btnColor_1.setForeground(new Color(0, 0, 139));
		btnColor_1.setBackground(new Color(255, 255, 255));
		btnColor_1.setFont(new Font("Calibri", Font.BOLD, 13));
		GridBagConstraints gbc_btnColor_1 = new GridBagConstraints();
		gbc_btnColor_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnColor_1.gridx = 3;
		gbc_btnColor_1.gridy = 4;
		contentPanel.add(btnColor_1, gbc_btnColor_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Calibri", Font.PLAIN, 13));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						 try {
							if (txtX.getText().isEmpty() || txtY.getText().isEmpty()) {
								JOptionPane.showMessageDialog(null, "All fields are required!", "ERROR", JOptionPane.ERROR_MESSAGE);
							} else if(Integer.parseInt(txtX.getText().toString())<0 || Integer.parseInt(txtY.getText().toString())<0) {
								JOptionPane.showMessageDialog(null, "Insert values greater than 0!", "ERROR", JOptionPane.ERROR_MESSAGE);
							} else {
								p = new Point (Integer.parseInt(txtX.getText().toString()), Integer.parseInt(txtY.getText().toString()), false, outlineColor);
								commited = true;
								dispose();
							}
						} catch (Exception e5) {
							JOptionPane.showMessageDialog(null, "Enter numbers only!", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setForeground(new Color(100, 149, 237));
				okButton.setBackground(new Color(230, 230, 250));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Calibri", Font.PLAIN, 13));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setBackground(new Color(230, 230, 250));
				cancelButton.setForeground(new Color(100, 149, 237));
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

	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

	public boolean isCommited() {
		return commited;
	}

	public void setCommited(boolean commited) {
		this.commited = commited;
	}

	public JButton getBtnColor() {
		return btnColor;
	}

	public void setBtnColor(JButton btnColor) {
		this.btnColor = btnColor;
	}

	public Color getOutlineColor() {
		return outlineColor;
	}

	public void setOutlineColor(Color outlineColor) {
		this.outlineColor = outlineColor;
	}
}