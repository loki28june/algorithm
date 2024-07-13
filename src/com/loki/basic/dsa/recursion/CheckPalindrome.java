package com.loki.basic.dsa.recursion;

public class CheckPalindrome {
    public static void main(String[] args) {
        System.out.println(checkPalindrome("banana",0));
        System.out.println(checkPalindrome("madam",0));
    }

    private static boolean checkPalindrome(String str, int i) {
        if(i >= str.length()/2){
            return true;
        }
        if(str.charAt(i) != str.charAt(str.length()-i-1)){
            return false;
        }
        return checkPalindrome(str,i+1);
    }
}
