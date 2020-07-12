package com;

import java.io.FileInputStream;

public class ExceptionDemo1 {

	public static void main(String[] args) {

		int x = 10, y = 2;
		int result = x / y;
		System.out.println("result: " + result);

		x = 10;
		y = 0;
		if(y != 0)
		{
			result = x / y;
			System.out.println("result: " + result);
		}
		

		try {
			FileInputStream fileInputStream = new FileInputStream("test.txt");
			byte[] allBytes = fileInputStream.readAllBytes();
			String data = new String(allBytes);
			System.out.println("data: " + data);
			fileInputStream.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} 

		System.out.println("ExceptionDemo1.main() exiting...");
	}

}





