package com.shapes;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//<shapes>
//	<shape>

@XmlRootElement(name="shapes")
public class Shapes {

	private List<Shape> shapes = new ArrayList<Shape>();
	
	

	@XmlElement(name="shape")
	public List<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(List<Shape> shapes) {
		this.shapes = shapes;
	}
	
}
