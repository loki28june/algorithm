package com.loki.grokkingthecodinginterview.slidingwindow;

public class MaximumSumContiguousSubarray {
    public static int findMaxSumSizeK(int k, int[] arr) {
        int maxSum = 0, windowSum = 0, windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // slide the window, we don't need to slide if we've not hit the window size of 'k'
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(MaximumSumContiguousSubarray
                .findMaxSumSizeK(3, new int[]{2, 1, 5, 1, 3, 2}));
        System.out.println(MaximumSumContiguousSubarray
                .findMaxSumSizeK(2, new int[]{2, 3, 4, 1, 5}));
    }
}
