package com.loki.grokkingthecodinginterview.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctChar {
    public static int findMaxSumSizeK(int K, String s) {
        int longestSubstring = Integer.MIN_VALUE, windowStart = 0;
        Map<Character, Integer> charCount = new HashMap<>();
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            charCount.put(s.charAt(windowEnd), charCount.getOrDefault(s.charAt(windowEnd), 0) + 1);
            // slide the window, we don't need to slide if number of chars does not cross K
            while (charCount.size() > K) {
                longestSubstring = Math.max(longestSubstring, windowEnd - windowStart);
                if (charCount.get(s.charAt(windowStart)) == 1) {
                    charCount.remove(s.charAt(windowStart));
                } else {
                    charCount.put(s.charAt(windowStart), charCount.get(s.charAt(windowStart)) - 1);
                }
                windowStart++; // slide the window ahead
            }
        }
        return longestSubstring == Integer.MIN_VALUE ? 1 : longestSubstring;
    }

    public static void main(String[] args) {
        System.out.println(LongestSubstringWithKDistinctChar
                .findMaxSumSizeK(2, "araaci"));
        System.out.println(LongestSubstringWithKDistinctChar
                .findMaxSumSizeK(1, "araaci"));
        System.out.println(LongestSubstringWithKDistinctChar
                .findMaxSumSizeK(3, "cbbebi"));
    }
}
