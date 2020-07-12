package com;

@FunctionalInterface
public interface Simple {

	public void task();
	
	
	public default void executeTask() {
		System.out.println("Starting simple exec task");
		task();
		System.out.println("Ending simple exec task");
	}
	
	public static void buildAllTasks() {
		
		System.out.println("Simple.buildAllTasks()");
	}
	
}
