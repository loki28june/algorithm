package com.loki.crackingthecodeinterview.Ch01ArraysandStrings.Q1_05_one_edit_away;

public class OneEditAway {
    private static boolean isOneEditAway(String s1, String s2){
       if(Math.abs(s1.length() - s2.length()) >1){
           return false;
       }
       int[] letters = new int[128]; // Assumed Ascii
        for(char c : s1.toCharArray()){
            letters[c]++;
        }
        for(char c : s2.toCharArray()){
            letters[c]--;
        }
        int editCount=0;
        for(int count : letters){
            if(editCount > 1){
                return false;
            }
            if(count > 0){
                editCount++;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String[][] pairs = {{"pale", "ple"}, {"pales","pale"}, {"pale","bale"},{"bake","fale"}};
        for(int i =0; i< pairs.length; i++){
            System.out.println(isOneEditAway(pairs[i][0] , pairs[i][1]));
        }
    }
}
