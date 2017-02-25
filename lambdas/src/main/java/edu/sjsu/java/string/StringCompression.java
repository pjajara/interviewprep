package edu.sjsu.java.string;

import java.util.regex.Pattern;

public class StringCompression {

	private static final Pattern pattern = Pattern.compile("[a-z|A-Z]*");

	public static String compress(String str) throws Exception {
		if (str == null) {
			return null;
		}
		validateString(str);
		char last = 0;
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == last) {
				count++;
			} else {
				if (count > 1) {
					sb.append(Integer.toString(count)).append(last);
					count = 1;
				} else if (last != 0) {
					sb.append(last);
				}
				last = c;
			}
		}
		append(sb, last, count);
		return sb.toString();
	}

	private static void append(StringBuilder sb, char last, int count) {
		if (count > 1) {
			sb.append(Integer.toString(count)).append(last);
		} else if (last != 0) {
			sb.append(last);
		}
	}

	private static void validateString(String str) throws Exception {
		if (str.trim().length() == 0
				||!pattern.matcher(str).matches()) {
			throw new Exception("invalid string");
		}
	}
	
	public static void main(String[] args){
		try {
			System.out.println(compress("aaaab33344bbbccccddddeeee"));
			//System.out.println(compress("abcdefghijk"));
			
			Pattern p = Pattern.compile("[a-z | 0-9]*");
			System.out.println(p.matcher("dsdfsdfsdfsdf4554444A").matches());
			//System.out.println(compress("                  "));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
