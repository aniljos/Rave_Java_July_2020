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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.ResourceLabels;
import com.shapes.Line;
import com.shapes.Rectangle;
import com.shapes.Shape;
import com.shapes.Shapes;

/***
 * 
 * @author anilj
 *
 */

class OOWindowAdapterOuterImpl extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {

		System.exit(0);
	}
}


public class OODrawApp extends JFrame {

	private JPanel canvas = new JPanel();
	private Shape shape = new Line();
	private JLabel timeLabel;
	private ResourceBundle labelsBundle;
	
	private List<Shape> shapes = new ArrayList<Shape>();

	public OODrawApp() {

		labelsBundle = ResourceBundle.getBundle("labels");
		this.setSize(600, 500);
		this.setTitle("Draw App");
		this.addWindowListener(new OOWindowAdapterOuterImpl());
		this.initializeComponents();
		this.setVisible(true);

	}

	private void initializeComponents() {

		JButton lineButton = new JButton(labelsBundle.getString(ResourceLabels.LINE_LABEL));
		
		/*
		 * lineButton.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * System.out.println("Line clicked");
		 * 
		 * shape = new Line(); } });
		 */
		
		lineButton.addActionListener(e ->  shape = new Line());
		
		
		JButton rectButton = new JButton(labelsBundle.getString(ResourceLabels.RECT_LABEL));
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

		
		JPanel  bottomPanel= new JPanel();
		JButton saveButton = new JButton(labelsBundle.getString(ResourceLabels.SAVE_LABEL));
		saveButton.addActionListener((e) -> {
			
			JFileChooser fileChooser = new JFileChooser();
			int result = fileChooser.showSaveDialog(OODrawApp.this);
			if(result == JFileChooser.APPROVE_OPTION) {
			
				//System.out.println("Selected File: " + fileChooser.getSelectedFile().getName());
				File selectedFile = fileChooser.getSelectedFile();
				
				try(FileOutputStream fileOutputStream = new FileOutputStream(selectedFile)){
					
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
					objectOutputStream.writeObject(shapes);
					System.out.println("Saved all shapes");
					
				}catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
			
			
		});
		
		JButton openButton = new JButton(labelsBundle.getString(ResourceLabels.OPEN_LABEL));
		openButton.addActionListener((e) -> {
			
			JFileChooser fileChooser = new JFileChooser();
			int result = fileChooser.showOpenDialog(OODrawApp.this);
			if(result == JFileChooser.APPROVE_OPTION) {
				
				File selectedFile = fileChooser.getSelectedFile();
				try(FileInputStream fileInputStream = new FileInputStream(selectedFile)){
					
					ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
					shapes = (List<Shape>) inputStream.readObject();
					for (Shape shape : shapes) {
						
						shape.draw(canvas.getGraphics());
					}
					
				}catch (Exception e3) {
					e3.printStackTrace();
				}
			}
			
		});
		
		JButton saveXMLButton = new JButton(labelsBundle.getString(ResourceLabels.SAVE_XML_LABEL));
		saveXMLButton.addActionListener((e) -> {
			
			JFileChooser fileChooser = new JFileChooser();
			int result = fileChooser.showSaveDialog(OODrawApp.this);
			if(result == JFileChooser.APPROVE_OPTION) {
			
				//System.out.println("Selected File: " + fileChooser.getSelectedFile().getName());
				File selectedFile = fileChooser.getSelectedFile();
				
				try {
					Shapes allShapes = new Shapes();
					allShapes.setShapes(shapes);
					
					JAXBContext context = JAXBContext.newInstance(allShapes.getClass());
					Marshaller marshaller = context.createMarshaller();
					marshaller.marshal(allShapes, selectedFile);
					System.out.println("Saved into XML");
					
				} catch (JAXBException e1) {
					
					e1.printStackTrace();
				}
				
				
			}
		});
		JButton openXMLButton = new JButton(labelsBundle.getString(ResourceLabels.OPEN_XML_LABEL));
		openXMLButton.addActionListener((e) -> {
			
			
			JFileChooser fileChooser = new JFileChooser();
			int result = fileChooser.showOpenDialog(OODrawApp.this);
			if(result == JFileChooser.APPROVE_OPTION) {
				
				File selectedFile = fileChooser.getSelectedFile();
				
				
				try {
					Shapes allShapes = new Shapes();
					JAXBContext context = JAXBContext.newInstance(allShapes.getClass());
					Unmarshaller unmarshaller = context.createUnmarshaller();
					allShapes =  (Shapes) unmarshaller.unmarshal(selectedFile);		
					shapes = allShapes.getShapes();
					for (Shape shape : shapes) {
						
						shape.draw(canvas.getGraphics());
					}
					
				} catch (JAXBException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		LocalTime localTime = LocalTime.now();
		timeLabel = new JLabel(localTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
		
		LocalDate localDate = LocalDate.now();
		JLabel dateLabel = new JLabel(localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
		
		
		
		
		bottomPanel.add(saveButton);
		bottomPanel.add(openButton);
		
		bottomPanel.add(saveXMLButton);
		bottomPanel.add(openXMLButton);
		
		bottomPanel.add(dateLabel);
		bottomPanel.add(timeLabel);
		
		this.getContentPane().add(topPanel, BorderLayout.NORTH);
		this.getContentPane().add(canvas, BorderLayout.CENTER);
		this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
		updateTime();
	}

	private void updateTime() {
		
		Thread thread = new Thread(() -> {
			
			while(true) {
				LocalTime localTime = LocalTime.now();
				timeLabel.setText(localTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		thread.start();
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
		
		if(args.length == 2) {
			
			Locale.setDefault(new Locale(args[0], args[1]));
		}
		
		new OODrawApp();

	}

}
