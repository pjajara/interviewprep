package edu.sjsu.java.todelete;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Delete1 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 3, 2, 5, 71, 4, 2};

        StringBuilder sb = new StringBuilder();

		/*evenOnLeft(arr);

		for (int i: arr){
			System.out.print(i);
		}*/
        //System.out.println(minMax(arr)[0]);
        printPythagoreanTriplets(arr);
        //pythagoreanTriplets(arr);

        // String reversed = reverse("abcdefgh");
        // System.out.println(reversed);
    }

    public static void evenOnLeft(int[] arr) {
        if (arr == null) {
            return;
        }
        int begin = 0;
        int end = arr.length - 1;

        while (end > begin) {
            while (arr[begin] % 2 == 0) {
                begin++;
            }
            while (arr[end] % 2 != 0) {
                end--;
            }
            if (arr[begin] % 2 != 0 && arr[end] % 2 == 0) {
                int temp = arr[begin];
                arr[begin] = arr[end];
                arr[end] = temp;
                begin++;
                end--;
            }
        }
    }

    public static int[] minMax(int[] arr) {
        if (arr == null) {
            return null;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i : arr) {
            if (i < min) min = i;
            if (i > max) max = i;
        }
        return new int[]{min, max};
    }

    public static void pythagoreanTriplets(int[] arr){

        if (arr == null){
            return;
        }

        if (arr.length < 3){
            return;
        }

        Set<Integer> squares = Arrays.stream(arr).mapToObj(i -> i * i).collect(Collectors.toSet());

        for (int i=0; i<arr.length; i++){

            for (int j=i+1; j<arr.length; j++){

                int squareSum = (arr[i] * arr[i]) + (arr[j] * arr[j]);
                if(squares.contains(squareSum)){
                    System.out.println("Pythagorean Triplet: " + arr[i] + " , " + arr[j] + " , " + (int) Math.sqrt
                            (squareSum));
                }
            }
        }
    }

    public static void printPythagoreanTriplets(int[] arr) {

        if (arr == null) {
            return;
        }

        if (arr.length < 3) {
            return;
        }
        Set<Integer> squares = Arrays.stream(arr).mapToObj(i -> i * i).collect(Collectors.toSet());

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {
                int sqrSum = (arr[i] * arr[i]) + (arr[j] * arr[j]);

                if (squares.contains(sqrSum)) {
                    System.out.println("Triplets: " + arr[i] + " " + arr[j]
                            + " " + (int) Math.sqrt(sqrSum));
                }

            }
        }

    }

    public static String reverse(String str) {

        if (str == null) {
            return null;
        }

        int i = 0;
        int j = str.length() - 1;
        char[] ch = str.toCharArray();
        while (j > i) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
        return new String(ch);
    }

    public static String reverseString(String str) {

        if (str == null) {
            return null;
        }

        if (str.length() <= 1) {
            return str;
        }

        char[] chArray = str.toCharArray();
        int begin = 0;
        int end = chArray.length - 1;
        char temp;

        while (end > begin) {
            temp = chArray[end];
            chArray[end] = chArray[begin];
            chArray[begin] = temp;
            end--;
            begin++;
        }
        return new String(chArray);
    }

    public String reverseUsingSB(String str) {

        if (str == null) {
            return null;
        }

        if (str.length() == 1) {
            return str;
        }

        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

}
