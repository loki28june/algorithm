package com.loki.ctci.datastructures.Q1_04_Palindrome_Permutation;

public class PalindromePermutation {
    private static boolean isPalindromePermutation(String str){
        int[] charSet = new int[128];
        String str1 = str.toLowerCase();
        for (int i =0; i< str1.length(); i++){
            charSet[str1.charAt(i)]++;
        }
        int countOdd = 0;
        for(int i =0;i<128;i++){
            if(charSet[i] % 2 != 0 && i != 32){ // skipping for space
                countOdd++;
            }
        }
        if(countOdd > 1){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(isPalindromePermutation("Tact Coa"));
    }
}
