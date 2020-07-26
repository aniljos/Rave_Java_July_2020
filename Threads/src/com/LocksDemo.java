package com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LocksDemo implements Runnable {

	private Counter counter = new Counter();
	
	@Override
	public void run() {
		
		
		System.out.println("Run executed by thread: " + Thread.currentThread().getName());
		for (int i = 0; i < 5; i++) {
			
			counter.increment();
		}
		
	}
	
	
	public static void main(String[] args) {
		
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		LocksDemo locksDemo = new LocksDemo();
		executorService.execute(locksDemo);
		executorService.execute(locksDemo);
		
		executorService.shutdown();
		
		
		try {
			executorService.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("LocksDemo.main() completed count: " + locksDemo.counter.count);

	}

	

}
