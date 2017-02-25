package edu.sjsu.java.misc;

public class BitShiftTest {
	
	public static void main(String[] args){

		int number = 2;
		
		number = number << 1;
		System.out.println(number);
		
		number=2;
		number = number << 2;
		System.out.println(number);
		
		number=2;
		number=number << 3;
		System.out.println(number);
		
		number = 16;
		number = number >> 2;
		System.out.println(number);
		
		number = 8;
		number = number >> 33;
		System.out.println(number);
		
		number = 2;
		System.out.println(~number);
	}

}
