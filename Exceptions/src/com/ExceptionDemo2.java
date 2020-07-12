package com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionDemo2 {
	
	
	public static int divide(int x, int y) throws Exception{
		
		if(y != 0) {
			return x/y;
		}
		else {
			throw new Exception("Invalid denominator");
		}
	}
	
	public static String readFile(String fileName) throws IOException {
		
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(fileName);
			byte[] allBytes = fileInputStream.readAllBytes();
			String data = new String(allBytes);
			
			return data;
			
		} catch (FileNotFoundException e) {
			
			System.out.println("ExceptionDemo2.readFile() FileNotFoundException");
			throw e;
			
		} catch (IOException e) {
			
			System.out.println("ExceptionDemo2.readFile() IOException");
			throw e;
		}
		finally {
			
			System.out.println("ExceptionDemo2.readFile()-- finally");
			if(fileInputStream != null)
				fileInputStream.close();
		}
		
		
	}
	

	public static void main(String[] args) {

		try {
			int x = 10, y = 2;
			System.out.println("Result: " + divide(x, y));
			
			x = 10;
			y = 0;
			System.out.println("Result: " + divide(x, y));
			
			x = 10;
			y = 5;
			System.out.println("Result: " + divide(x, y));
		} catch (Exception e) {
			
			System.err.println(e.getMessage());
		}
		
		
		try {
			System.out.println("data: " + readFile("test.txt"));
			System.out.println("-----------");
			System.out.println("data: " + readFile("test1.txt"));
			
		} catch (IOException e) {
			
			System.err.println(e.getMessage());
		}

	

		System.out.println("ExceptionDemo1.main() exiting...");
	}

}





