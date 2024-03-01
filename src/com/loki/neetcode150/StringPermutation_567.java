package com.loki.neetcode150;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation_567 {
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        Map<Character,Integer> s1Count = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            s1Count.put(s1.charAt(i),s1Count.getOrDefault(s1.charAt(i),0)+1);
        }
        Map<Character,Integer> s2Count = new HashMap<>();
        int start=0;
        for(int end=0;end<s2.length();end++){
            s2Count.put(s2.charAt(end),s2Count.getOrDefault(s2.charAt(end),0)+1);
            if(end-start+1 >= s1.length()){
                if(isPermutation(s1Count,s2Count)){
                    return true;
                }
                s2Count.put(s2.charAt(start),s2Count.getOrDefault(s2.charAt(start),0)-1);
                if(s2Count.get(s2.charAt(start)) == 0){
                    s2Count.remove(s2.charAt(start));
                }
                start++;
            }

        }
        return false;
    }

    public static boolean isPermutation(Map<Character,Integer> s1Count, Map<Character,Integer> s2Count){
        if(s1Count.size() != s2Count.size()) return false;
        return s1Count.equals(s2Count);
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab","eidbaooo"));
        System.out.println(checkInclusion("ab","eidboaoo"));
        System.out.println(checkInclusion("adc","dcda"));
    }
}
