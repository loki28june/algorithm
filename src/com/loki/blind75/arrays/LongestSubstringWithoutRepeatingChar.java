package com.loki.blind75.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChar {
    public static int longestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int maxLength = 0;
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            map.put(s.charAt(right), right);
            maxLength = Math.max(right - left + 1, maxLength);
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("abcdaabefgc"));
    }
}
