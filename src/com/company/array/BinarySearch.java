package com.company.array;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 3, 9, 10, 12};
//        System.out.println(binarySearch(nums, 1));
//        System.out.println(binarySearch(nums, 3));
//        System.out.println(binarySearch(nums, 9));
//        System.out.println(binarySearch(nums, 10));
//        System.out.println(binarySearch(nums, 12));
        // recursive
        System.out.println(binarySearchRecursive(nums, 1, 0, nums.length - 1));
        System.out.println(binarySearchRecursive(nums, 3, 0, nums.length - 1));
        System.out.println(binarySearchRecursive(nums, 9, 0, nums.length - 1));
        System.out.println(binarySearchRecursive(nums, 10, 0, nums.length - 1));
        System.out.println(binarySearchRecursive(nums, 12, 0, nums.length - 1));
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

    static int binarySearchRecursive(int[] nums, int target, int low, int high) {
        if (low > high)
            return -1;

        int midIndex = (low + high) / 2;
        int midNum = nums[midIndex];

        if (midNum == target)
            return midIndex;

        if (midNum > target)
            return binarySearchRecursive(nums, target, low, midIndex - 1);
        else
            return binarySearchRecursive(nums, target, midIndex + 1, high);
    }
}
