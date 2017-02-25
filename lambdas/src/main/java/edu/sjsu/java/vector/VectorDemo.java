package edu.sjsu.java.vector;

import java.util.List;
import java.util.Vector;

public class VectorDemo {

	public static void main(String[] args) {

		List<Integer> list = new Vector<>();
		list.add(111);
		list.add(222);
		list.add(402);

		list.stream().forEach((e) -> System.out.println(e));

		Vector v1 = new Vector();
		v1.add("Sample String");
		v1.add("St");
		v1.add("123");

		String s = ((String) v1.get(0));
		String k = ((String) v1.get(1));
		System.out.println(s + " " + k);

	}
}
