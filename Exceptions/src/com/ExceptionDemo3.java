package com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class FileResource implements AutoCloseable{

	// String name;
	FileInputStream fileInputStream;

	public FileResource(String name) throws FileNotFoundException {

		fileInputStream = new FileInputStream(name);

	}

	public String readAll() throws IOException {

		byte[] allBytes = fileInputStream.readAllBytes();
		String data = new String(allBytes);
		return data;

	}

	public void close() throws IOException {

		System.out.println("FileResource.close()");
		fileInputStream.close();
	}

}

public class ExceptionDemo3 {

	public static void main(String[] args) {

		// invokePreJava7();

		try (FileResource fileResource = new FileResource("test.txt");
						FileResource fileResource1 = new FileResource("test.txt")) {

			System.out.println("data: " + fileResource.readAll());
		} catch (Exception e) {

			System.err.println(e.getMessage());
		}

	}

	private static void invokePreJava7() {
		FileResource fileResource = null;
		try {
			fileResource = new FileResource("test.txt");
			// fileResource.writeToFile();
			System.out.println("data: " + fileResource.readAll());

		} catch (Exception e) {

			System.err.println(e.getMessage());
		} finally {

			try {
				fileResource.close();
			} catch (IOException e) {

			}
		}
	}

}
