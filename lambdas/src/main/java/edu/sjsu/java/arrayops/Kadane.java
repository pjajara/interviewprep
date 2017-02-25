package edu.sjsu.java.arrayops;


public class Kadane {

	public static synchronized void main(String[] args) {
		// int[] intArr={3, -1, -1, -1, -1, -1, 2, 0, 0, 0 };
		 int[] intArr = {-1, 3, -5, 4, 6, -1, 2, -7, 13, -3};
		// int[] intArr={-6,-2,-3,-4,-1,-5,-5};
		//int[] intArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 12 };
		findMaxSubArray(intArr);
	}

	public static void findMaxSubArray(int[] arr) {

		int begin = 0;
		int end = 0;
		int maxSum = Integer.MIN_VALUE;
		int cumulativeSum = 0;
		int currentMaxStartIndex = 0;

		for (int i = 0; i < arr.length; i++) {

			cumulativeSum += arr[i];

			if (cumulativeSum > maxSum) {
				maxSum = cumulativeSum;
				begin = currentMaxStartIndex;
				end = i;
			} else if (cumulativeSum <= 0) {
				currentMaxStartIndex = i + 1;
				cumulativeSum = 0;
			}
		}

		System.out.println("Max sum         : " + maxSum);
		System.out.println("Max start index : " + begin);
		System.out.println("Max end index   : " + end);
	}

}
