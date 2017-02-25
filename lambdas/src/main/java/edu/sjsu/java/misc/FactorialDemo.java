package edu.sjsu.java.misc;

public class FactorialDemo {

    public static void main(String[] args) {
        System.out.println(fact(100));
    }

    public static int fact(int i) {
        if (i == 1) {
            return 1;
        } else {
            return i * fact(i - 1);
        }
    }

}
