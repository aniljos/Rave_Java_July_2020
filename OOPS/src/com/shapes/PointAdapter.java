package com.shapes;

import java.awt.Point;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class PointAdapter extends XmlAdapter<MyPoint, Point>{

	@Override
	public MyPoint marshal(Point point) throws Exception {
		
		return new MyPoint(point.x, point.y);
	}

	@Override
	public Point unmarshal(MyPoint point) throws Exception {
		
		return new Point(point.getX(), point.getY());
	}

}
