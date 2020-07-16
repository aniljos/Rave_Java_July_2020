package com;

public class MainThread {

	public static void main(String[] args) {
		
		printThreadInfo();
		
	}

	public static void printThreadInfo() {
		
		System.out.println("-----------------------------");
		System.out.println("Thread ID: " + Thread.currentThread().getId());
		System.out.println("Name: " + Thread.currentThread().getName());
		System.out.println("Priority: " + Thread.currentThread().getPriority());
		System.out.println("Group: " + Thread.currentThread().getThreadGroup());
		System.out.println("State: " + Thread.currentThread().getState().name());
		System.out.println("Is Daemon Thread: " + Thread.currentThread().isDaemon()); // Background thread
		System.out.println("-----------------------------");
	}

}
