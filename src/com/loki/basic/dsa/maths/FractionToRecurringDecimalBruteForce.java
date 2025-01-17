package com.loki.basic.dsa.maths;

import java.util.*;

public class FractionToRecurringDecimalBruteForce {
    public static String fractionToDecimal(int numerator, int denominator) {
        // If numerator is 0, the result is 0
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        // Determine the sign of the result
        if ((numerator < 0) ^ (denominator < 0)) result.append("-");

        // Convert to long to prevent overflow and get the absolute values
        long num = Math.abs((long) numerator);
        long denom = Math.abs((long) denominator);

        // Append the integer part
        result.append(num / denom);
        num %= denom;  // Get the remainder

        // If there's no remainder, return the result (no fractional part)
        if (num == 0) return result.toString();

        // Otherwise, there's a fractional part
        result.append(".");

        // Use a map to store remainders and their corresponding positions in the result
        Map<Long, Integer> remainderMap = new HashMap<>();

        // Perform long division
        while (num != 0) {
            // If the remainder repeats, we found the recurring cycle
            if (remainderMap.containsKey(num)) {
                int pos = remainderMap.get(num);
                result.insert(pos, "(");
                result.append(")");
                break;
            }

            // Store the current remainder and its position in the result
            remainderMap.put(num, result.length());

            num *= 10;
            result.append(num / denom);
            num %= denom;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(4, 333));
    }
}

