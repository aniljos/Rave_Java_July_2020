package com.app;


interface Simple{
	
	//public int x;
	
	public void calc();
}

class SimpleImpl implements Simple{

	@Override
	public void calc() {
		System.out.println("SimpleImpl.calc()");
		
	}
}
public class InterfaceDemo {

	public static void main(String[] args) {
	
		Simple simple = new SimpleImpl();
		simple.calc();
	}
}
