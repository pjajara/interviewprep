package edu.sjsu.java.sorting;

public class InsertionSort {
	
	public static void main(String arg[]){
		int[] arr = {3,4,51,2,99,3,55,2,1,-1};
		sort(arr);
		for (int i: arr)
			System.out.print(" " +i);
	}
	
	public static void sort(int[] arr) {
		int element; 
	    int j; 
	    //[3, 4, 51, 2, 99, 3, 55, 2, 1, -1]
	    for ( int i = 1; i < arr.length; i++ ){
	        element = arr[i];
	        j = i;

	        while ( j > 0 && arr[j-1] > element ){
	        arr[j] = arr[j-1];
	        j = j - 1;
	        }
	        arr[j] = element;
	    }
	}

}
