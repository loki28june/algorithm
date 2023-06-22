package com.loki.grokkingthecodinginterview.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {
    public static int findMaxFruits(int basketNum, char[] chars) {
        int maxFruits = Integer.MIN_VALUE, windowStart = 0,windowEnd;
        Map<Character, Integer> charCount = new HashMap<>();
        for (windowEnd = 0; windowEnd < chars.length; windowEnd++) {
            charCount.put(chars[windowEnd], charCount.getOrDefault(chars[windowEnd], 0) + 1);
            // slide the window, we don't need to slide if number of chars does not cross basket no
            while (charCount.size() > basketNum) {
                maxFruits = Math.max(maxFruits, windowEnd - windowStart);
                if (charCount.get(chars[windowStart]) == 1) {
                    charCount.remove(chars[windowStart]);
                } else {
                    charCount.put(chars[windowStart], charCount.get(chars[windowStart]) - 1);
                }
                windowStart++; // slide the window ahead
            }
        }
        return maxFruits == Integer.MIN_VALUE ? 1 : Math.max(maxFruits,windowEnd-windowStart); // Edge condition
    }

    public static void main(String[] args) {
        System.out.println(FruitsIntoBaskets
                .findMaxFruits(2, new char[]{'A', 'B', 'C', 'A', 'C'}));
        System.out.println(FruitsIntoBaskets
                .findMaxFruits(2, new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
    }
}
