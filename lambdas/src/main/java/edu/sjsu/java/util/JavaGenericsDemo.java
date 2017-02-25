package edu.sjsu.java.util;

import java.util.ArrayList;
import java.util.List;

public class JavaGenericsDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Varun");
        list.add("Jajara");

        for (String str : list) {
            System.out.println(str);
        }
    }

}
