package com.loki.basic.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArray {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1));
        System.out.println(Arrays.toString(nums.toArray()));
        sort(nums);
        System.out.println(Arrays.toString(nums.toArray()));
    }
    private static void sort(List<Integer> nums) {
        if(nums.size() == 1){ // BC1
            return;
        }
        int last = nums.get(nums.size() - 1);
        nums.remove(nums.size() - 1);
        sort(nums); // hypothesis 1
        insert(nums,last); //induction 1
    }

    private static void insert(List<Integer> nums, int last) {
        if(nums.isEmpty() || nums.get(nums.size() - 1) <= last){ // BC2
            nums.add(last);
            return;
        }
        int currentLast = nums.get(nums.size() - 1);
        nums.remove(nums.size() - 1);
        insert(nums, last); // hypothesis 2
        nums.add(currentLast); // induction 2
    }
}
