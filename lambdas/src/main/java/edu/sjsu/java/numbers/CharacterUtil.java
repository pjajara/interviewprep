package edu.sjsu.java.numbers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pjajara on 2/19/17.
 */
public class CharacterUtil {

    public static void main(String[] args) {
        System.out.println(countCharacterOccurence("aabbccddeeffgghhiijjkk&&"));
    }

    public static Map<Character, Integer> countCharacterOccurence(final String input) {

        if (input == null || input == "") {
            return Collections.emptyMap();
        }

        final Map<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {

            Character ch = input.charAt(i);

            if (charMap.containsKey(ch)) {
                charMap.replace(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }
        }
        return charMap;
    }

}
