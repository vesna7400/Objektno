package sort;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import geometry.Point;
import geometry.Rectangle;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Font;

public class FrmSort extends JFrame {

	private JPanel contentPane;
	DefaultListModel<Rectangle> dlm = new DefaultListModel<Rectangle>();
	ArrayList<Rectangle> listRect = new ArrayList<Rectangle>(); 

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
		setTitle("IM 171/2019 Vjestica Vesna");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 432);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 212));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlSort = new JPanel();
		pnlSort.setBorder(new LineBorder(new Color(0, 255, 255), 2));
		contentPane.add(pnlSort, BorderLayout.CENTER);
		GridBagLayout gbl_pnlSort = new GridBagLayout();
		gbl_pnlSort.columnWidths = new int[]{0, 0};
		gbl_pnlSort.rowHeights = new int[]{0, 0};
		gbl_pnlSort.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlSort.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		pnlSort.setLayout(gbl_pnlSort);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		pnlSort.add(scrollPane, gbc_scrollPane);
		
		JList listSort = new JList();
		scrollPane.setViewportView(listSort);
		listSort.setModel(dlm);
		
		JPanel toolbar = new JPanel();
		toolbar.setBackground(new Color(127, 255, 212));
		contentPane.add(toolbar, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Add rectangle");
		btnAdd.setFont(new Font("Calibri", Font.BOLD, 13));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgSort rect = new DlgSort();
				rect.setVisible(true);
				
				if(rect.commited) {
					int x = Integer.parseInt(rect.getTxtX().getText());
					int y = Integer.parseInt(rect.getTxtY().getText());
					int width = Integer.parseInt(rect.getTxtWidth().getText());
					int height = Integer.parseInt(rect.getTxtHeight().getText());
					
					Rectangle element = new Rectangle(new Point(x, y), width, height);
					
					dlm.addElement(element);
					listRect.add(element);
				}
			}
		});
		btnAdd.setForeground(new Color(0, 255, 255));
		btnAdd.setBackground(new Color(255, 250, 250));
		toolbar.add(btnAdd);
		
		JButton btnSort = new JButton("Sort rectangle");
		btnSort.setFont(new Font("Calibri", Font.BOLD, 13));
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dlm.isEmpty()) {
					JOptionPane.showMessageDialog(null, "List is empty!", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					listRect.sort(null);
					dlm.clear();
					for(int i=0; i<listRect.size(); i++) {
						dlm.addElement(listRect.get(i));
					}
				}
			}
		});
		btnSort.setForeground(new Color(0, 255, 255));
		btnSort.setBackground(new Color(255, 250, 250));
		toolbar.add(btnSort);
	}

}