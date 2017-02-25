package edu.sjsu.java.string;

public class IntegerUtils {
	
	public static int getMaxSum(int[] arr) {
		int max_sum = 0, i, v = 0;
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;

		for (i = 0; i < arr.length; i++) {
			v = v + arr[i];

			if (v > max_sum) {
				max_sum = v;
			}
			else if (v<0) v=0;
		}
		return max_sum;
	}
	
	public static void main(String args[]){
		int[] arr = {-66,-2,-34,-1,100,1,34,2,66,76,-76};
		int max_sum = getMaxSum(arr);
		System.out.println(max_sum);
	}

}
