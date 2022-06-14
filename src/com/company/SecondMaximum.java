package com.company;

public class SecondMaximum {
    public static void main(String[] args) {
        int[] arr = {9, 2, 3, 6};
        int[] arr2 = {4, 2, 1, 5, 0};
        System.out.println(findSecondMaximum2(arr2));
    }

    public static int findSecondMaximum2(int[] arr) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max1) {
                max2 = max1;
                max1 = arr[i];
            } else if (arr[i] > max2 && arr[i] != max1) {
                max2 = arr[i];
            }
        }
        return max2;
    }

    public static int findSecondMaximum(int[] arr) {
        int max1 = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max1) {
                max1 = arr[i];
            }
        }

        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max2 && arr[i] != max1) {
                max2 = arr[i];
            }
        }

        return max2;
    }
}
