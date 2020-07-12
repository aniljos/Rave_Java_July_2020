package com;

public interface Complex {

	public void complexTask();
	
	public default void executeTask() {
		System.out.println("Start complex task");
		complexTask();
		System.out.println("End complex Task");
	}
}
