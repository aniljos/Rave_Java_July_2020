package com.test;

import java.util.logging.Logger;

import com.Logging;

public class Test {

	private static final Logger logger = Logger.getLogger(Logging.class.getName());
	
	public void print() {
		
		logger.info("This is print...");
		logger.severe("This is print...");
		logger.fine("This is print...");
	}
}
