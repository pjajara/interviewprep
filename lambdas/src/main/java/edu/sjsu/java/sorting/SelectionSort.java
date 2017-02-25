package edu.sjsu.java.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int[] array = { 44, 1, 23, 2, -1, 0, 9, 56 };
		sort(array);
		for (int element : array) {
			System.out.print(element + " ");
		}
	}

	public static void sort(int[] arr) {
		int min=-1;

		for (int i = 0; i < arr.length; i++) {
			min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			if (min != i) {
				int temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
	}
}