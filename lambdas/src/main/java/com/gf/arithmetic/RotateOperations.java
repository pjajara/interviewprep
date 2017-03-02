package com.gf.arithmetic;

/**
 * Created by pjajara on 2/26/17.
 */
public class RotateOperations {

    public static int[] rotate(final int[] array, final int rIndex) {
        if (array == null || array.length <= 1) {
            return new int[0];
        }

        final int[] result = new int[array.length];
        final int arrayLength = array.length;

        for (int i = 0; i < arrayLength; i++) {
            int nIndex = (i + rIndex) % arrayLength;
            result[nIndex] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] testArray = {1, 2, 3, 4, 5, 6, 0, 0,0};
        int[] result = rotate(testArray, 3);

        for (int r: result){
            System.out.print(" " + r);
        }
    }
}
