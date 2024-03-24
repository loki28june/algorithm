package com.loki.neetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStringV2 {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append("#").append(s.length()).append(s);
        }
        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    public static List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i + 1;
            while (Character.isDigit(str.charAt(j))) {
                j++;
            }
            int length = Integer.parseInt(str.substring(i + 1, j));
            ans.add(str.substring(j, j + length));
            i = j + length;
        }
        return ans;
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
