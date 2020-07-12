package com;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SerializationDemo {

	public static void main(String[] args) {
		
		
//		serialize();
//		deserialize();
		
		//writeExternalize();
		readExternalize();
		
	}

	private static void deserialize() {
		
		try (FileInputStream fileInputStream = new FileInputStream("employee.dat");
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
			Employee employee = (Employee) objectInputStream.readObject();
			employee.print();
			
		} catch (ClassNotFoundException | IOException e) {
			
			e.printStackTrace();
		}
			
		
	}

	private static void serialize() {
		
		//Employee employee = new Employee(100, "Anil", 60000);
		Employee employee = new Employee(100, "Anil", 60000, "abcd", new Address("Mumbai", "MAH"));
		
		
		try (FileOutputStream fileOutputStream = new FileOutputStream("employee.dat");
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
			
			objectOutputStream.writeObject(employee);
			System.out.println("Employee saved");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	private static void writeExternalize() {
		
		//Employee employee = new Employee(100, "Anil", 60000);
		com.app.Employee employee = new com.app.Employee(100, "Anil", 60000, "abcd", new com.app.Address("Mumbai", "MAH"));
		
		
		try (FileOutputStream fileOutputStream = new FileOutputStream("employee.dat");
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
			
			objectOutputStream.writeObject(employee);
			System.out.println("Employee saved");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	private static void readExternalize() {
		
		try (FileInputStream fileInputStream = new FileInputStream("employee.dat");
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
			com.app.Employee employee = (com.app.Employee) objectInputStream.readObject();
			employee.print();
			
		} catch (ClassNotFoundException | IOException e) {
			
			e.printStackTrace();
		}
			
		
	}

}
