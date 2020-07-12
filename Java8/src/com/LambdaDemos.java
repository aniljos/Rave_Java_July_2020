package com;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;





//class MyFileFilter implements FileFilter{
//	
//	@Override
//	public boolean accept(File pathname) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//}

public class LambdaDemos {

	public static void main(String[] args) {

		//example1();
		example2();
		example3();

	}

	private static void example3() {
		
		List<Integer> numbers = Arrays.asList(1,2,3,3,4,5,6,7,8,9);
		
		//External iterator
		
		/*
		 * for (int i = 0; i < numbers.size(); i++) {
		 * System.out.println(numbers.get(i));
		 * 
		 * }
		 * 
		 * for (int i : numbers) { System.out.println(i); }
		 */
		 
		
		//Internal iterator
		numbers.forEach(i -> {System.out.println(i);});
		
	}

	private static void example2() {
		
		File file = new File("C:\\ELK");
		//File[] files = file.listFiles((File f) -> {return f.isDirectory();});
		
		File[] files = file.listFiles(f -> f.isDirectory());
		for (File selectedfile : files) {
			System.out.println(selectedfile.getName());
		}
		System.out.println("-----------------------");
		files = file.listFiles(f -> !f.isDirectory());
		for (File selectedfile : files) {
			System.out.println(selectedfile.getName());
		}
		
	}

//	private static void example1() {
//
//		File file = new File("C:\\ELK");
//		File[] files = file.listFiles(new FileFilter() {
//
//			@Override
//			public boolean accept(File f) {
//
//				return f.isDirectory();
//			}
//		});
//		for (File selectedfile : files) {
//			System.out.println(selectedfile.getName());
//		}
//
//		files = file.listFiles(new FileFilter() {
//
//			@Override
//			public boolean accept(File f) {
//
//				return !f.isDirectory();
//			}
//		});
//		System.out.println("-----------------------");
//		for (File selectedfile : files) {
//			System.out.println(selectedfile.getName());
//		}
//
//	}

}
