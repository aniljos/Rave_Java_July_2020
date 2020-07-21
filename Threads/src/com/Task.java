package com;

public class Task implements Runnable{

	private int taskId;
	
	public Task(int taskId) {
		this.taskId = taskId;
	}
	
	
	@Override
	public void run() {
		
		System.out.println(String.format("Task Id: %d started by thread %s", taskId, Thread.currentThread().getName()));
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		System.out.println(String.format("Task Id: %d ended by thread %s", taskId, Thread.currentThread().getName()));
	
	}
	
	

}
