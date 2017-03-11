package edu.sjsu.java.string;

public class Array2D {

	public static void main(String[] args) {

		String[] a = {"a"};
		String[] b = { "e", "f", "g", "h" };
		String[] c = { "i", "j", "k", "l" };
		
		String[][] array = { a,b,c };

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(" " + array[i][j]);
			}
		}
	}

}
