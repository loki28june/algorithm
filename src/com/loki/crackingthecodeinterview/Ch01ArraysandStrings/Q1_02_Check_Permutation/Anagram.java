package com.loki.crackingthecodeinterview.Ch01ArraysandStrings.Q1_02_Check_Permutation;


public class Anagram {
    private static boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length()){
            return false; // Permutations must be same length
        }
        int[] letters = new int[128]; // assumed ASCII
        for(int i=0;i<s1.length();i++){
            letters[s1.charAt(i)]++;
        }
        for(int i=0;i<s2.length();i++){
            letters[s2.charAt(i)]--;
            if(letters[s2.charAt(i)] < 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = isAnagram(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }
}
