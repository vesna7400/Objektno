package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import geometry.Circle;
import geometry.Donut;

import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FrmDrawing extends JFrame {

	private JPanel contentPane;
	private PnlDrawing pnlDrawing;
	private int brojac = 0;
	private boolean selected;
	private Point startPoint, endPoint, upperLeft;
	private Color outlineColor, innerColor;
	private ArrayList<Shape> selectedShapes = new ArrayList<Shape>();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Shape lastSelectedShape;

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

	public FrmDrawing() {
		setTitle("IM 171/2019 Vjestica Vesna");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 461);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		pnlDrawing = new PnlDrawing();
		pnlDrawing.setBackground(new Color(255, 255, 255));
		pnlDrawing.setBounds(106, 11, 646, 366);
		pnlDrawing.setBorder(new LineBorder(new Color(126, 189, 245), 2));
		contentPane.setLayout(null);
		
		contentPane.add(pnlDrawing, BorderLayout.CENTER);
		
		JToggleButton tglbtnPoint = new JToggleButton("Point");
		tglbtnPoint.setBounds(9, 82, 87, 23);
		contentPane.add(tglbtnPoint);
		tglbtnPoint.setFont(new Font("Calibri", Font.BOLD, 13));
		tglbtnPoint.setForeground(new Color(30, 144, 255));
		tglbtnPoint.setBackground(new Color(248, 248, 255));
		buttonGroup.add(tglbtnPoint);
		
		JToggleButton tglbtnLine = new JToggleButton("Line");
		tglbtnLine.setBounds(9, 131, 87, 23);
		contentPane.add(tglbtnLine);
		tglbtnLine.setFont(new Font("Calibri", Font.BOLD, 13));
		tglbtnLine.setForeground(new Color(30, 144, 255));
		tglbtnLine.setBackground(new Color(248, 248, 255));
		buttonGroup.add(tglbtnLine);
		
		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		tglbtnRectangle.setBounds(9, 178, 87, 23);
		contentPane.add(tglbtnRectangle);
		tglbtnRectangle.setFont(new Font("Calibri", Font.BOLD, 13));
		tglbtnRectangle.setForeground(new Color(30, 144, 255));
		tglbtnRectangle.setBackground(new Color(248, 248, 255));
		buttonGroup.add(tglbtnRectangle);
		
		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		tglbtnCircle.setBounds(9, 231, 87, 23);
		contentPane.add(tglbtnCircle);
		tglbtnCircle.setFont(new Font("Calibri", Font.BOLD, 13));
		tglbtnCircle.setForeground(new Color(30, 144, 255));
		tglbtnCircle.setBackground(new Color(248, 248, 255));
		buttonGroup.add(tglbtnCircle);
		
		JToggleButton tglbtnDonut = new JToggleButton("Donut");
		tglbtnDonut.setBounds(9, 286, 87, 23);
		contentPane.add(tglbtnDonut);
		tglbtnDonut.setFont(new Font("Calibri", Font.BOLD, 13));
		tglbtnDonut.setForeground(new Color(30, 144, 255));
		tglbtnDonut.setBackground(new Color(248, 248, 255));
		buttonGroup.add(tglbtnDonut);
		JToggleButton tglbtnModify = new JToggleButton("Modify");
		tglbtnModify.setBounds(364, 388, 100, 23);
		contentPane.add(tglbtnModify);
		tglbtnModify.setFont(new Font("Calibri", Font.BOLD, 13));
		tglbtnModify.setForeground(new Color(30, 144, 255));
		tglbtnModify.setBackground(new Color(248, 248, 255));
		tglbtnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnModify.isSelected()) {
					if(pnlDrawing.getShapes().isEmpty()) {
						JOptionPane.showMessageDialog(null, "The field is empty! To perform this operation, please create a shape first.", "ERROR", JOptionPane.ERROR_MESSAGE);
					}else if(selectedShapes.isEmpty()) {
						JOptionPane.showMessageDialog(null, "To modify an object, please select it first.", "ERROR", JOptionPane.ERROR_MESSAGE);
					}else {
						try {
							for(Shape s : pnlDrawing.getShapes()) {
								if(s instanceof Point) {
									if(s.isSelected()) {
										Point temp = (Point) s;
										Point p = new Point();
										
										DlgPoint point = new DlgPoint();
										point.getTxtX().setText(Integer.toString(temp.getX()));
										point.getTxtY().setText(Integer.toString(temp.getY()));
										point.setOutlineColor(temp.getColor());
										point.setVisible(true);
										
										if(point.isCommited()) {
											p = point.getP();
											p.setSelected(false);
											p.moveTo(Integer.parseInt(point.getTxtX().getText()), Integer.parseInt(point.getTxtY().getText()));
											pnlDrawing.getShapes().set(pnlDrawing.getShapes().indexOf(temp), p);
											repaint();
											selectedShapes.clear();
										}
									}
								}else if(s instanceof Line) {
									if(s.isSelected()) {
										Line temp = (Line) s;
										Line l = new Line();
										
										DlgLine line = new DlgLine();
										line.getTxtStartX().setText(Integer.toString(temp.getStartPoint().getX()));
										line.getTxtStartY().setText(Integer.toString(temp.getStartPoint().getY()));
										line.getTxtEndX().setText(Integer.toString(temp.getEndPoint().getX()));
										line.getTxtEndY().setText(Integer.toString(temp.getEndPoint().getY()));
										line.setOutlineColor(temp.getColor());
										line.setVisible(true);
										
										if(line.isCommited()) {
											l = line.getLine();
											l.setSelected(false);
											pnlDrawing.getShapes().add(l);
											pnlDrawing.getShapes().remove(s);
											repaint();
											selectedShapes.clear();
										}
									}
								}else if(s instanceof Rectangle) {
									if(s.isSelected()) {
										Rectangle temp = (Rectangle) s;
										Rectangle r = new Rectangle();
										
										DlgRectangle rect = new DlgRectangle();
										rect.getTxtUpperX().setText(Integer.toString(temp.getUpperLeft().getX()));
										rect.getTxtUpperY().setText(Integer.toString(temp.getUpperLeft().getY()));
										rect.getTxtWidth().setText(Integer.toString(temp.getWidth()));
										rect.getTxtHeight().setText(Integer.toString(temp.getHeight()));
										rect.setInnerColor(temp.getInnerColor());
										rect.setOutlineColor(temp.getColor());
										rect.setVisible(true);
										
										if(rect.isCommited()) {
											r = rect.getRectangle();
											r.setSelected(false);
											pnlDrawing.getShapes().add(r);
											pnlDrawing.getShapes().remove(s);
											repaint();
											selectedShapes.clear();
										}
									}
								}else if(s instanceof Circle && (s instanceof Donut)==false) {
									if(s.isSelected()) {
										Circle temp = (Circle) s;
										Circle c = new Circle();
										
										DlgCircle circle = new DlgCircle();
										circle.getTxtXCenter().setText(Integer.toString(temp.getCenter().getX()));
										circle.getTxtYCenter().setText(Integer.toString(temp.getCenter().getY()));
										circle.getTxtRadius().setText(Integer.toString(temp.getR()));
										circle.setInnerColor(temp.getInnerColor());
										circle.setOutlineColor(temp.getColor());
										circle.setVisible(true);
										
										if(circle.isCommited()) {
											c = circle.getCircle();
											c.setSelected(false);
											pnlDrawing.getShapes().add(c);
											pnlDrawing.getShapes().remove(s);
											repaint();
											selectedShapes.clear();
										}
									}
								}else if(s instanceof Donut) {
									if(s.isSelected()) {
									Donut temp = (Donut) s;
									Donut d = new Donut();
									
									DlgDonut donut = new DlgDonut();
									donut.getTxtX().setText(Integer.toString(temp.getCenter().getX()));
									donut.getTxtY().setText(Integer.toString(temp.getCenter().getY()));
									donut.getTxtOuterRadius().setText(Integer.toString(temp.getR()));
									donut.getTxtInnerRadius().setText(Integer.toString(temp.getInnerR()));
									donut.setInnerColor(temp.getInnerColor());
									donut.setOutlineColor(temp.getColor());
									donut.setVisible(true);
									
									if(donut.isCommited()) {
										d = donut.getDonut();
										d.setSelected(false);
										pnlDrawing.getShapes().add(d);
										pnlDrawing.getShapes().remove(s);
										repaint();
										selectedShapes.clear();
										}
									}
								}
							}
						}catch(Exception cme) {	
						}
					}
				}
			}
		});
		buttonGroup.add(tglbtnModify);
		
		JToggleButton tglbtnDelete = new JToggleButton("Delete");
		tglbtnDelete.setBounds(474, 388, 100, 23);
		contentPane.add(tglbtnDelete);
		tglbtnDelete.setFont(new Font("Calibri", Font.BOLD, 13));
		tglbtnDelete.setForeground(new Color(30, 144, 255));
		tglbtnDelete.setBackground(new Color(248, 248, 255));
		tglbtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pnlDrawing.getShapes().isEmpty()) {
					JOptionPane.showMessageDialog(null, "The field is empty!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else if(selectedShapes.size() == 0) {
					JOptionPane.showMessageDialog(null, "No shapes are currently selected. Please select a shape before proceeding with this operation.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else{
					int selectedOption = JOptionPane.showConfirmDialog(null, "You have selected shapes to be deleted. Are you sure you want to proceed?", "Warning message", JOptionPane.YES_NO_OPTION);
					if (selectedOption == JOptionPane.YES_OPTION) {
						pnlDrawing.getShapes().removeAll(selectedShapes);
						selectedShapes.clear();
						repaint();
					}
				}
			}
		});
		
		
		buttonGroup.add(tglbtnDelete);
		JToggleButton tglbtnSelect = new JToggleButton("Select");
		tglbtnSelect.setBounds(254, 388, 100, 23);
		contentPane.add(tglbtnSelect);
		tglbtnSelect.setFont(new Font("Calibri", Font.BOLD, 13));
		tglbtnSelect.setForeground(new Color(30, 144, 255));
		tglbtnSelect.setBackground(new Color(248, 248, 255));
		buttonGroup.add(tglbtnSelect);
		
		pnlDrawing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tglbtnSelect.isSelected()) {
					
					for(Shape s : pnlDrawing.getShapes()) {
					    if(s.contains(e.getX(), e.getY())) {
					        if(s instanceof Point || s instanceof Line || s instanceof Rectangle || s.getClass() == Circle.class) {
					            if(lastSelectedShape != null && lastSelectedShape != s) {
					                lastSelectedShape.setSelected(false);
					                selectedShapes.remove(lastSelectedShape);
					            }
					            if(!s.isSelected()) {
					                s.setSelected(true);
					                selectedShapes.add(s);
					                lastSelectedShape = s;
					                repaint();
					            } else {
					                s.setSelected(false);
					                selectedShapes.remove(s);
					                lastSelectedShape = null;
					                repaint();
					            }
					        } else if(s instanceof Donut) {
					            if(lastSelectedShape != null && lastSelectedShape != s && lastSelectedShape.getClass() == Donut.class) {
					                lastSelectedShape.setSelected(false);
					                selectedShapes.remove(lastSelectedShape);
					            }
					            if(!s.isSelected()) {
					                s.setSelected(true);
					                selectedShapes.add(s);
					                lastSelectedShape = s;
					                repaint();
					            } else {
					                s.setSelected(false);
					                selectedShapes.remove(s);
					                lastSelectedShape = null;
					                repaint();
					            }
					        }
					    }
					}
				}else if(tglbtnPoint.isSelected()) {
					Point p = new Point(e.getX(),e.getY());
					p.setColor(Color.BLACK);
					pnlDrawing.getShapes().add(p);
					repaint();
				}else if(tglbtnLine.isSelected()){
					brojac++;
					if(brojac == 1) {
						startPoint = new Point(e.getX(),e.getY());
						startPoint.setColor(Color.BLACK);
						//pnlDrawing.getShapes().add(startPoint);
						repaint();
					}else if(brojac == 2){
						endPoint = new Point(e.getX(),e.getY());
						//pnlDrawing.getShapes().remove(startPoint);
						Line l = new Line(startPoint, endPoint);
						l.setColor(Color.BLACK);
						pnlDrawing.getShapes().add(l);
						repaint();
						brojac = 0;
					}
				}else if(tglbtnRectangle.isSelected()) {
					upperLeft = new Point(e.getX(),e.getY());
					DlgRectangle rect = new DlgRectangle();
					rect.getTxtUpperX().setText(Integer.toString(upperLeft.getX()));
					rect.getTxtUpperX().setEditable(false);
					rect.getTxtUpperY().setText(Integer.toString(upperLeft.getY()));
					rect.getTxtUpperY().setEditable(false);
					rect.setVisible(true);
					repaint();
					
					if(rect.isCommited()) {
						Rectangle r = rect.getRectangle();
						pnlDrawing.getShapes().add(r);
						repaint();
					}		
				}else if(tglbtnCircle.isSelected()) {
					Point center = new Point (e.getX(), e.getY());
					DlgCircle circle = new DlgCircle();
					circle.getTxtXCenter().setText(Integer.toString(center.getX()));
					circle.getTxtXCenter().setEditable(false);
					circle.getTxtYCenter().setText(Integer.toString(center.getY()));
					circle.getTxtYCenter().setEditable(false);
					circle.setVisible(true);
					repaint();
					
					if(circle.isCommited()) {
						Circle c = circle.getCircle();
						pnlDrawing.getShapes().add(c);
						repaint();
					}
				}else if(tglbtnDonut.isSelected()) {
					Point center = new Point(e.getX(), e.getY());
					DlgDonut donut = new DlgDonut();
					donut.getTxtX().setText(Integer.toString(center.getX()));
					donut.getTxtX().setEditable(false);
					donut.getTxtY().setText(Integer.toString(center.getY()));
					donut.getTxtY().setEditable(false);
					donut.setVisible(true);
					repaint();
					
					if(donut.isCommited()) {
						Donut d = donut.getDonut();
						//d.setInnerColor(Color.WHITE);
						//d.setColor(Color.BLACK);
						pnlDrawing.getShapes().add(d);
						repaint();
					}
				}
			}
		});
		
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}