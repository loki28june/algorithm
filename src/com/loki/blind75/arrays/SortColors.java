package com.loki.blind75.arrays;

public class SortColors {

    public static int[] sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                mid++;
                low++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, high, mid);
                high--;
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int low, int mid) {
        int temp = nums[mid];
        nums[mid] = nums[low];
        nums[low] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        for (int value : sortColors(nums)) {
            System.out.print(value+ " ");
        }
    }

}
