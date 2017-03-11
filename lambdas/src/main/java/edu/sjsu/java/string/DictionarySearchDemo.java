package edu.sjsu.java.string;

import java.util.*;

/**
 * Created by pjajara on 3/6/17.
 */
public class DictionarySearchDemo {

    public static void main(String[] args) {
        System.out.println(search("samsung"));
    }

    public static Set<String> getDictionary() {
        Set<String> dictionary = new HashSet<>();
        dictionary.add("i");
        dictionary.add("am");
        dictionary.add("sam");
        dictionary.add("samsung");
        dictionary.add("sam");
        return dictionary;
    }

    public static String search(String input) {

        List<String> result = new ArrayList<>();
        search(getDictionary(), input, result, new Stack<String>());
        StringBuilder sb = new StringBuilder();

        for (String s : result) {
            sb.append(s).append(" ");
        }

        return sb.toString();
    }

    public static void search(Set<String> dictionary, String input, List<String> result, Stack<String> words) {

        for (int i = 0; i < input.length(); i++) {
            // take the first i characters of the input and see if it is a word
            String substring = input.substring(0, i + 1);

            if (dictionary.contains(substring)) {
                // the beginning of the input matches a word, store on stack
                words.push(substring);

                if (i == input.length() - 1) {
                    // there's no input left, copy the words stack to results
                    result.addAll(Arrays.asList(words.toString()));
                } else {
                    // there's more input left, search the remaining part
                    search(dictionary, input.substring(i + 1), result, words);
                }

                // pop the matched word back off so we can move onto the next i
                words.pop();
            }
        }
    }
}
