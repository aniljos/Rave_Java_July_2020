package com.app;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowAdapterImpl extends WindowAdapter{

	
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
