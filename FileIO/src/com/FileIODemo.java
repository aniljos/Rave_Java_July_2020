package com;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileIODemo {

	public static void main(String[] args) {
		
		//byteStreams();
		bufferedStreams();
	}

	private static void bufferedStreams() {
		
		
		//PrintWriter == write to the file
		
		try (//FileReader fileReader = new FileReader("data.txt");
		 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter writer = new PrintWriter("output.txt")) {
			String line = reader.readLine();
			while(!line.equals("exit")) {
				
				System.out.println("You entered: "+ line);
				writer.println(line);
				line = reader.readLine();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	private static void byteStreams() {
		try (FileInputStream fileInputStream = new FileInputStream("data.txt");
				FileOutputStream fileOutputStream = new FileOutputStream("copydata.txt")) {
			int b = fileInputStream.read();
			while(b != -1) {
				
				fileOutputStream.write(b);
				b = fileInputStream.read();
				
			}
			System.out.println("copy completed");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
