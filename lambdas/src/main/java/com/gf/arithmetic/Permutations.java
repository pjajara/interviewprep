package com.gf.arithmetic;

import java.util.*;

/**
 * Created by pjajara on 2/26/17.
 */
public class Permutations {

    // print n! permutation of the characters of the string s (in order)
    public static List<String> perm1(String s) {
        final List<String> result = new ArrayList<>();
        perm1("", s, result);
        return result;
    }

    private static void perm1(String prefix, String s, List<String> result) {
        int strlen = s.length();
        if (strlen == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < strlen; i++) {
                perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, strlen), result);
            }
        }
    }

    // print n! permutation of the elements of array a (not in order)
    public static void perm2(String s) {
        int n = s.length();
        char[] a = new char[n];

        for (int i = 0; i < n; i++)
            a[i] = s.charAt(i);

        perm2(a, n);
    }

    private static void perm2(char[] a, int n) {
        if (n == 1) {
            System.out.println(a);
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n - 1);
            perm2(a, n - 1);
            swap(a, i, n - 1);
        }
    }

    // swap the characters at indices i and j
    private static void swap(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

    public static void main(String[] args) {
//        String alphabet = "abcd";
//        perm1(alphabet);
//        perm2(alphabet);

        System.out.println(digitToString("23", numToStringMap()));
    }

    public static Map<String, String> numToStringMap() {

        Map<String, String> mappings = new HashMap<>(10);
        mappings.put("0", "");
        mappings.put("1", "");
        mappings.put("2", "abc");
        mappings.put("3", "def");
        mappings.put("4", "ghi");
        mappings.put("5", "jkl");
        mappings.put("6", "mno");
        mappings.put("7", "pqrs");
        mappings.put("8", "tuv");
        mappings.put("9", "wxyz");

        return Collections.unmodifiableMap(mappings);
    }

    public static List<String> digitToString(String str, Map<String, String> digitsMap) {

        if (str == null || str.length() == 0) {
            return Collections.emptyList();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            String s = digitsMap.get(String.valueOf(str.charAt(i)));
            if (s != null){
                sb.append(s);
            }
        }

        return perm1(sb.toString());
    }
}


