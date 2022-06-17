package com.company.array;

/**
 * In this problem, you have to implement the int[] findProduct(int[] arr) method which
 * will modify arr in such a way that in the output, each index i will contain the product of all
 * elements present in arr except the element stored on that index i.
 */
public class ProductArray {
    public static void main(String[] args) {
        int[] arr = {2,5,9,3,6};
        ArrayUtil.print(findProduct2(arr));
//        arr = {24,12,8,6}
    }

    public static int[] findProduct2(int arr[]) {
        int totalProduct = 1;
        for (int n : arr) {
            totalProduct *= n;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = totalProduct / arr[i];
        }

        return arr;
    }

    public static int[] findProduct(int arr[]) {
        int prevProduct = 1;

        int current;
        for (int i = 0; i < arr.length; i++) {
            int product = 1;
            for (int j = i + 1; j < arr.length; j++) {
                product *= arr[j];
            }

            current = arr[i];
            arr[i] = product * prevProduct;
            prevProduct = prevProduct * current;
        }

        return arr;
    }
}
