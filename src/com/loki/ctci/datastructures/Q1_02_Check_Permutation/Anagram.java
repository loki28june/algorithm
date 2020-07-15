package com.loki.ctci.datastructures.Q1_02_Check_Permutation;

public class Anagram {
    private static boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        // assuming words from 'a' to 'z'
        int[] chars = new int[128];
        for(int i=0 ; i<s1.length(); i++){
            chars[s1.charAt(i)]++;
        }
        for(int i=0; i<s2.length() ; i++){
            chars[s2.charAt(i)]--;
            if(chars[s2.charAt(i)] < 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println(isAnagram("banana", "nanaba"));
        System.out.println(isAnagram("sukkon","kasoor"));
    }
}
