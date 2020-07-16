package com.loki.ctci.datastructures.Q1_05_one_edit_away;

public class OneEditAway {
    private static boolean isOneEditAway(String s1, String s2){
        if(Math.abs(s1.length() - s2.length()) > 1)
            return false;
        int[] table = new int[128];
        for (int i =0; i <s1.length(); i++){
            table[s1.charAt(i)]++;
        }
        for (int i =0; i <s2.length(); i++){
            table[s2.charAt(i)]--;
        }
        int countOneEdit =0;
        for (int i =0; i <128; i++){
            if(table[i] == 0) continue;
            if(Math.abs(table[i]) > 1){
                return false;
            }
            if(Math.abs(table[i]) == 1){
                countOneEdit ++;
                if(countOneEdit > 2) return false;
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
