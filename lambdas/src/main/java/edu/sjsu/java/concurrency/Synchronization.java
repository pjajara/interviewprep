package edu.sjsu.java.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class Synchronization extends Thread {

    public static void main(String[] args) {
    }

    public void foo() {
        Thread t = new Synchronization();
        t.start();
    }


    public static int increment() {
        AtomicInteger i = new AtomicInteger(4);
        return i.incrementAndGet();
    }

    public static synchronized void m1() {
    }

    public synchronized static void m2() {
    }

    public static void m3() {
        synchronized (Synchronization.class) {
            //do something here
        }
    }

    public void m4() {
        synchronized (this) {
            //do something here
        }
    }

}
