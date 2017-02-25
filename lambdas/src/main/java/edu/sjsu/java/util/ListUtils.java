package edu.sjsu.java.util;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by pjajara on 2/18/17.
 */
public class ListUtils {

    public static void main(String[] args) {

        List<Integer> sample = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 0, 5, 4, 100);

        Set<Integer> s = new HashSet<>(sample);

        s.stream().collect(Collectors.toList()).forEach(System.out::println);
//        Set<Integer> mySet = new HashSet<>();
//        mySet.stream().collect(Collectors.toList()).forEach(System.out::println);

//        List<Integer> withoutDups = removeDuplicates(sample);
//
//        withoutDups.stream().forEach(System.out::println);

    }

    public static List<Integer> removeDuplicates(final List<Integer> integers) {
        return new ArrayList<>(new HashSet<>(integers));
    }
}
