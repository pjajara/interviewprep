package edu.sjsu.java.misc;

import java.util.Map;

public class FibonacciDemo {

    public static void main(String[] args) {

        System.out.println(fibonacci0(20).length);
        Map m;
    }

    public static int fibonacci(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int[] fibonacci0(int n) {
        if (n == 1) {
            return new int[]{0};
        } else if (n == 2) {
            return new int[]{1};
        } else
            return fibonacci0(n - 1);
    }

    // [fibo(1), fibo(2), fibo(3), fibo(4),...]

}
