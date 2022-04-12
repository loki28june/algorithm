package com.loki.crackingthecodeinterview.Ch01ArraysandStrings.Q1_03_URLify;

public class URLify {
    private static String getUrlify(char[] charArray, int trueLength) {
        int numberOfSpaces = 0;
        for (int i = 0; i < trueLength; i++) {
            if (charArray[i] == ' ') {
                numberOfSpaces++;
            }
        }
        int index = trueLength + numberOfSpaces * 2;
        if(index < charArray.length){
            charArray[index] = '\0'; // ending array in case of access spaces.
        }
        for (int i = trueLength - 1; i >= 0; i--) {
            if (charArray[i] == ' ') {
                charArray[index - 1] = '0';
                charArray[index - 2] = '2';
                charArray[index - 3] = '%';
                index = index - 3;
            } else {
                charArray[index - 1] = charArray[i];
                index--;
            }
        }
        return new String(charArray);
    }

    private static int findLastCharacter(char[] chars){
        for(int i=chars.length-1;i>=0;i--){
            if(chars[i] != ' '){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "Mr John Smith    ";
        char[] charArray = s.toCharArray();
        System.out.print(getUrlify(charArray, findLastCharacter(charArray) + 1));
    }
}
