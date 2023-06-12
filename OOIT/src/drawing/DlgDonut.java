package drawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Donut;
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

public class DlgDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtOuterRadius;
	private JTextField txtInnerRadius;
	private Donut donut;
	protected boolean commited;
	private JButton btnInnerColor;
	private JButton btnOutlineColor;
	private Color innerColor = Color.WHITE;
	private Color outlineColor = Color.BLACK;

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
		setTitle("Create/Modify Donut");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(176, 196, 222));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Center of a donut");
			lblNewLabel.setForeground(new Color(0, 0, 128));
			lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 13));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 4;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblCoordinateXCenter = new JLabel("Coordinate X:");
			lblCoordinateXCenter.setForeground(new Color(0, 0, 128));
			lblCoordinateXCenter.setFont(new Font("Calibri", Font.BOLD, 13));
			GridBagConstraints gbc_lblCoordinateXCenter = new GridBagConstraints();
			gbc_lblCoordinateXCenter.anchor = GridBagConstraints.WEST;
			gbc_lblCoordinateXCenter.insets = new Insets(0, 0, 5, 5);
			gbc_lblCoordinateXCenter.gridx = 2;
			gbc_lblCoordinateXCenter.gridy = 2;
			contentPanel.add(lblCoordinateXCenter, gbc_lblCoordinateXCenter);
		}
		{
			txtX = new JTextField();
			GridBagConstraints gbc_txtX = new GridBagConstraints();
			gbc_txtX.gridwidth = 2;
			gbc_txtX.insets = new Insets(0, 0, 5, 5);
			gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtX.gridx = 3;
			gbc_txtX.gridy = 2;
			contentPanel.add(txtX, gbc_txtX);
			txtX.setColumns(10);
		}
		{
			JLabel lblCoordinateYCenter = new JLabel("Coordinate Y:");
			lblCoordinateYCenter.setForeground(new Color(0, 0, 128));
			lblCoordinateYCenter.setFont(new Font("Calibri", Font.BOLD, 13));
			GridBagConstraints gbc_lblCoordinateYCenter = new GridBagConstraints();
			gbc_lblCoordinateYCenter.anchor = GridBagConstraints.WEST;
			gbc_lblCoordinateYCenter.insets = new Insets(0, 0, 5, 5);
			gbc_lblCoordinateYCenter.gridx = 2;
			gbc_lblCoordinateYCenter.gridy = 3;
			contentPanel.add(lblCoordinateYCenter, gbc_lblCoordinateYCenter);
		}
		{
			txtY = new JTextField();
			GridBagConstraints gbc_txtY = new GridBagConstraints();
			gbc_txtY.gridwidth = 2;
			gbc_txtY.insets = new Insets(0, 0, 5, 5);
			gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtY.gridx = 3;
			gbc_txtY.gridy = 3;
			contentPanel.add(txtY, gbc_txtY);
			txtY.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Radius");
			lblNewLabel_1.setForeground(new Color(0, 0, 128));
			lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 13));
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 4;
			gbc_lblNewLabel_1.gridy = 5;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			JLabel lblOuterRadius = new JLabel("Outer Radius:");
			lblOuterRadius.setForeground(new Color(0, 0, 128));
			lblOuterRadius.setFont(new Font("Calibri", Font.BOLD, 13));
			GridBagConstraints gbc_lblOuterRadius = new GridBagConstraints();
			gbc_lblOuterRadius.anchor = GridBagConstraints.WEST;
			gbc_lblOuterRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblOuterRadius.gridx = 2;
			gbc_lblOuterRadius.gridy = 6;
			contentPanel.add(lblOuterRadius, gbc_lblOuterRadius);
		}
		{
			txtOuterRadius = new JTextField();
			GridBagConstraints gbc_txtOuterRadius = new GridBagConstraints();
			gbc_txtOuterRadius.gridwidth = 2;
			gbc_txtOuterRadius.insets = new Insets(0, 0, 5, 5);
			gbc_txtOuterRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtOuterRadius.gridx = 3;
			gbc_txtOuterRadius.gridy = 6;
			contentPanel.add(txtOuterRadius, gbc_txtOuterRadius);
			txtOuterRadius.setColumns(10);
		}
		{
			JLabel lblInnerRadius = new JLabel("Inner Radius:");
			lblInnerRadius.setForeground(new Color(0, 0, 128));
			lblInnerRadius.setFont(new Font("Calibri", Font.BOLD, 13));
			GridBagConstraints gbc_lblInnerRadius = new GridBagConstraints();
			gbc_lblInnerRadius.anchor = GridBagConstraints.WEST;
			gbc_lblInnerRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblInnerRadius.gridx = 2;
			gbc_lblInnerRadius.gridy = 7;
			contentPanel.add(lblInnerRadius, gbc_lblInnerRadius);
		}
		{
			txtInnerRadius = new JTextField();
			GridBagConstraints gbc_txtInnerRadius = new GridBagConstraints();
			gbc_txtInnerRadius.gridwidth = 2;
			gbc_txtInnerRadius.insets = new Insets(0, 0, 5, 5);
			gbc_txtInnerRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtInnerRadius.gridx = 3;
			gbc_txtInnerRadius.gridy = 7;
			contentPanel.add(txtInnerRadius, gbc_txtInnerRadius);
			txtInnerRadius.setColumns(10);
		}
		{
			JButton btnInnerColor = new JButton("Inner Color");
			btnInnerColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					innerColor = JColorChooser.showDialog(null, "Choose inner color", btnInnerColor.getBackground());
					if(innerColor != null) {
						btnInnerColor.setBackground(innerColor);
					}
				}
			});
			btnInnerColor.setBackground(new Color(255, 255, 255));
			btnInnerColor.setForeground(new Color(0, 0, 139));
			GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
			gbc_btnInnerColor.insets = new Insets(0, 0, 5, 5);
			gbc_btnInnerColor.gridx = 4;
			gbc_btnInnerColor.gridy = 9;
			contentPanel.add(btnInnerColor, gbc_btnInnerColor);
		}
		{
			JButton btnOutlineColor = new JButton("Outline Color");
			btnOutlineColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					outlineColor = JColorChooser.showDialog(null, "Choose outline color", btnOutlineColor.getBackground());
					if(outlineColor != null) {
						btnOutlineColor.setBackground(outlineColor);
					}
				}
			});
			btnOutlineColor.setForeground(new Color(0, 0, 139));
			btnOutlineColor.setBackground(new Color(255, 255, 255));
			GridBagConstraints gbc_btnOutlineColor = new GridBagConstraints();
			gbc_btnOutlineColor.insets = new Insets(0, 0, 5, 0);
			gbc_btnOutlineColor.gridx = 5;
			gbc_btnOutlineColor.gridy = 9;
			contentPanel.add(btnOutlineColor, gbc_btnOutlineColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if(txtX.getText().isEmpty() || txtY.getText().isEmpty()
								|| txtOuterRadius.getText().isEmpty() || txtInnerRadius.getText().isEmpty()) {
								JOptionPane.showMessageDialog(null, "All values are required!", "Error", JOptionPane.ERROR_MESSAGE);
							} else if(Integer.parseInt(txtX.getText().toString())<0 || Integer.parseInt(txtY.getText().toString())<0
									|| Integer.parseInt(txtInnerRadius.getText().toString())<0 || Integer.parseInt(txtOuterRadius.getText().toString())<0) {
								JOptionPane.showMessageDialog(null, "Insert values greater then 0!", "Error", JOptionPane.ERROR_MESSAGE);
							} else if(Integer.parseInt(txtInnerRadius.getText().toString()) > Integer.parseInt(txtOuterRadius.getText().toString())) {
								JOptionPane.showMessageDialog(null,"Insert inner radius less than outher radius!", "Error",JOptionPane.ERROR_MESSAGE);
							} else {
								donut = new Donut(new Point(Integer.parseInt(txtX.getText().toString()), Integer.parseInt(txtY.getText().toString())),
										Integer.parseInt(txtOuterRadius.getText().toString()), Integer.parseInt(txtInnerRadius.getText().toString()),
										false, outlineColor, innerColor);
								commited = true;
								setVisible(false);
							}
						} catch(Exception e2) {
							JOptionPane.showMessageDialog(null, "Enter numbers only!", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setBackground(new Color(176, 196, 222));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setBackground(new Color(176, 196, 222));
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

	public JTextField getTxtOuterRadius() {
		return txtOuterRadius;
	}

	public void setTxtOuterRadius(JTextField txtOuterRadius) {
		this.txtOuterRadius = txtOuterRadius;
	}

	public JTextField getTxtInnerRadius() {
		return txtInnerRadius;
	}

	public void setTxtInnerRadius(JTextField txtInnerRadius) {
		this.txtInnerRadius = txtInnerRadius;
	}

	public Donut getDonut() {
		return donut;
	}

	public void setDonut(Donut donut) {
		this.donut = donut;
	}

	public boolean isCommited() {
		return commited;
	}

	public void setCommited(boolean commited) {
		this.commited = commited;
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

	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}

	public Color getOutlineColor() {
		return outlineColor;
	}

	public void setOutlineColor(Color outlineColor) {
		this.outlineColor = outlineColor;
	}

}