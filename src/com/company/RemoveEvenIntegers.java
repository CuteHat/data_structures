package com.company;

/**
 * Remove even integers from an array
 */
public class RemoveEvenIntegers {
    public static void main(String[] args) {
        ArrayUtil.print(new int[]{1, 2, 3, 4});
    }

    public static int[] removeEven(int[] arr) {
        int oddElements = 0;

        //Find number of odd elements in arr
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) oddElements++;
        }

        //Create result array with the size equal to the number of odd elements in arr
        int[] result = new int[oddElements];
        int result_index = 0;

        //Put odd values from arr to the resulted array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0)
                result[result_index++] = arr[i];
        } //end of for loop

        return result;
    }
}
