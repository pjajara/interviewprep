package edu.sjsu.java.arrayops;

import java.util.*;

public class ArrayOperations {

    public static void main(String[] args) {
//        int[] arr = {1, 23, 2, 4, 5, 3, 2, 3, 1, 90, 98, 97, 99, 65, 76, 67,
//                87};
//        int[] arr2 = {2, 3, 5, 3, 1, 0, 6, -1, -3};
//        int[] temp = {1, 1, 2, 3, 4, 7, 8, 9};
//
//        rotateR(new int[]{1, 2, 3, 4, 5, 6}, 2);
//        rotateL(new int[]{1, 2, 3, 4, 5, 6}, 2);
//
//        int[] s = {1, 2, 1, 8, 10};
//        // subarrayWithSumK(s, 11);
//        //printPairsWithSumK(temp, 3);
//        //System.out.println(longestConsecutive(temp));
//        int[] arr3 = {0, 0, 1, 2, 0, 0, 11, 1, 2, 3, 0, 4, 0, 1, 0, 0, 11, 66, 0};

        /* System.out.println(longestSeries(temp));*/

//		int[] arr5 = {1,2,3,4,5,6,7,8,9,10};
//		findMissingNumber(arr5);

		/*int[] arr4 = { 2, 3, 4, 6, 7, 12, 13, 15, 5, 17, 14, 22 };
        pythagoreanTrips(arr4);*/


        //System.out.println(fibonacci(1));

		/*String s = "a2b1c1d1e4f0g11 ";
        char[] arr4 = s.toCharArray();
		  expand(arr4);*/

        //System.out.println(getMinDifference(arr2));

		/*for (int i: arr3){
            System.out.print( " " +i);
		}*/

        //int[] minMax = getMinMax(arr);
        //System.out.println(minMax[0] + " " + minMax[1]);

		/*
         * ArrayOperations.evenOnLeftSide(arr);
		 * 
		 * for (int i : arr) { System.out.println(i); }
		 * 
		 * System.out.println("___________________________________________________"
		 * ); ArrayOperations.OddOnLeftSide(arr);
		 * 
		 * for (int i : arr) { System.out.println(i); }
		 * 
		 * insertZeros(arr);
		 * 
		 * for (int i : arr) { System.out.println(i); }
		 */
        // moveZerosToRight1(arr3);

//        for (int i : arr3) {
//            System.out.print(" " + i);
//        }

        // Integer result[] = removeDuplicates(new Integer[]{1,1,1,2,2,3, 4,5,5});

        List<Integer> result = removeDuplicates0(new int[]{1, 1, 1, 2, 2, 3, 4, 5, 5});

        System.out.println(result);

    }

    // Recommended method for Kadane's algorithm
    public static void evenOnLeftSide(int array[]) {
        int i = 0;
        int j = array.length - 1;

        while (j > i) {
            if (array[i] % 2 == 0)
                ++i;
            if (array[j] % 2 == 1)
                --j;
            if (array[i] % 2 == 1 && array[j] % 2 == 0) {
                swap(array, i, j);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    // Move odd integers to left side
    public static void OddOnLeftSide(int array[]) {

        int i = 0;
        int j = array.length - 1;

        while (true) {
            if (array[i] % 2 == 1)
                ++i;
            if (array[j] % 2 == 0)
                --j;
            if (i > j)
                break;
            if (array[i] % 2 == 0 && array[j] % 2 == 1) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }

    public static void insertZeros(int[] arr) {
        if (arr == null)
            return;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    //Find pairs in array with sum K
    //{2,5,3,1,4} K=5
    public static void printPairsWithSumK(int[] arr, int k) {

        Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {

            if (pairs.containsKey(arr[i]))
                System.out.println(arr[i] + ", " + pairs.get(arr[i]));
            else
                pairs.put(k - arr[i], arr[i]);
        }

    }

    //Move zeros to the right
    public static void moveZerosToRight0(int[] arr) {
        if (arr == null) {
            return;
        }
        int begin = 0;
        int end = arr.length - 1;

        while (begin < end) {
            if (arr[begin] == 0 && arr[end] != 0) {
                int temp = arr[begin];
                arr[begin] = arr[end];
                arr[end] = temp;
                begin++;
                end--;
            } else {
                if (arr[begin] != 0)
                    begin++;

                if (arr[end] == 0)
                    end--;
            }
        }
    }

    public static int[] getMinMax(int[] arr) {
        if (arr == null) {
            return arr;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i : arr) {
            if (i < min) min = i;
            if (i > max) max = i;
        }
        return new int[]{min, max};
    }

    public static int getMinDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }
        return minDiff;
    }

    private static void expand(char[] arr) {
        expand(arr, 0, 0);
    }

    private static void expand(char[] arr, int startReading, int startWriting) {
        char ch = arr[startReading++];
        if (ch == ' ')
            return;
        int count = 0;
        while (Character.isDigit(arr[startReading])) {
            count = count * 10 + arr[startReading] - 48;
            startReading++;
        }
        expand(arr, startReading, startWriting + count);
        for (int i = 0; i < count; ++i)
            arr[startWriting + i] = ch;
    }

    private static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static void pythagoreanTrips(int[] arr) {
        if (arr == null) {
            return;
        }
        Set<Integer> sqrs = new HashSet<Integer>();
        for (int i : arr) {
            sqrs.add(i * i);
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sqrSum = (arr[i] * arr[i]) + (arr[j] * arr[j]);
                if (sqrs.contains(sqrSum)) {
                    System.out.println(arr[i] + " " + arr[j] + " "
                            + (int) Math.sqrt(sqrSum));
                }
            }
        }
    }

    private static void findMissingNumber(int[] arr) {
        if (arr == null) {
            return;
        }
        int sum = 0;
        int actualSum = 0;
        for (int i : arr) {
            sum += i;
        }
        int n = arr.length;
        actualSum = ((n * (n - 1) / 2));
        System.out.println(actualSum - sum);
    }

    public static int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < num.length; i++) {
            set.add(num[i]);
        }
        int longest = 0;
        for (int i = 0; i < num.length; i++) {
            int low = num[i] - 1;
            int high = num[i] + 1;
            if (!set.contains(num[i])) {
                continue;
            }
            while (set.contains(low)) {
                set.remove(low);
                low--;
            }
            while (set.contains(high)) {
                set.remove(high);
                high++;
            }
            if (longest < high - (low + 1)) {
                longest = high - (low + 1);
            }
        }
        return longest;
    }


    public static int longestSeries(int[] arr) {

        Set<Integer> set = new HashSet<Integer>();

        for (int i : arr) {
            set.add(i);
        }

        int longest = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                continue;
            }

            int low = arr[i] - 1;
            int high = arr[i] + 1;

            while (set.contains(low)) {
                set.remove(low);
                low--;
            }

            while (set.contains(high)) {
                set.remove(high);
                high++;
            }

            if (longest < (high - low) + 1)
                longest = (high - low) + 1;
        }
        return longest;
    }


    public static void rotateR(int[] arr, int k) {
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
    }

    public static void rotateL(int[] arr, int k) {
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, arr.length - 1 - k);
        reverse(arr, arr.length - k, arr.length - 1);
    }

    public static void reverse(int[] arr, int begin, int end) {
        while (end > begin) {
            int tmp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = tmp;
            begin++;
            end--;
        }
    }


    public static int subarrayWithSumK(int arr[], int k) {
        int curr_sum = arr[0], start = 0;
        int len = arr.length;

        for (int i = 1; i < len; ++i) {
            //{1,2,6,-6,4,7}
            while (curr_sum > k && start < i) {
                curr_sum = curr_sum - arr[start++];
            }

            if (curr_sum == k) {
                System.out.println("Sum found between indexes" + start + " "
                        + (i - 1));
                return 1;
            }

            //if (i < len)
            curr_sum = curr_sum + arr[i];
        }

        // If we reach here, then no subarray
        System.out.println("No subarray found");
        return 0;
    }

    public static void moveZerosToRight1(int[] array) {

        if (array == null || array.length == 1) {
            return;
        }

        int index = 0;

        for (int i = 0; i < array.length; i++) {

            if (array[i] != 0) {
                array[index++] = array[i];
            }
        }

        while (index < array.length) {
            array[index++] = 0;
        }
    }

    // 287. Find the Duplicate Number
    public int findDuplicateInteger(final int[] array) {

        if (array.length > 1) {
            int slow = array[0];
            int fast = array[array[0]];
            while (slow != fast) {
                slow = array[slow];
                fast = array[array[fast]];
            }

            fast = 0;
            while (fast != slow) {
                fast = array[fast];
                slow = array[slow];
            }
            return slow;
        }
        return -1;

    }

    public static Integer[] removeDuplicates(Integer[] array) {

        if (array == null || array.length <= 1) {
            return array;

        }
        Integer[] result = new Integer[array.length];
        Integer previous = array[0];
        Integer index = 0;
        result[index++] = previous;
        /**  O(n) O(n)*/
        for (int i = 0; i < array.length; i++) {

            if (array[i] == previous) {
                continue;
            } else {
                previous = array[i]; //2
                result[index++] = array[i];
            }
        }
        return result;

    }

    // Remove duplicates and return array
    public static List<Integer> removeDuplicates0(final int[] nums) {

        List<Integer> result = new ArrayList<>();

        if (nums == null || nums.length < 2) {
            return Arrays.asList(nums[0]);
        }

        result.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                result.add(nums[i]);
            }
        }

        return result;
    }

}
