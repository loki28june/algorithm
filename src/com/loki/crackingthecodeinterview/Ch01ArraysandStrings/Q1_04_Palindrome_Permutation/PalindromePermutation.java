package com.loki.crackingthecodeinterview.Ch01ArraysandStrings.Q1_04_Palindrome_Permutation;

import java.util.Locale;

public class PalindromePermutation {

    private static boolean isPalindromePermutation(String str) {
        return findAtMostOneOdd(str);
    }

    // find at most one odd
    private static boolean findAtMostOneOdd(String str){
        int[] table = buildCharTable(str);
        boolean foundOdd = false;
        for(int i=0;i<table.length;i++){
            if(table[i] % 2 == 1){
                if(foundOdd) return false;
                foundOdd = true;
            }
        }
        return true;
    }

    // build char frequency table
    private static int[] buildCharTable(String str){
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for(int i=0;i<str.length();i++){
            int charValue = findNumericCharValue(str.charAt(i));
            if(charValue != -1){
                table[charValue]++;
            }
        }
        return table;
    }

    // find numeric char value
    private static int findNumericCharValue(char charAt) {
        int a = Character.getNumericValue(charAt);
        int z = Character.getNumericValue(charAt);
        int charValue = Character.getNumericValue(charAt);
        if(charValue >= a && charValue <= z){
            return charValue - 'a';
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("Tact Coa".toLowerCase(Locale.ROOT)));
    }
}
