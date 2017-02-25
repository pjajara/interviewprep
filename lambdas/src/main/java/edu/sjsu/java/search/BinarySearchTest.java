package edu.sjsu.java.search;

public class BinarySearchTest {

	public static void main(String[] args) {
		//int k = BinarySearch.search(new int[]{1,2,3,4,4,4,4,4,4,4,11,12,13,14,14,15},0,15,1);
		int k = BinarySearch.countOccurences(new int[]{1,1,3,4,4,4,4,4,4,4,11,12,13,14,14,15}, 13);
		System.out.println(k);
		
	}

}
