package edu.sjsu.java.string;

import java.util.HashMap;
import java.util.Map;

public class StringUtils {

    public static String reverseWords(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String delimiter = " ";
        String words[] = str.split(delimiter);

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }

        return sb.toString();
    }

    public static int charCount(String str, char c) {
        if (str == null) {
            return 0;
        }
        int count = 0;
        char[] cArray = str.toCharArray();

        for (char ch : cArray) {
            if (ch == c)
                count++;
        }
        return count;
    }

    public static void charRepitionCount(String str) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                Integer count = map.get(c);
                map.put(c, count + 1);
            } else {
                map.put(c, 1);
            }
        }
        /*
		for (Map.Entry entry: map.entrySet()){
			System.out.println("Character:" + entry.getKey() + ", count:" + entry.getValue() );
		}*/

        map.forEach((k, v) -> System.out.println("Character:" + k + ", count:" + v));
    }

    public static boolean isRotation(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        String s1s1 = s1 + s1;
        return s1s1.contains(s2);
    }

    public static String frontTimes(String str, int n) {

        if (n < 0 || str == null) {
            return str;
        }
        String subStr = null;
        if (str.length() < 3) {
            subStr = str;
        } else {
            subStr = str.substring(0, 3);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(subStr);
        }
        return sb.toString();
    }

    public int arrayCount9(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }

        int count = 0;
        for (int i : nums) {
            if (i == 9)
                count++;
        }

        return count;
    }

    public static int stringMatch(String a, String b) {

        if (a == null || b == null)
            return 0;

        int counter = 0;
        for (int i = 0; i < a.length() - 2 && i < b.length() - 2; i++) {
            if (a.substring(i, i + 2).equals(b.substring(i, i + 2))) {
                counter++;
            }
        }
        return counter;
    }

    public static String reverseString(String str) {
        if (str == null) {
            return null;
        }
        final int length = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();

    }

    public static String reverseStringR(String str) {
        if (str.length() <= 1) {
            return str;
        }

        //word
        return (reverseStringR(str.substring(1)) + str.charAt(0));
    }


    public static boolean checkPalindrome(String str) {
        if (str == null || str.length() < 2) {
            return false;
        }
        int length = str.length();


        for (int i = 0; i <= length / 2; i++) {
            if (str.toLowerCase().charAt(i) != str.toLowerCase().charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void reverseInPlace(char[] chars) {

        if (chars == null || chars.length <= 1) {
            return;
        }

        int i = 0;
        int j = chars.length - 1;

        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }

    // This is my area
    // aera ym si sihT
    // area my is This


    public static void main(String[] args) {
        // charRepitionCount("The blue lazy foxxxxx jump over the crazy huddle");
		/*System.out.println(isRotation("Pawankumar","kumarPawan"));
		System.out.println(isRotation("Pawankumar","kuman"));
		System.out.println(isRotation("Pawankumar",null));
		frontTimes("Hello World",2);
		int i = "abcxkjdfxksjfx".indexOf("x");
		System.out.println(i);
		stringMatch("hello","he");*/

        //System.out.println(reverseString("Pawankumar Jajara"));
        // System.out.println(reverseString("Pawankumar Jajara"));

       //  char[] charArray = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};
       // reverseInPlace(charArray);
    }

}
