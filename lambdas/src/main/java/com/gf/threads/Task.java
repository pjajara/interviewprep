package com.gf.threads;

/**
 * Created by pjajara on 2/13/17.
 */
public final class Task implements Runnable {

    private int id;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task ID: " + this.id);
    }

}
