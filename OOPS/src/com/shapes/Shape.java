package com.shapes;

import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType(propOrder = {"start", "end"})
@XmlSeeAlso({Line.class, Rectangle.class})
public abstract class Shape implements Serializable{
	

	protected Point start;
	protected Point end;
	
	@XmlJavaTypeAdapter(PointAdapter.class)
	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	@XmlJavaTypeAdapter(PointAdapter.class)
	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}
	
	public abstract void draw(Graphics g);
	public abstract Shape createInstance();
}
