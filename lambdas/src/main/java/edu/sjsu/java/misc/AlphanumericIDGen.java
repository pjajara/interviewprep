package edu.sjsu.java.misc;

import java.util.Random;

public class AlphanumericIDGen {

	public static void main(String[] args) {
		System.out.println(getUniqueID(20));
		System.out.println(getUniqueID(20));
		System.out.println(getUniqueID(20));
		System.out.println(getUniqueID(20));
		System.out.println(getUniqueID(20));
		System.out.println(getUniqueID(20));
	}
	
	public static String getUniqueID(int length) {
		final String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		final int idLength = length;
		Random random = new Random();
		StringBuilder sb = new StringBuilder(idLength);

		for (int i = 0; i < idLength; i++) {
			sb.append(str.charAt(random.nextInt(str.length())));
		}
		return sb.toString();
	}

}
