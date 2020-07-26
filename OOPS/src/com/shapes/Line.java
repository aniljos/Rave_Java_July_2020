package com.shapes;

import java.awt.Graphics;

public class Line extends Shape{

	@Override
	public void draw(Graphics g) {
		g.drawLine(start.x, start.y, end.x, end.y);
		
	}
	

	@Override
	public Shape createInstance() {
		
		return new Line();
	}

}
