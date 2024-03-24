package com.loki.neetcode150;

public class LongestRepeatingCharacter_424 {
    public static int characterReplacement(String s, int k) {
        if(k >= s.length()-1) return s.length();
        int[] store = new int[26];
        int longest =0,start=0,end=0;
        int max=0;
        for(end=0;end<s.length();end++){
            store[s.charAt(end) - 'A']++;
            max = getMaxCharCount(store);
            while(end-start+1-max > k){
                longest = Math.max(longest,end-start);
                start++;
                store[s.charAt(start) - 'A']--;
            }
        }
        return longest;
    }

    private static int getMaxCharCount(int[] chars){
        int max = 0;
        for(int num : chars){
            max = Math.max(max,num);
        }
        return max;
    }
    public static void main(String[] args) {
       System.out.println(characterReplacement("ABAB",2));
        System.out.println(characterReplacement("AABABBA",1));
    }

}
