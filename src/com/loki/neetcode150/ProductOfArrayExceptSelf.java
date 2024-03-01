package com.loki.neetcode150;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int[] answer = new int[nums.length];
        int pre=1,post=1;
        for(int i=0;i<nums.length;i++){
            prefix[i] = pre;
            pre *= nums[i];
        }
        for(int j=nums.length-1;j>=0;j--){
            postfix[j] = post;
            post *= nums[j];
        }

        for(int k=0;k<nums.length;k++){
            answer[k] = prefix[k]*postfix[k];
        }
        return answer;

    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(obj.productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
