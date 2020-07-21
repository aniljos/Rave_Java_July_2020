package com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {

	public static void main(String[] args) {
		
		//ExecutorService executorService = Executors.newCachedThreadPool();
		ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable runnable) {
				
				System.out.println("ExecutorServiceDemo.main(...).new ThreadFactory() {...}.newThread()");
				Thread thread = new Thread(runnable);
				thread.setPriority(10);
				return thread;
			}
		});
		
		
		
		//ExecutorService executorService = Executors.newFixedThreadPool(3);

		//ExecutorService executorService = Executors.newSingleThreadExecutor();
		//ExecutorService executorService = Executors.newWorkStealingPool();
		
		for (int i = 0; i < 10; i++) {
			executorService.execute(new Task(i));
		}

		
		executorService.shutdown();
		
		try {
			executorService.awaitTermination(5, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("ExecutorServiceDemo.main() completed");
	}

}
