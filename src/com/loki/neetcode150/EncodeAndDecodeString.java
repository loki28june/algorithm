package com.loki.neetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeString {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     * 4#leet4#code4#love3#you
     */
    public static List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j =i;
            while(str.charAt(j) !='#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            i = j+1+length;
            strs.add(str.substring(j+1,i));
        }
        return strs;
    }

    public static void main(String[] args) {
        String coded = encode(Arrays.asList("Le#et","Coding#","#Loves","Yo#u"));
        System.out.println(coded);
        System.out.println(decode(coded));

        String coded2= encode(Arrays.asList("lint","code","love","you"));
        System.out.println(coded2);
        System.out.println(decode(coded2));

    }
}
