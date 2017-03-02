package com.gf.arithmetic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pjajara on 2/25/17.
 */
public class AddTwoNumbersJava {

    public static void main(String args[]) {

        List<int[]> list;
        Map m;

//        System.out.println(" Sum of 110 addR 200 is : " + addR(110, 200));
//        System.out.println(" Sum of 0 and 0 is : " + addR(0, 0));
//        System.out.println(" Sum of -10 and +10 is : " + addR(-10, 10));
//        System.out.println(" Sum of -10 + 200 is : " + addR(-10, 200));
//        System.out.println(" Sum of 0 + 200 is : " + addR(0, 200));

        // System.out.println(" Sum of 0 + 200 is : " + addR(2, 3));

        int[] A = {-1, 66, 7};
        int[] B = {1, 8,6};
        int[] C = {0, 4, 3};
        int[] D = {0, 8,9};
        System.out.println(fourSumCount(A, B, C, D));
    }


    // Recursive solution
    public static int addR(int x, int y) {

        if (y == 0) return x;
        int sum = x ^ y; //SUM of two integer is X XOR Y
        int carry = (x & y) << 1;  //CARRY of two integer is X AND Y
        return addR(sum, carry);
    }

    //Iterative solution
    public static int addI(int x, int y) {

        while (y != 0) {
            int carry = (x & y); //CARRY is AND of two bits
            x = x ^ y; //SUM of two bits is X XOR Y
            y = carry << 1; //shifts carry to 1 bit to calculate sum
        }
        return x;
    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<C.length; i++) {
            for(int j=0; j<D.length; j++) {
                int sum = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res=0;
        for(int i=0; i<A.length; i++) {
            for(int j=0; j<B.length; j++) {
                res += map.getOrDefault(-1 * (A[i]+B[j]), 0);
            }
        }

        return res;
    }


}
