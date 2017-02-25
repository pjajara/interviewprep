package edu.sjsu.java.garbage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Crash {
	
	public static void main(String[] args){
		/*int i=18;
		while (i > 0){
			i = i >> 2;
		}
		if (i==1)
			System.out.println("NOT Power of 2");
		else 
			System.out.println("Power of 2");
		
		printCharCount("aaaaaaaaaa");
		
		int[] temp = { 1, 2, 3, 4, 7 };
		printPairsWithSumK(temp, 3);*/
		
		int f = 0;
		int numUpto = 10; // number of series upto - change accordingly
		for (int t = 1; f < numUpto; t = f + (f = t)) {
			System.out.print(f + " ");
		}

	}
	
	public static void printDeck(List suits, List cards) 
	 {
	     for (Iterator sIt = suits.iterator(); sIt.hasNext(); ) {
	         for (Iterator cIt = cards.iterator(); cIt.hasNext(); ) {
	             System.out.println(sIt.next().toString() + cIt.next().toString());
	         }
	     }
	  }
	
	public static void printCharCount(String str) {
		if (str == null) {
			return;
		}
		char[] array = str.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for (char c : array) {
			if (map.containsKey(c)) {
				int count = map.get(c);
				map.put(c, ++count);
			} else {
				map.put(Character.toLowerCase(c), 1);
			}
		}
		
		for (Map.Entry<Character, Integer> entry: map.entrySet()){
			System.out.println(entry.getKey() + " "+ entry.getValue());
		}
		
		Iterator i = map.entrySet().iterator();
		
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
	
	public static Map printPairsWithSumK(int[] arr, int k){
		if(arr == null){
			return null;
		}
		Map<Integer, Integer> pairsMap = new HashMap<Integer, Integer>();
		
		for (int i: arr){
			if(pairsMap.containsKey(i)){
				System.out.println( i +" "+pairsMap.get(i) );
			}
			else{
				pairsMap.put(k-i,i);
			}
		}
		return pairsMap;
		
	}
}
