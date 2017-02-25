package edu.sjsu.java.singleton;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestDeviceDriver {
	
	private Lock lock;
	
	public TestDeviceDriver(){
		lock = new ReentrantLock();
	}

	public static void main(String[] args) {
		System.out.println(DeviceDriver.getInstance());
	}

	public void DemoLock(){
		lock.lock();
		System.out.println();
		lock.unlock();
	}
}
	