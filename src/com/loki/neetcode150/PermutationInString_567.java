package com.loki.neetcode150;

public class PermutationInString_567 {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Arr = new int[26];
        for(int i=0;i<s1.length();i++){
            s1Arr[s1.charAt(i) - 'a']++;
        }
        int start=0;
        int[] temp = new int[26];
        for(int end=0;end<s2.length();end++){
            while(end - start + 1 > s1.length()){
                if(bothArrayMatches(s1Arr,temp)){
                    return true;
                }
                temp[s2.charAt(start) - 'a']--;
                start++;
            }
            temp[s2.charAt(end) - 'a']++;
        }
        return false;
    }

    private boolean bothArrayMatches(int[] a1, int[] a2){
        for(int i=0;i<26;i++){
            if(a1[i] != a2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PermutationInString_567 p = new PermutationInString_567();
        System.out.println(p.checkInclusion("adc","dcda"));
    }

}
