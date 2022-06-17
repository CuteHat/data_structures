package com.company.array;

/**
 * In this problem, you have to implement the void rotateArray(int[] arr) method,
 * which takes an arr and rotate it right by 1.
 * This means that the right-most elements will appear at the left-most position in the array.
 */
public class RotateArrayByOne {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        rotateArray2(arr);
        ArrayUtil.print(arr);
    }

    public static void rotateArray(int[] arr) {
        int previousValue = arr[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            arr[i] = previousValue;
            previousValue = current;
        }
    }

    public static void rotateArray2(int[] arr) {
        int lastE = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = lastE;
    }

}
