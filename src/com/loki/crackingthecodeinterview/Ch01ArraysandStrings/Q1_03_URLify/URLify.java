package com.loki.crackingthecodeinterview.Ch01ArraysandStrings.Q1_03_URLify;

public class URLify {
    private static String getUrlify(String s, int truelength){
        char[] content = s.toCharArray();
        int countSpace = 0;
        for(int i =0; i< truelength; i++){
            if(content[i] == ' '){
                countSpace++;
            }
        }
        int index = truelength + 2 * countSpace;
        for (int i = truelength -1 ; i > 0 ; i--){
            if(content[i] != ' '){
                content[index - 1] = content[i];
                index = index -1;
            }
            else{
                content[index -1 ] = '0';
                content[index - 2] = '2';
                content[index - 3] = '%';
                index = index - 3;
            }
        }
        return new String(content);
    }

    public static void main(String[] args){
        String s = "Mr John Smith    ";
        System.out.print(getUrlify(s,13));
    }
}
