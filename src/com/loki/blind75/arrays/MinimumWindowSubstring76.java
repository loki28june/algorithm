package com.loki.blind75.arrays;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring76 {
    public static String minimumWindowSubstring(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, minLength = s.length() + 1;
        int matched = 0;
        int subStrStart = 0;
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0) {
                    matched++;
                }
            }
            while (matched == map.size()) {
                if (minLength > right - left + 1) {
                    minLength = right - left + 1;
                    subStrStart = left;
                }
                if (map.containsKey(s.charAt(left))) {
                    if (map.get(s.charAt(left)) == 0) matched--;
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                }
                left++;
            }
            right++;
        }
        return minLength > s.length() ? "" : s.substring(subStrStart, subStrStart + minLength);
    }

    public static void main(String[] args) {
        System.out.println(minimumWindowSubstring("ADOBECODEBANC", "ABC"));
    }
}
