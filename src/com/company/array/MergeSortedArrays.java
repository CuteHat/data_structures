package com.company.array;

/**
 * In this problem, given two sorted arrays, you have to implement the int[] mergeArrays(int[] arr1, int[] arr2) method,
 * which returns an array consisting of all elements of both arrays in a sorted way.
 */
public class MergeSortedArrays {
    public static void main(String[] args) {
        // write your code here
        int[] arr1 = {1, 3, 4, 5};
        int[] arr2 = {2, 6, 7, 8};

        printArray(mergeArrays(arr1, arr2));

    }

    public static int[] mergeArrays2(int[] arr1, int[] arr2) {
        int s1 = arr1.length;
        int s2 = arr2.length;

        int i1 = 0, i2 = 0;

        int[] mergedArray = new int[arr1.length + arr2.length];
        int i = 0;

        while (i1 < s1 && i2 < s2) {
            if (arr1[i1] < arr2[i2])
                mergedArray[i++] = arr1[i1++];
            else
                mergedArray[i++] = arr2[i2++];
        }

        // remaining elements
        while (i1 < s1)
            mergedArray[i++] = arr1[i1++];

        while (i2 < s2)
            mergedArray[i++] = arr2[i2++];

        return mergedArray;
    }

    // merge arr1 and arr2 into a new result array
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        // write your code here
        int[] mergedArray = new int[arr1.length + arr2.length];
        int i = 0;

        int i1 = 0, i2 = 0;
        boolean arr1IsComplete = false;
        boolean arr2IsComplete = false;

        while (true) {
            if (i1 == arr1.length)
                arr1IsComplete = true;
            if (i2 == arr2.length)
                arr2IsComplete = true;

            if (arr1IsComplete && arr2IsComplete)
                break;

            if (arr2IsComplete) {
                mergedArray[i++] = arr1[i1++];
                continue;
            }
            if (arr1IsComplete) {
                mergedArray[i++] = arr2[i2++];
                continue;
            }

            if (arr1[i1] < arr2[i2]) {
                mergedArray[i++] = arr1[i1++];
            } else {
                mergedArray[i++] = arr2[i2++];
            }
        }

        return mergedArray;
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + ",");
        }
    }
}
