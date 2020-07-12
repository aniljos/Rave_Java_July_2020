package com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.test.Test;


class TextFormatter extends Formatter
{

	@Override
	public String format(LogRecord record) {
		
		StringBuilder builder = new StringBuilder();
		builder.append("Class: " + record.getSourceClassName());
		builder.append("\n");
		builder.append("Method: " + record.getSourceMethodName());
		builder.append("\n");
		builder.append("Level: " + record.getLevel());
		builder.append("\n");
		builder.append("Message: " + record.getMessage());
		builder.append("\n");
		builder.append("Time: " + record.getMillis());
		builder.append("\n");
		builder.append("\n");
		
		return builder.toString();
	}
	
}



public class Logging {

	private static final Logger logger = Logger.getLogger(Logging.class.getName());
	
	
	
	public static void main(String[] args) {
		
		LogManager.getLogManager().reset();
//		try {
//			
//			LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties"));
//			
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
		
		setLogConfig();
		
		logger.severe("This is a severe message");
		logger.warning("This is a warning message");
		logger.info("This is a info message");
		logger.config("This is a config message");
		logger.fine("This is a fine message");
		logger.finer("This is a finer message");
		
		
		Test test = new Test();
		test.print();
		
		System.out.println("Logging.main()");

	}



	private static void setLogConfig() {
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(Level.CONFIG);
		System.out.println("Log level for console handler: " + consoleHandler.getLevel());
		logger.addHandler(consoleHandler);
		
		
		try {
			
			FileHandler fileHandler = new FileHandler("log.txt", true);
			System.out.println("Log level for file handler: " + fileHandler.getLevel());
			//fileHandler.setFormatter(new SimpleFormatter());
			fileHandler.setFormatter(new TextFormatter());
			logger.addHandler(fileHandler);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		logger.setLevel(Level.ALL);
	}

}
