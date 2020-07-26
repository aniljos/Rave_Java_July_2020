package com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;


class SumTask extends RecursiveTask<Integer>{

	List<Integer> numbers;
	int fractionSize;
	
	public SumTask(List<Integer> numbers, int fractionSize) {
		
		this.numbers = numbers;
		this.fractionSize = fractionSize;
		
		//System.out.println("SumTask" + numbers);
	}

	@Override
	protected Integer compute() {
		
		//System.out.println("Executed by: " + Thread.currentThread().getName());
		int size = numbers.size();
		
		if(size > fractionSize) {
			//forking
			
			SumTask left = new SumTask(numbers.subList(0, size/2), fractionSize);
			SumTask right = new SumTask(numbers.subList(size/2, size), fractionSize);
			left.fork();
			right.fork();
			
			int result = left.join() + right.join();
			return result;
			
		}
		else {
			
			
			return numbers.stream().mapToInt(i -> i).sum();
		}
		
		
		
	}
}
public class ForkAndJoinDemo {
	
	static List<Integer> numbers = new ArrayList<Integer>();
	
	private static void loadData() {
		for (int i = 1; i <= 80; i++) {
			numbers.add(i);
		}
	}

	private static  int sum() {
		
		int sum = 0;
		for (Integer number : numbers) {
			sum += number;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		//System.out.println("ForkAndJoinDemo.main()");
		loadData();
		System.out.println("Sum: " + sum() );
		
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		int processors = Runtime.getRuntime().availableProcessors();
		
		
		System.out.println("Processor count: " + processors);
		int fractionSize = numbers.size() / processors;
		int result = forkJoinPool.invoke(new SumTask(numbers, fractionSize));
		System.out.println("Sum from fork & join: " + result);
		
		
		int sum = numbers.parallelStream().mapToInt(i -> {
			
			System.out.println("Parallel Executed by: " + Thread.currentThread().getName());
			return i;
		}).sum();
		System.out.println("Sum from parralel: " + sum);
		
		
	}

}




