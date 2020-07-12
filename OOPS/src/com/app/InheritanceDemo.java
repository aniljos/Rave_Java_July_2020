package com.app;


class Base{
	
	String name;
	
	public Base() {
		System.out.println("Base.Base()");
	}
	public Base(String name) {
		System.out.println("Base.Base() String name");
		this.name = name;
	}
	
	public void print() {
		System.out.println("Base.print()");
	}
}
class Derived extends Base{
	
	public Derived() {
		System.out.println("Derived.Derived()");
	}
	
	public Derived(String name) {
		
		super(name);
		System.out.println("Derived.Derived() String name");
	}
	@Override
	public void print() {
		System.out.println("Derived.print()");
	}
	
}
class Leve2 extends Derived{
	
	public Leve2() {
		System.out.println("Leve2.Leve2()");
	}
	@Override
	public void print() {
		System.out.println("Leve2.print()");
	}
}



public class InheritanceDemo {
	

//	public static void main(String[] args) {
//		
//		Base base = new Base();
//		Derived derived = new Derived();
//		Leve2 leve2 = new Leve2();
//		
//		base  = derived; // base reference refers  to the derived instance
//		derived = (Derived) base; // derived reference assigned with a base reference with casting
//		
//	}
	
	public static void main(String[] args) {
		
		Base base = new Base();
		base.print();
		Derived derived = new Derived("Anil");
		derived.print();
		Leve2 leve2 = new Leve2();
		leve2.print();
		
		System.out.println("-----------Late Binding------------"); // Early Binding===> private, final, static 
		Base b1 = new Base();
		b1.print();
		b1 = new Derived();
		b1.print();
		b1 = new Leve2();
		b1.print();
				
		
	}
}







