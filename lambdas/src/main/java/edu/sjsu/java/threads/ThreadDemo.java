package edu.sjsu.java.threads;

public class ThreadDemo implements Runnable{

	private static volatile int counter=0;
	
	public ThreadDemo(){
		
	}
	
	public static synchronized void main(String[] args) {
		ThreadDemo t = new ThreadDemo();
		Thread thread = new Thread(t);
		thread.start();
	}

	@Override
	public void run() {
		while (ThreadDemo.counter < 10) {
			try {
				System.out.println(ThreadDemo.counter++);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
