package com.loki.crackingthecodeinterview.Ch01ArraysandStrings.Q1_09_String_Rotation;

public class StringRotation {
    public static void main(String[] args) {
        String s1 = "erbottlewat";
        String s2 = "waterbottle";
        System.out.println(isRotation(s1, s2));
    }

    private static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length() || s1.length() == 0) {
            return false;
        }
        String s1s1 = s1 + s1;
        return isSubstring(s1s1, s2);
    }

    public static boolean isSubstring(String big, String small) {
        if (big.indexOf(small) >= 0) {
            return true;
        } else {
            return false;
        }
    }
}


