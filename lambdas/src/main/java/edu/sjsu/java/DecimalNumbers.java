package edu.sjsu.java;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Created by pjajara on 3/7/17.
 */
public  class DecimalNumbers {

    void mymethod(){}

    public static void main(String[] args) {
        //dontUseFloatForMoney();
        BigDecimalDemo();
    }

    public static void dontUseFloatForMoney() {
        double total = 0;

        // do 10 adds of 10 cents
        for (int i = 0; i < 10; i++) {
            total += 0.1;  // adds 10 cents
        }

        System.out.println("round problems?" + "current total: " + total);

        // looks like total equals to 1.0, don't?

        // now, do reverse
        for (int i = 0; i < 10; i++) {
            total -= 0.1;  // removes 10 cents
        }

        // looks like total equals to 0.0, don't?
        System.out.println("round problems?" + "current total: " + total);
        if (total == 0.0) {
            System.out.println("round problems?" + "is total equal to ZERO? YES, of course!!");
        } else {
            System.out.println("round problems?" + "is total equal to ZERO? NO... thats why you should not use Double for " +
                    "some math!!!");
        }
    }

    public static void BigDecimalDemo(){

        BigDecimal num1 = new BigDecimal(0.1, MathContext.DECIMAL32);
        BigDecimal num2 = new BigDecimal(0.1, MathContext.DECIMAL32);

        System.out.println(num1.multiply(num2));
        System.out.println(num2.add(num2));
    }
}
