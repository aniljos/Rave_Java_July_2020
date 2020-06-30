package com;

import java.time.LocalDate;

//scope is the package scope(package-private)
class Test{
	
}

public class Types {

	public static void main(String[] args) {
		
		int x = 100;
		System.out.println("X: " + x);
		
		double amt = 1000;
		double interest = calcInterest(amt, 5, 10);
		System.out.println("Interest: " + interest);
		
		String message = "Hello Types";  // ==> String message = new String("Hello Type");
		LocalDate date = LocalDate.now();
		
		print(message, date);
		System.out.println("Message: " + message);
		
		//x = ++x;
		
		//message += " World ";
		
		

	}
	
	public static void print(String msg, LocalDate dt) {
		
		msg = "Test";
		System.out.println("Message: " + msg);
		System.out.println("Date: " + dt.toString());
	}
	
	
	public static double calcInterest(double amt, int roi, double term) {
		
		//amt = 2000;
		double interest = (amt * roi * term)/100;
		return interest;
	}

}
