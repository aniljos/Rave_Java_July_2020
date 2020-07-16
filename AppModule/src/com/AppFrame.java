package com;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class AppFrame extends JFrame{

	
	public AppFrame() {
		
		setSize(400, 400);
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
	}
	
	public static void showFrame() {
		new AppFrame();
	}
}
