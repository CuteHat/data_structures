package com.company.stringexercises;

import java.util.Arrays;

/**
 * Given a null-terminated string, remove all the white spaces (tabs or spaces) present in the string.
 */
public class RemoveWhiteSpaces {
    public static void main(String[] args) {
        System.out.println(removeWhiteSpaces("All greek to me.".toCharArray()));
    }

    static String removeWhiteSpaces(char[] s) {
        int readPointer = 0;
        int writePointer = 0;

        while (readPointer < s.length) {
            if (!(s[readPointer] == ' ' || s[readPointer] == '\t')) {
                s[writePointer++] = s[readPointer];
            }
            readPointer++;
        }

        return String.valueOf(Arrays.copyOfRange(s, 0, writePointer));
    }
}
