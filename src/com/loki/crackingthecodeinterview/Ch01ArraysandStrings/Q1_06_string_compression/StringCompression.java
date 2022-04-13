package com.loki.crackingthecodeinterview.Ch01ArraysandStrings.Q1_06_string_compression;

public class StringCompression {

    private static String getCompressedString(String originalString) {
        char currentChar = ' ', nextChar=' ';
        int currentCharCount = 1;
        StringBuilder compressed = new StringBuilder();
        for (int i = 0; i < originalString.length() - 1; i++) {
            currentChar = originalString.charAt(i);
            nextChar = originalString.charAt(i + 1);
            if (nextChar == currentChar) {
                currentCharCount++;
            } else {
                compressed.append(currentChar).append(currentCharCount);
                currentCharCount = 1;
            }
        }
        if (nextChar == currentChar) {
            compressed.append(currentChar).append(currentCharCount);
        }
        return compressed.toString().length() < originalString.length() ? compressed.toString():originalString;
    }

    public static void main(String[] args) {
        System.out.println(getCompressedString("aabcccccaaa"));
    }

}
