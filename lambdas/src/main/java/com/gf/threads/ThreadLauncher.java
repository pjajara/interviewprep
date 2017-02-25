package com.gf.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by pjajara on 2/13/17.
 */
public class ThreadLauncher {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 1; i < 11; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            service.submit(new Task(i));
        }

        new Thread() {
            public void run() {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    System.out.println("Exception message: " + e.getMessage());
                    System.out.println("Exception cause: " + e.getCause());
                }
            }
        }.start();
    }
}
