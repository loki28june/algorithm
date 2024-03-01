package com.loki.neetcode150;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Minimum_Window_Substring_76 {
    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int start = 0, min_window = s.length() + 1, matched = 0, substringStart = 0;
        for (int end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) - 1);
                if (map.get(s.charAt(end)) == 0) {
                    matched++;
                }
            }
            while (matched == map.size()) {
                if (min_window > end - start + 1) {
                    min_window = end - start + 1;
                    substringStart = start;
                }
                if (map.containsKey(s.charAt(start))) {
                    if (map.get(s.charAt(start)) == 0) {
                        matched--;
                    }
                    map.put(s.charAt(start), map.getOrDefault(s.charAt(start), 0) + 1);
                }
                start++;
            }
        }
        return min_window > s.length() ? "" : s.substring(substringStart, substringStart + min_window);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
    }
}
