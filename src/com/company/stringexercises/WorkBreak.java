package com.company.stringexercises;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * We’re given a dictionary of words and an input string. Find out whether the input string can be completely
 * segmented into the words of a given dictionary. Input string and the dictionary words will not contain spaces.
 * Words dictionary: ["apple", "pear", "pier", "pie"]
 * Input string: "applepie"
 */
public class WorkBreak {
    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>();
        dictionary.add("hello");
        dictionary.add("world");

        System.out.println(canSegmentString("hello", dictionary));
    }

    public static boolean canSegmentString(String inputString, Set<String> dictionary) {
        Iterator<String> iterator = dictionary.iterator();

    }
}
