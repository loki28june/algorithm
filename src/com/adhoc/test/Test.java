package com.adhoc.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {

    private static final int[] arr = { 1, 3, 2, 3, 4, 1};
    public static void main(String[] args) {
        StringBuilder firstString = new StringBuilder();
        StringBuilder secondString = new StringBuilder();
        Set<Integer> seenForFirst = new HashSet<>();
        for (int num : arr) {
            if (seenForFirst.contains(num)) {
                firstString.append(1);
            } else {
                seenForFirst.add(num);
                firstString.append(0);
            }
        }

        Set<Integer> seenForSecond = new HashSet<>();
        for (int i = arr.length-1; i >= 0; i--) {
            if(seenForSecond.contains(arr[i])) {
                secondString.append(1);
            }
            else{
                seenForSecond.add(arr[i]);
                secondString.append(0);
            }
        }

        System.out.println(firstString);
        System.out.println(secondString.reverse());
    }
}

