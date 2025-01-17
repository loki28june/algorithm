package com.loki.basic.dsa.recursion;

import java.util.ArrayList;

public class PrintSubsequence {
    public static void main(String[] args) {
        String[] arr = { "a","b","c" };
        printSubsequence(arr, 0,new ArrayList<>());
    }

    private static void printSubsequence(String[] arr, int index, ArrayList<String> selections) {
        if(index == arr.length){
            selections.forEach(System.out::print);
            System.out.println();
            return;
        }
        selections.add(arr[index]); // pick
        printSubsequence(arr, index + 1, selections);
        selections.remove(selections.size() -1); // non-pick
        printSubsequence(arr, index + 1, selections);
    }
}
