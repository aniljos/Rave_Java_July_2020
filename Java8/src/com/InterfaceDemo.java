package com;

class SimpleImpl implements Simple, Complex{

	@Override
	public void task() {
		System.out.println("SimpleImpl.task()");
		
	}

	@Override
	public void complexTask() {
		System.out.println("SimpleImpl.complexTask()");
		
	}
	
	@Override
	public void executeTask() {
		
		//Simple.super.executeTask();
		
		Complex.super.executeTask();
		
//		System.out.println("started SimpleImpl.exeucteTask()");
//		task();
//		System.out.println("complted SimpleImpl.exeucteTask()");
	}

	
}

interface A{
	
	default void m1() {
		System.out.println("interface A.m1()");
	}
}

class T{
	
	public void m1() {
		System.out.println("class T.m1()");
	}
}

class X extends T implements A{
	
	
}

public class InterfaceDemo {

	public static void main(String[] args) {
		
		SimpleImpl simple = new SimpleImpl();
		simple.executeTask();
		
		X x = new X();
		x.m1();
		
		Simple.buildAllTasks();

	}

}






