package com.loki.blind75.arrays;

public class MinSizeSubArraySum {
    public static int minSizeSubArraySum(int[] nums,int target){
        int left=0,sum=0;
        int minLen=Integer.MAX_VALUE;
        for(int right=0;right<nums.length;right++){
            sum += nums[right];
            while(sum >= target){
                minLen= Math.min(right-left+1,minLen);
                sum -= nums[left];
                left++;
            }
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
    public static void main(String[] args){
        System.out.println(minSizeSubArraySum(new int[]{2,3,1,2,4,3},7));
    }
}
