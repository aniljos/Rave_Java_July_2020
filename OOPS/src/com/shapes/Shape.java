package com.shapes;

import java.awt.Graphics;
import java.awt.Point;


public abstract class Shape {

	protected Point start;
	protected Point end;
	
	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}
	
	public abstract void draw(Graphics g);
	public abstract Shape createInstance();
}
