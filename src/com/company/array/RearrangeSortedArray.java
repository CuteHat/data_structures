package com.company.array;

/**
 * In this problem, you have to implement the void maxMin(int[] arr) method.
 * This will re-arrange the elements of a sorted array in such a way that the first position will have the largest number,
 * the second will have the smallest, the third will have the second-largest, and so on.
 * Note: The given array is sorted in ascending order.
 * Note: The range of integers in the array can be from 0 to 10000.
 */
public class RearrangeSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        maxMin2(arr);
        ArrayUtil.print(arr);
    }

    public static void maxMin2(int[] arr) {
        int length = arr.length;
        int[] temp = new int[length];
        int i = 0, j = length - 1;

        boolean appendFromEnd = true;
        for (int k = 0; k < temp.length; k++) {
            if (appendFromEnd)
                temp[k] = arr[j--];
            else
                temp[k] = arr[i++];
            appendFromEnd = !appendFromEnd;
        }

        for (int k = 0; k < length; k++) {
            arr[k] = temp[k];
        }
    }

    public static void maxMin(int[] arr) {
        int length = arr.length;
        int[] temp = new int[length];
        int tempIndex = 0, i = 0, j = length - 1;
        while (i != j) {
            temp[tempIndex++] = arr[j];
            temp[tempIndex++] = arr[i];
            i++;
            j--;
        }

        if (length % 2 == 1) {
            temp[length - 1] = arr[length / 2];
        }

        for (int k = 0; k < length; k++) {
            arr[k] = temp[k];
        }
    }
}
