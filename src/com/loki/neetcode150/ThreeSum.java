package com.loki.neetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> solution = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i< nums.length-2;i++){
            if(i !=0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = nums.length-1;
            while(j < k){
                if(nums[j] + nums[k] == -nums[i]){
                    List<Integer> sol = new ArrayList<>();
                    sol.add(nums[i]);
                    sol.add(nums[j]);
                    sol.add(nums[k]);
                    solution.add(sol);
                    j++;
                    k--;
                }
                else if(nums[j] + nums[k] < -nums[i]){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
