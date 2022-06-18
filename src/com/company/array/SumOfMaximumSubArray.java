package com.company.array;

/**
 * Given an integer array, return the maximum subarray sum.
 * The array may contain both positive and negative integers and is unsorted.
 */
public class SumOfMaximumSubArray {
    public static void main(String[] args) {
        int[] arr = {1, 7, -2, -5, 10, -1};
        int[] arr2 = {-1, 1, -2, 5, 10, -1};
        System.out.println(findMaxSumSubArray(arr2));
    }

    /**
     * Kadane's algorithm
     */
    public static int findMaxSumSubArray(int[] arr) {
        if (arr.length < 1) {
            return 0;
        }

        int maxGlobalSum = arr[0];
        int currentMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (currentMax < 0) {
                currentMax = arr[i];
            } else {
                currentMax += arr[i];
            }

            if (maxGlobalSum < currentMax) {
                maxGlobalSum = currentMax;
            }
        }

        return maxGlobalSum;
    }
}
