package edu.sjsu.java.search;

public class BinarySearch {

    public static int countOccurences(int[] array, int element) {
        int index = search(array, 0, array.length - 1, element);

        if (index == -1) {
            return 0;
        }

        int rightCount = 0;
        int leftCount = 0;
        int length = array.length;
        int j = index, i = index;

        while (--j >= 0) {
            if (array[j] == element) {
                leftCount++;
            } else {
                break;
            }
        }

        while (++i < length) {
            if (array[i] == element) {
                rightCount++;
            } else {
                break;
            }
        }
        return 1 + leftCount + rightCount;
    }

    //Classic Binary Search Algorithm
    public static int search(int[] array, int low, int high, int element) {

        //{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}
        if (high >= low) {
            int mid = (low + high) / 2;
            //int mid = low + ((high - low) / 2);
            // int mid = (low + high) >>> 1;

            if (array[mid] == element) {
                return mid;
            } else if (array[mid] > element) {
                return search(array, low, mid - 1, element);
            } else {
                return search(array, mid + 1, high, element);
            }
        }
        return -1;
    }

    private static int binarySearch0(long[] a, long key) {

        int low = 0;
        int high = a.length;

        while (low <= high) {

            int mid = low + ((high-low)/2);
            long midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }

}
