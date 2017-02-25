package edu.sjsu.java.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class SortStringArray implements Comparator<String>{

	public static void main(String[] args){
		String[] arr = {"abc","cba","bca","xyz","yzx","zxy","222"};
		Arrays.sort(arr, new SortStringArray());
		for (String s: arr)
		System.out.print(" "+s);
	}

	public static String sortCharacters(String s){
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	
	@Override
	public int compare(String s1, String s2) {
		return sortCharacters(s1).compareTo(sortCharacters(s2));
	}
}
