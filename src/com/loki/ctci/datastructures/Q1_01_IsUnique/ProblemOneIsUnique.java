package com.loki.ctci.datastructures.Q1_01_IsUnique;

import java.util.HashMap;
import java.util.Map;

public class ProblemOneIsUnique {
    public static void main(String[] args) {
        String str1 = "abcdfsecg";
        String str2 = "abcdefg";
        boolean isUnique = doesStringHasUnqiueChars(str1);
        boolean isUnique2 = doesStringHasUnqiueChars(str2);
        System.out.println("Is First String unique => " + isUnique);
        System.out.println("Is Second String unique => " + isUnique2);
    }

    private static boolean doesStringHasUnqiueChars(String str) {
        Map<Character, Integer> charToFrequencyMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if(charToFrequencyMap.get(str.charAt(i)) == null){
                charToFrequencyMap.put(str.charAt(i) , 1);
                continue;
            }
            int count = charToFrequencyMap.get(str.charAt(i));
            charToFrequencyMap.put(str.charAt(i), ++count);
        }
        for (int i = 0; i < str.length(); i++) {
            if(charToFrequencyMap.get(str.charAt(i)) > 1){
                return  Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
