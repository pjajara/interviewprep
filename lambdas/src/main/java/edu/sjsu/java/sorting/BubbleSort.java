package edu.sjsu.java.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int[] array = { 1, 6, 55, 2, -1, 0, -2 , 8, 111, 1};
		BubbleSort.bubblesort(array);
		// 1,6,55,2
		for (int a : array) {
			System.out.print(" " + a);
		}
	}

	public static void bubblesort(int[] array) {
		for (int i = 0; i < array.length-1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j);
				}
			}
		}
	}

	private static void swap(int[] array, int j) {
		int temp = array[j];
		array[j] = array[j + 1];
		array[j + 1] = temp;
	}

}
