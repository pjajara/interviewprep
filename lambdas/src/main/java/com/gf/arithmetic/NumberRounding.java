package com.gf.arithmetic;

/**
 * Created by pjajara on 2/28/17.
 */
public class NumberRounding {

    public static void main(String[] args) {
        System.out.println(roundSum(10, 10, 19));
    }

    public static int roundSum(int a, int b, int c) {
        int a1 = round10(a);
        int b1 = round10(b);
        int c1 = round10(c);

        return a1 + b1 + c1;
    }

    public static int round10(int num) {

        final int originalNum = num;
        num = num % 10;

        if (num == 0) {
            return originalNum;
        } else if (num < 5 && num > 0) {
            return originalNum - num;
        } else if (num >= 5 && num < 10) {
            return originalNum - num + 10;
        }

        return originalNum;
    }
}
