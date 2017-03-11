package edu.sjsu.java;

/**
 * Created by pjajara on 3/6/17.
 */
//Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
public class MatrixDemo {

    public static void main(String[] args) {

        int[] row1 = {0, 2, 3};
        int[] row2 = {5, 6, 7};
        int[] row3 = {8, 9, 0};
        int[] row4 = {10, 0, 12};

        int[][] matrix = {row1, row2, row3, row4};
        // setZerosInPlace(matrix);
        setZeroes(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
        }
    }

    public static int[][] setZerosInPlace(int[][] twoDArray) {

        if (twoDArray == null) {
            return twoDArray;
        }
        // int[][] zeroMatrix = Arrays.copyOf(twoDArray, new int[0][0]);
//        for (int i = 0; i < zeroMatrix.length; i++) {
//            zeroMatrix[i][]
//        }

        for (int i = 0; i < twoDArray.length; i++) {
            for (int j = 0; j < twoDArray[i].length; j++) {

            }
        }
        return twoDArray;
    }

    public static void setZeroes(int[][] matrix) {

        boolean firstRowZero = false;
        boolean firstColumnZero = false;

        // s e t f i r s t row and column z e r o o r n o t
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColumnZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // mark zeros on first row and column
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //use mark to set elements
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                     matrix[i][j] = 0;
                }
            }
        }

        //set first column and row
        if (firstColumnZero) {
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }

        if (firstRowZero) {
            for (int i = 0; i < matrix[0].length; i++)
                matrix[0][i] = 0;
        }
    }
}
