package com.company.array;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 3, 9, 10, 12};
        System.out.println(binarySearch(nums, 1));
        System.out.println(binarySearch(nums, 3));
        System.out.println(binarySearch(nums, 9));
        System.out.println(binarySearch(nums, 10));
        System.out.println(binarySearch(nums, 12));
    }

    static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        int midIndex;
        int midNum;
        while (low <= high) {
            midIndex = (low + high) / 2;
            midNum = nums[midIndex];

            if (target == midNum)
                return midIndex;

            if (midNum > target)
                high = midIndex - 1;
            else
                low = midIndex + 1;
        }

        return -1;
    }
}
