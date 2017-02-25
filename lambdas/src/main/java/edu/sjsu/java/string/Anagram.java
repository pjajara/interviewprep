package edu.sjsu.java.string;

import java.util.Arrays;

public class Anagram {

    public static boolean isAnagram(String s1, String s2) {

        if (s1 == null || s2 == null) {
            return false;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        String sc1 = new String(c1);
        String sc2 = new String(c2);

        return sc1.equals(sc2);
    }

    public static void anotherTestMethod() {
        String str[] = {"str1", "str2"};
        for (String s : str) {

        }
    }

    public static boolean checkAnagram(String s1, String s2){

        if (s1 == null || s2 == null){
            return false;
        }

        if (s1.length() != s2.length()){
            return false;
        }

        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();

        Arrays.sort(chs1);
        Arrays.sort(chs2);

        String ss1 = new String(chs1);
        String ss2 = new String(chs2);

        return ss1.equals(ss2);
    }

}
