package com.company.array;

/**
 * In this problem, you have to implement the int findMinimum(int[] arr) method,
 * which will traverse the whole array and find the smallest number in the array.
 */
public class FindMinimum {
    public static void main(String[] args) {
        System.out.println(findMinimum(new int[]{9, 2, 3, 6}));
    }

    /**
     * O(n)
     */
    public static int findMinimum(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < min)
                min = num;
        }
        return min;
    }
}
