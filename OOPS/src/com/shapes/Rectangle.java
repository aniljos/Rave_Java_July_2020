package com.shapes;

import java.awt.Graphics;

public class Rectangle extends Shape {

	@Override
	public void draw(Graphics g) {
		g.drawRect(start.x, start.y, end.x - start.x, end.y - start.y);
	}

	@Override
	public Shape createInstance() {
		
		return new Rectangle();
	}

	
}
