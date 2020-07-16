package com;

import java.util.logging.Logger;

import com.math.Math;


public class Application {
	
	private static final Logger logger = Logger.getLogger("Application");

	public static void main(String[] args) {
		
		System.out.println("Application.main()");
		
		logger.info("Logging fro App main");
		
		Math math = new Math();
		
		System.out.println("Math add: " + math.add(2,3 ));
		
		//AppFrame.showFrame();
	}

}
