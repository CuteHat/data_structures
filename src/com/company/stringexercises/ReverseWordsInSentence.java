package com.company.stringexercises;


/**
 * Given a sentence (an array of characters), reverse the order of its words without affecting the order of letters
 * within a given word. All operations must be done in place.
 */
public class ReverseWordsInSentence {
    public static void main(String[] args) {
//        System.out.println(reverseWords("Hello world".toCharArray()));
        System.out.println(reverseWords("We love Java".toCharArray()));
    }

    public static String reverseWords(char[] sentence) {
        // reverse whole array
        reverseArray(sentence, 0, sentence.length - 1);

        int wordStart = 0;
        // iterate over reversed array and reverse words one by one
        for (int i = 0; i < sentence.length; i++) {
            if (sentence[i] == ' ') {
                reverseArray(sentence, wordStart, i - 1);
                wordStart = i + 1;
            } else if (i == sentence.length - 1) {
                reverseArray(sentence, wordStart, i);
            }
        }
        return String.valueOf(sentence);
    }

    //    reverse string
    public static void reverseArray(char[] sentence, int startIndex, int lastIndex) {
        if (sentence == null || sentence.length < 1)
            return;

        while (startIndex < lastIndex) {
            char temp = sentence[startIndex];
            sentence[startIndex++] = sentence[lastIndex];
            sentence[lastIndex--] = temp;
        }
    }
}
