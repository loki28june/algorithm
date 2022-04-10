package com.loki.crackingthecodeinterview.Ch01ArraysandStrings.Q1_01_IsUnique;

public class ProblemOneIsUnique {

    public static void main(String[] args) {
        String s1 = "bmofb";
        String s2 = "jkay";
        System.out.println(isUniqueCharsPresent(s1));
        System.out.println(isUniqueCharsPresent(s2));
    }

    private static boolean isUniqueCharsPresent(String str){
        if(str.length() > 128){
            return false;
        }
        boolean[] char_set = new boolean[128];
        for(int i=0;i<str.length();i++){
            int value = str.charAt(i);
            if(char_set[value]){  //Already found this char in String
                return false;
            }
            char_set[value]=true;
        }
        return true;
    }
}
