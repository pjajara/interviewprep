package edu.sjsu.java.util;

/**
 * Created by pjajara on 2/12/17.
 */
public class App {

    public static void main(String[] args) {

        Pair<String, String> countryMap = new OrderedPair<>("CA", "California");

        System.out.println(countryMap.getKey());
        System.out.println(countryMap.getValue());
    }
}
