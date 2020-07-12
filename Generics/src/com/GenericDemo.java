package com;

/*class Box{

	private Object data;

	public Box(Object data) {
		this.setData(data);
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
 */

//class Box<T> {
//
//	private T data;
//
//	public Box(T data) {
//		this.setData(data);
//	}
//
//	public T getData() {
//		return data;
//	}
//
//	public void setData(T data) {
//		this.data = data;
//	}
//
//}

class Box<T extends Number> {

	private T data;

	public Box(T data) {
		this.setData(data);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}



public class GenericDemo {
	/*
	 * 
	 * public static void main(String[] args) {
	 * 
	 * Box b1 = new Box("hello"); Box b2 = new Box(100);
	 * 
	 * String str = (String)b1.getData(); int value = (int) b2.getData();
	 * System.out.println(str); System.out.println(value);
	 * 
	 * String msg = (String) b2.getData(); System.out.println(msg);
	 * 
	 * }
	 */

	/*
	 * public static void main(String[] args) {
	 * 
	 * Box<String> b1 = new Box<String>("hello"); Box<Integer> b2 = new Box<>(100);
	 * 
	 * String str = b1.getData(); int value = b2.getData();
	 * 
	 * System.out.println(str); System.out.println(value);
	 * 
	 * //String msg = b2.getData(); //compiler error
	 * 
	 * }
	 */

	public static void main(String[] args) {

		//Box<String> b1 = new Box<String>("hello");// compiler error


		Box<Double> b1 = new Box<>(3.14);
		Box<Integer> b2 = new Box<>(100);

		double db = b1.getData();
		int value = b2.getData();

		System.out.println(db);
		System.out.println(value);

		//print(new Box<Number>(1));
		//print(b1);
		//print(b2);

		printAny(new Box<Number>(1));
		printAny(b1);
		printAny(b2);





	}

	public static void print(Box<Number> box) {
		System.out.println("Printing: " + box);
	}

	//unbounded
	public static void printAny(Box<?> box) {
		System.out.println("Printing: " + box.getData());
	}

	//Upper bounder
	public static void printNumber(Box<? extends Number> box) {
		System.out.println("Printing: " + box.getData());
	}

	//Lower bounder
	public static void printInteger(Box<? super Integer> box) {
		System.out.println("Printing: " + box.getData());
	}


}








