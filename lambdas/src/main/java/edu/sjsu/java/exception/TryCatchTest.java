package edu.sjsu.java.exception;

class TryCatchTest {

    public static void main(String args[]) throws Exception {
        TryCatchTest.test();
        System.out.println("I am still here!");
    }

    public static void test() throws Exception {
        try {
            // System.exit(1); // Thread is killed here
            return;
        } finally {
            System.out.println("This");
            System.out.println("Statement");
            System.out.println("Should execute without any issue!");
            throw new Exception();
        }
    }
}