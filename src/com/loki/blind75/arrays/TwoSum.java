package com.loki.blind75.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
       int[] ans = twoSum(new int[]{3,2,4}, 6);
       System.out.println(Arrays.toString(ans));
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> store = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(store.containsKey(target - nums[i])){
                int index1 = store.get(target - nums[i]);
                return new int[]{index1,i};
            }
            store.put(nums[i],i);
        }
        return new int[]{};
    }
}
