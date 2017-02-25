package edu.sjsu.java.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestClass {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>()
		;
		Configuration cfg = new Configuration("127.0.0.1", 100, "localhost");
		cfg = new Configuration("127.0.0.", 200, "localgost");
		System.out.println(cfg.getHostName());
		System.out.println(cfg.getBufferSize());
		System.out.println(cfg.getIp());
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("CA", "California");
		map.put("TX", "Texas");
		map.put("CO", "Colorado");
		
		for (Map.Entry<String, String> entry : map.entrySet()){
			System.out.println(entry.getKey() +" "+ entry.getValue());
		}
		
		System.out.println(map.containsKey("CA"));

		Iterator iterator = map.entrySet().iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		String[] arr = merge(new String[]{"ds","sdf0", "sdd", "dfsssssssss"}, new String[] {"ds2","sdf20", "sdd2", "dfsssssssss2"});
		System.out.println(arr[0]);
		
		String str = "abcdefgh";
		int i = str.indexOf("mm");
	}
	
	public synchronized static String[] merge(String[] arr1, String[] arr2) {
		if (arr1 == null) {
			return arr2;
		}

		if (arr2 == null) {
			return arr1;
		}

		ArrayList<String> list = new ArrayList<String>();

		for (String s : arr1) {
			list.add(s);
		}

		for (String s : arr2) {
			list.add(s);
		}
		
		String[] arr = new String[list.size()];
		return list.toArray(arr);
	}
}
