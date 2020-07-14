package com;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

		// example1();
		// example2();
		// example3();
		// example4();
		// example5();

		// methods refs
		example6();
	}

	private static void print(int x) {
		System.out.println("Printing " + x);
	}

	private static int add(int x, int y) {
		System.out.println("LambdaDemos.add()");
		return x + y;
	}

	private int multiply(int x, int y) {
		System.out.println("LambdaDemos.multiply()");
		return x * y;
	}

	private static void example6() {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		// numbers.forEach(i -> System.out.println(i));

		// numbers.forEach(i -> print(i));
		numbers.forEach(LambdaDemos::print);

		// Calculator calculator = (x, y) -> x + y;
		Calculator calculator = LambdaDemos::add;
		System.out.println("Result: " + calculator.calculate(4, 8));
		
		LambdaDemos obj = new LambdaDemos();
		calculator = obj::multiply;
		System.out.println("Result: " + calculator.calculate(4, 8));
		
		System.out.println("----------------");
		numbers.forEach(System.out::println);
	}

	private static void example5() {

		GenericCalculator<Integer, Double, Double> calculator = (x, y) -> x + y;
		System.out.println("Result: " + calculator.calculate(4, 8.8));

		GenericCalculator<Float, Float, Float> calculator1 = (x, y) -> x + y;
		System.out.println("Result: " + calculator1.calculate(3.1f, 1.8f));

	}

	private static void example4() {

		Calculator calculator = (int x, int y) -> x + y;
		System.out.println("Result: " + calculator.calculate(4, 8));
		calculator = (x, y) -> x * y;
		System.out.println("Result: " + calculator.calculate(4, 8));

		calculator = (x, y) -> {

			System.out.println("Calculating on " + x + ", " + y);
			return x - y;
		};
		System.out.println("Result: " + calculator.calculate(4, 8));

	}

	private static void example3() {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 4, 5, 6, 7, 8, 9);

		// External iterator

		/*
		 * for (int i = 0; i < numbers.size(); i++) {
		 * System.out.println(numbers.get(i));
		 * 
		 * }
		 * 
		 * for (int i : numbers) { System.out.println(i); }
		 */

		// Internal iterator
		numbers.forEach(i -> {
			System.out.println(i);
		});

	}

	private static void example2() {

		File file = new File("C:\\ELK");
		// File[] files = file.listFiles((File f) -> {return f.isDirectory();});

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

	private static void example1() {

		File file = new File("C:\\ELK");
		File[] files = file.listFiles(new FileFilter() {

			@Override
			public boolean accept(File f) {

				return f.isDirectory();
			}
		});
		for (File selectedfile : files) {
			System.out.println(selectedfile.getName());
		}

		files = file.listFiles(new FileFilter() {

			@Override
			public boolean accept(File f) {

				return !f.isDirectory();
			}
		});
		System.out.println("-----------------------");
		for (File selectedfile : files) {
			System.out.println(selectedfile.getName());
		}

	}

}
