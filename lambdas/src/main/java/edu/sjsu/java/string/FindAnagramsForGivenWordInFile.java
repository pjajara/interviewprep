package edu.sjsu.java.string;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindAnagramsForGivenWordInFile {

	//java FindAnagramsForGivenWordInFile mystring file.txt
	public static void main(String[] args) throws Exception{

		if (args.length != 1) {
			throw new Exception();
		}

		String input = args[0];
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		try {
			FileReader fr = new FileReader("src/file.txt");
			Scanner sc = new Scanner(fr);

			while (sc.hasNext()) {
				String currentWord = sc.next();
				String key = sortedChars(currentWord);
				if (!map.containsKey(key)) {
					map.put(key, new ArrayList<String>());
				}
				ArrayList<String> list = map.get(key);
				list.add(currentWord);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<String> list = map.get(sortedChars(input));

		for (String s : list) {
			System.out.println(s);
		}
	}

	public static String sortedChars(String s) {
		if (s == null) {
			return s;
		}
		char ch[] = s.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}

}
