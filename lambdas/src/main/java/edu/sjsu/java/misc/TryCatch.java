package edu.sjsu.java.misc;


public class TryCatch {

    //without exception: A 1 3 Y B
    //with exception:A 1 2 3 X B
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("A");
            System.out.println(hello());
            System.out.println("B");

        } catch (Exception e) {

            System.out.println("C");
        }
    }

    public static String hello() throws Exception {
        try {
            System.out.println("1");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("2");
            return "X";
        } finally {
            System.out.println("3");
        }
        //return "Y";
    }
}