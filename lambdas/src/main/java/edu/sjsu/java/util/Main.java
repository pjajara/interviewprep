package edu.sjsu.java.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pjajara on 2/18/17.
 */
public class Main {

    private String name;

    public Main(final String s){
        this.name = s;
    }
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.replace("a", "1");
        System.out.println(map.get("a"));

        map.put("a", "1");
        System.out.println(map.get("a"));

        map.replace("a", "2");
        System.out.println(map.get("a"));


        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
