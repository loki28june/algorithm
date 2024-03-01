package com.loki.neetcode150;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] temp = new int[26];
        for(int i=0;i<s.length();i++){
            temp[s.charAt(i)-'a']++;
        }
        for(int j=0;j<s.length();j++){
            temp[s.charAt(j)-'a']--;
        }
        for(int k=0;k<temp.length;k++){
            if(temp[k]!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram("rat", "car"));
    }
}
