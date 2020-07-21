package com;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {

	public static void main(String[] args) {
		
		
		//BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(25);
		BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 15, 60, TimeUnit.SECONDS, workQueue);
		
		for (int i = 0; i < 100; i++) {
			
//			
//			threadPoolExecutor.execute(() -> {
//				System.out.println("Executing task: " + Thread.currentThread().getName());
//			});
			
			threadPoolExecutor.execute(new Task(i));
		}
		
		threadPoolExecutor.shutdown();
		
		
		try {
			threadPoolExecutor.awaitTermination(3, TimeUnit.MINUTES);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("ExecutorDemo.main() completed");
		

	}

}
