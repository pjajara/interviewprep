package com.gf.nestedclasses;

/**
 * Created by pjajara on 2/20/17.
 */
public final class TestMethodLocalInnerClass {

    public static void main(String[] args) {

        class Greeter implements Runnable {

            private final String greeted;

            public Greeter(String greeted) {
                super();
                this.greeted = greeted;
            }

            public void run() {
                System.out.printf("Hello %s!\n", greeted);
            }
        }

        new Greeter("world").run();
        new Greeter("dog").run();
    }
}