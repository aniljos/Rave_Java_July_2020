package com;

public class Counter {

	int count;
	
	private Object mutex = new Object();

//	public synchronized int getCount() {
//		return count;
//	}
//
//	public synchronized void setCount(int count) {
//		this.count = count;
//	}

	public void increment() {

		// this.count++;
		
		synchronized (mutex) {

			System.out.println(String.format("Thread %s read count as %d", Thread.currentThread().getName(), this.count));
			int temp = this.count;
			temp++;

			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

			this.count = temp;
			
			if(this.count == 3) {
				System.err.println(String.format("Thread %s going into wait mode", Thread.currentThread().getName()));
				try {
					mutex.wait();
					System.err.println(String.format("Thread %s exiting into wait mode", Thread.currentThread().getName()));
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			
			if(this.count == 7) {
				System.err.println(String.format("Thread %s calls notify", Thread.currentThread().getName()));
				mutex.notify();
			}
			
			System.out.println(String.format("Thread %s updates count as %d", Thread.currentThread().getName(), this.count));
		}
		
	}

	public void decrement() {

		System.out.println("Counter.decrement()");
		synchronized (mutex) {
			this.count--;
		}
		
	}

}
