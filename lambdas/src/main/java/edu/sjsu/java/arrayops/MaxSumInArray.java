package edu.sjsu.java.arrayops;

public class MaxSumInArray {
	String dirty;
	public static void main(String[] args) {
		//printMaxSum(new int[]{-1, 3, -5, 4, 6, -1, 2, -7, 13, -3});
		printMaxSum(new int[]{-1, -1,-1,-1,-1,-1,-1});
		printMaxSum(null);
	}
	
	public static void printMaxSum(int[] array){
		if(array == null){
			return;
		}
		int beginIndex=0;
		int endIndex=0;
		int cumulativeSum = 0;
		int maxSum = Integer.MIN_VALUE;
		int currentMaxBeginIndex=0;
		
		for (int i=0; i<array.length;i++){
			cumulativeSum += array[i];
			
			if(cumulativeSum > maxSum){
				maxSum = cumulativeSum;
				beginIndex = currentMaxBeginIndex;
				endIndex = i;
			}
			else if(cumulativeSum < 0){
				cumulativeSum = 0;
				currentMaxBeginIndex = i+1;
			}
		}
		System.out.println(maxSum);
		System.out.println(beginIndex);
		System.out.println(endIndex);
	}

}
