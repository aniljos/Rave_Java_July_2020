package com;


class TestThread implements Runnable{

	@Override
	public void run() {
		
		MainThread.printThreadInfo();
		for (int i = 0; i < 400; i++) {
			System.out.println("In runnable" + i);
		}
		System.out.println("Runnable over");
	}
}

public class DemoThread extends Thread {
	
	@Override
	public void run() {
	
		MainThread.printThreadInfo();
		for (int i = 0; i < 200; i++) {
			System.out.println("In demo thread" + i);
		}
		System.out.println("Demo thread over");
	}

	public static void main(String[] args) {
		
		MainThread.printThreadInfo();
		
		DemoThread demoThread = new DemoThread();
		demoThread.setName("DemoThread");
		demoThread.setPriority(MAX_PRIORITY);
		//demoThread.run();
		
		demoThread.start();
		
		TestThread runnable= new TestThread();
		Thread testThread = new Thread(runnable);
		testThread.setDaemon(true);
		testThread.start();
		
		System.out.println("Main over");
	}

}





