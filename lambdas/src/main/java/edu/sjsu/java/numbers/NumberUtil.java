package edu.sjsu.java.numbers;

/**
 * Created by pjajara on 2/19/17.
 */
public final class NumberUtil {

    public static void main(String[] args) {

        // System.out.println(isNumber("a1234"));

        System.out.println(reverseInt(-12345));

    }

    //Takes a String as input
    // abc
    public static boolean isNumber0(String input) {

        if (input == null || input.equals("")) {
            return false;
        }

        boolean flag = true;

        for (int i = 0; i < input.length() - 1; i++) {

            if (Character.isLetter(input.charAt(i))) {
                return false;
            } else {
                continue;
            }
        }
        return flag;
    }

    //O(n)
    public static boolean isNumber(String input) {

        if (input == null || input == "") {
            return false;
        }

        int i = 0;
        int n = input.length();
        boolean flag = false;

        while (i < n && Character.isWhitespace(input.charAt(i))) {
            i++;
        }

        if (i < n && (input.charAt(i) == '+' || input.charAt(i) == '-')) {
            i++;
        }

        while (i < n && Character.isDigit(input.charAt(i))) {
            i++;
            flag = true;
        }

        if (i < n && input.charAt(i) == '.') {
            i++;

            while (i < n && Character.isDigit(input.charAt(i))) {
                i++;
                flag = true;
            }
        }

        while (i < n && Character.isWhitespace(input.charAt(i))) {
            i++;
        }

        return flag && i == n;
    }

    //Leetcode Implementation
    public static int reverseInt(int x) {
        int result = 0;

        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
            return result;
        }
        while (x != 0) {
            result = (result * 10) + (x % 10);
            x = x / 10;
        }
        return result;
    }

    public static int reverseInt1(int num) {

        int result = 0;

        if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE){
            return result;
        }

        while (num != 0) {
            result = result * 10 + num % 10;
            num = num / 10;
        }
        return result;
    }

    public int reverse(int num) {
        assert num >= 0; // for non-negative integers only.
        int rev = 0;
        while (num != 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }

}
