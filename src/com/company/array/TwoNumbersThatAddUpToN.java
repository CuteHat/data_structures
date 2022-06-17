package com.company.array;

import java.util.Arrays;

/**
 * In this problem, you have to implement the int[] findSum(int[] arr, int n) method, which will take a number n,
 * and an array arr as input and returns an array of two integers that add up to n in an array.
 * You are required to return only one such pair. If no such pair is found then simply return the array.
 */
public class TwoNumbersThatAddUpToN {

    public static void main(String[] args) {
        int[] arr = {1, 21, 3, 14, 5, 60, 7, 6};


        int value = 27;
        // arr = {21, 6} or {6, 21}

        System.out.println(Arrays.toString(findSum(arr, value)));
    }

    public static int[] findSum(int[] arr, int n) {
        int[] result = new int[2];

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];

            int j = i + 1;
            while (j < arr.length) {
                if (current + arr[j] == n) {
                    result[0] = current;
                    result[1] = arr[j];
                    break;
                }
                j++;
            }
        }

        return result;
    }
}
