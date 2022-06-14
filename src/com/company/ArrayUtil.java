package com.company;

public class ArrayUtil {

    public static <T> void print(T[] sequence) {
        System.out.print("[");
        for (int i = 0; i < sequence.length; i++) {
            System.out.print("[" + sequence[i] + (i == sequence.length-1 ? "]" : "] "));
        }
        System.out.print("]");
    }

    public static void print(int[] sequence) {
        System.out.print("[");
        for (int i = 0; i < sequence.length; i++) {
            System.out.print("[" + sequence[i] + (i == sequence.length-1 ? "]" : "] "));
        }
        System.out.print("]");    }

}
