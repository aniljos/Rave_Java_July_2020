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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


class WindowAdapterOuterImpl extends WindowAdapter{
	@Override
	public void windowClosing(WindowEvent e) {
		
		
		System.exit(0);
	}
	
	
}

//class LineActionListener implements ActionListener{
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		System.out.println("Line Clicked");
//		
//	}
//}



public class DrawApp  extends JFrame{
	

	private JPanel canvas = new JPanel();
	private int shape;
	private Point start, end;
	
	
	public DrawApp() {
		
		
		this.setSize(400, 500);
		this.setTitle("Draw App");
		this.addWindowListener(new WindowAdapterOuterImpl());
		this.initializeComponents();
		this.setVisible(true);
		
		

	}
	
	private void initializeComponents() {
		
		
		JButton lineButton = new JButton("Line");
		lineButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Line clicked");
				shape = 1;
				
				
			}
		});
		JButton rectButton = new JButton("Rectangle");
		rectButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Rect clicked");
				shape = 2;
				
				
			}
		});
		
		
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
	
	private  class MouseAdpaterImpl extends MouseAdapter{
		
		@Override
		public void mousePressed(MouseEvent e) {
			//System.out.println("Pressed: " + e.getPoint());
			start = e.getPoint();
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			//System.out.println("Released: " + e.getPoint());
			end = e.getPoint();
			Graphics graphics = canvas.getGraphics();
			if(shape == 1) {
				graphics.drawLine(start.x, start.y, end.x, end.y);
				
			}
			if(shape == 2) {
				graphics.drawRect(start.x, start.y, end.x - start.x, end.y - start.y );
				
			}
			end = null;
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			
			if(end == null) {
				end = start;
			}
			Graphics graphics = canvas.getGraphics();
			graphics.setXORMode(Color.DARK_GRAY);
			if(shape == 1) {
				
				graphics.drawLine(start.x, start.y, end.x, end.y);
				end = e.getPoint();
				graphics.drawLine(start.x, start.y, end.x, end.y);
				
			}
			if(shape == 2) {
				graphics.drawRect(start.x, start.y, end.x - start.x, end.y - start.y );
				end = e.getPoint();
				graphics.drawRect(start.x, start.y, end.x - start.x, end.y - start.y );
				
			}
			
		}
	}
	
	

	public static void main(String[] args) {
		
//		JFrame frame = new JFrame("Draw App");
//		frame.setSize(400, 400);
//		frame.setVisible(true);
		
		new DrawApp();
		
		

	}

}
