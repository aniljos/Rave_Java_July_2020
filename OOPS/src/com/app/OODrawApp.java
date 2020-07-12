package com.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.shapes.Line;
import com.shapes.Rectangle;
import com.shapes.Shape;

class OOWindowAdapterOuterImpl extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {

		System.exit(0);
	}
}

public class OODrawApp extends JFrame {

	private JPanel canvas = new JPanel();
	private Shape shape = new Line();
	private List<Shape> shapes = new ArrayList<Shape>();

	public OODrawApp() {

		this.setSize(400, 500);
		this.setTitle("Draw App");
		this.addWindowListener(new OOWindowAdapterOuterImpl());
		this.initializeComponents();
		this.setVisible(true);

	}

	private void initializeComponents() {

		JButton lineButton = new JButton("Line");
		/*
		 * lineButton.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * System.out.println("Line clicked");
		 * 
		 * shape = new Line(); } });
		 */
		
		lineButton.addActionListener(e ->  shape = new Line());
		
		
		JButton rectButton = new JButton("Rectangle");
//		rectButton.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("Rect clicked");
//				shape = new Rectangle();
//
//			}
//		});
		
		rectButton.addActionListener(e ->  shape = new Rectangle());

		JPanel topPanel = new JPanel();
		topPanel.add(lineButton);
		topPanel.add(rectButton);

		canvas.setBackground(Color.DARK_GRAY);
		MouseAdpaterImpl mouseAdpaterImpl = new MouseAdpaterImpl();
		canvas.addMouseListener(mouseAdpaterImpl);
		canvas.addMouseMotionListener(mouseAdpaterImpl);

		this.getContentPane().add(topPanel, BorderLayout.NORTH);
		this.getContentPane().add(canvas, BorderLayout.CENTER);
	}

	@Override
	public void paint(Graphics g) {

		super.paint(g);
		System.out.println("OODrawApp.paint()");
		for (Shape shape : shapes) {

			Graphics graphics = canvas.getGraphics();
			shape.draw(graphics);
		}
	}

	private class MouseAdpaterImpl extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {

			shape.setStart(e.getPoint());
		}

		@Override
		public void mouseReleased(MouseEvent e) {

			shape.setEnd(e.getPoint());
			Graphics graphics = canvas.getGraphics();
			shape.draw(graphics);
			shapes.add(shape);

			// create a new instance(Line or rectangle)

//			if(shape is line) {
//				shape = new Line();
//			}
//			
//			if(shape is rect) {
//				shape = new Rectangle();
//			}

			// shape = shape.createInstance();

			try {
				shape = shape.getClass().getDeclaredConstructor().newInstance();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		@Override
		public void mouseDragged(MouseEvent e) {

			if (shape.getEnd() == null) {
				shape.setEnd(shape.getStart());
			}

			Graphics graphics = canvas.getGraphics();
			graphics.setXORMode(Color.DARK_GRAY);
			shape.draw(graphics);
			shape.setEnd(e.getPoint());
			shape.draw(graphics);

		}

	}

	public static void main(String[] args) {

//		JFrame frame = new JFrame("Draw App");
//		frame.setSize(400, 400);
//		frame.setVisible(true);

		new OODrawApp();

	}

}
