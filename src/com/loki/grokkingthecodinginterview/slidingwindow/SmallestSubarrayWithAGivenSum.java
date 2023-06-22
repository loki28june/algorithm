package com.loki.grokkingthecodinginterview.slidingwindow;

public class SmallestSubarrayWithAGivenSum {
    public static int findMaxSumSizeK(int s, int[] arr) {
        int smallestSubarray = Integer.MAX_VALUE, windowSum = 0, windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // slide the window, we don't need to slide if we've not hit the window size of 's'
            while (windowSum >= s) {
                smallestSubarray = Math.min(smallestSubarray, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }
        return smallestSubarray == Integer.MAX_VALUE ? 0 : smallestSubarray;
    }

    public static void main(String[] args) {
        System.out.println(SmallestSubarrayWithAGivenSum
                .findMaxSumSizeK(7, new int[]{2, 1, 5, 2, 3, 2}));
        System.out.println(SmallestSubarrayWithAGivenSum
                .findMaxSumSizeK(7, new int[]{2, 1, 5, 2, 8}));
    }
}
