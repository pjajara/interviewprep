package edu.sjsu.java.exception;

class TryCatchTest {

    public static void main(String args[]) {
        TryCatchTest.test();
    }

    public static void test() {
        try {
            // System.exit(1); // Thread is killed here
            return;
        } finally {
            System.out.println("This");
            System.out.println("Statement");
            System.out.println("Should execute without any issue!");
        }
    }
}