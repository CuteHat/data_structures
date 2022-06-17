package com.company.array;

/**
 * In this problem, you have to implement the void reArrange(int[] arr) method,
 * which will sort the elements, such that all the negative elements
 * appear at the left and positive elements appear at the right.
 */
public class ReArrangePositiveNegativeValues {
    public static void main(String[] args) {
        int[] arr = {10, -1, 20, 4, 5, -9, -6};
        reArrange3(arr);
        ArrayUtil.print(arr);
    }

    public static void reArrange3(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {   // if negative number found
                if (i != j) {
                    int temp = arr[i];
                    arr[i] = arr[j]; // swapping with leftmost positive
                    arr[j] = temp;
                }
                j++;
            }
        }
    }

    public static void reArrange2(int[] arr) {
        int[] temp = new int[arr.length];
        int tempIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                temp[tempIndex++] = arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                temp[tempIndex++] = arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }

    }

    public static void reArrange(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            // if element is positive
            if (arr[i] >= 0) {
                // traverse array to find negative value and swap places
                for (int j = i; j < arr.length; j++) {
                    if (arr[j] < 0) {
                        // swap
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }
}
