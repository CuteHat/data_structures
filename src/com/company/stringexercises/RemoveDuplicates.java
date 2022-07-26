package com.company.stringexercises;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Given a string that contains duplicate occurrences of characters,
 * remove the duplicate occurrences such that every character in the string appears only once.
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates3("abbabcddbabcdeedebc".toCharArray()));
    }

    // Solution without set
    static String removeDuplicates3(char[] str) {
        if (str == null || str.length == 0 || str[0] == '\0') return "";

        int writeIndex = 0;
        for (int i = 0; i < str.length; i++) {
            boolean found = false;
            // iterate backwards to see if encountered the character already
            for (int j = 0; j < writeIndex; j++) {
                if (str[i] == str[j]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                str[writeIndex++] = str[i];
            }
        }


        return String.valueOf(Arrays.copyOfRange(str, 0, writeIndex));
    }

    static String removeDuplicates2(char[] str) {
        if (str == null || str.length == 0 || str[0] == '\0') return "";
        Set<Character> charSet = new LinkedHashSet<>();

        int writeIndex = 0;
        int readIndex = 0;

        while (readIndex < str.length) {
            if (!charSet.contains(str[readIndex])) {
                charSet.add(str[readIndex]);
                str[writeIndex++] = str[readIndex];
            }

            readIndex++;
        }

        char[] uniqueChars = Arrays.copyOfRange(str, 0, writeIndex);

        return String.valueOf(uniqueChars);
    }

    // my solution
    static String removeDuplicates(char[] str) {
        Set<Character> charSet = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();
        for (char c : str) {
            if (charSet.add(c)) sb.append(c);
        }

        return sb.toString();
    }
}
