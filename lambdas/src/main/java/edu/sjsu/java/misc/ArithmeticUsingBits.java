package edu.sjsu.java.misc;

public class ArithmeticUsingBits {

	public static void main(String[] args) {

		int r = add(4,5);
		System.out.println(r);
	}
	
	public static int add(int a, int b){
		if (b == 0){
			return a;
		}
		int sum = a^b;
		int carry = (a&b) << 1;
		return add(sum, carry);
	}

}
