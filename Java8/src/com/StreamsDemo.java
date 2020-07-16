package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsDemo {

	public static void main(String[] args) {

		// imperative();
		// functional();
		
	}

	

	private static void functional() {

		// 1 lakh
		List<Integer> numbers = Arrays.asList(2, 7, 9, 11, 4, 19, 13, 17, 8, 6, 10, 13);

		// Intermediate operations
		// find all numbers above 9
		// find the sqaures of all numbers

		// Terminal operation
		// return a new collection

		List<Integer> results = numbers
				// .stream()
				.parallelStream().filter(n -> n > 9).map(n -> n * n).collect(Collectors.toList());

		results.forEach(System.out::println);

	}

	private static void imperative() {

		List<Integer> numbers = Arrays.asList(2, 7, 9, 11, 4, 19, 13, 17, 8, 6, 10, 13);

		// find all numbers above 9
		// find the sqaures of all numbers
		// return a new collection

		List<Integer> results = new ArrayList<Integer>();
		for (Integer value : numbers) {

			if (value > 9) {
				int sqaure = value * value;
				results.add(sqaure);
			}
		}
		results.forEach(System.out::println);

	}

}
