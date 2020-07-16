package com.loki.ctci.datastructures.Q1_06_string_compression;

public class StringCompression {

    private static String getCompressedString(String originalString){
        int prev = 0, countChar = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < originalString.length();i++){
            if(originalString.charAt(i) == originalString.charAt(prev)){
                countChar++;
            }
            else {
                sb.append(originalString.charAt(prev));
                sb.append(countChar);
                countChar = 1;
            }
            prev++;
        }
        sb.append(originalString.charAt(originalString.length() - 1));
        sb.append(countChar);
        String compressedString = sb.toString();
        if(compressedString.length() > originalString.length()){
            return originalString;
        }
        return compressedString;
    }

    public static void main(String[] args){
        System.out.println(getCompressedString("aabcccccaaa"));
    }

}
