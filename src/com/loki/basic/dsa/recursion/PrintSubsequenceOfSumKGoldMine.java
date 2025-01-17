package com.loki.basic.dsa.recursion;

import java.util.List;

public class PrintSubsequenceOfSumKGoldMine {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        System.out.println(printCountOfSubsequenceOfGivenSum(arr, 0, 0, 3));
    }

    /**
     * Printing all subsequences of given Sum
     */
    private static void printSubsequence(int[] arr, int index, List<Integer> select, int sum, int targetSum) {
        if (index == arr.length) {
            if (sum == targetSum) {
                select.forEach(System.out::print);
                System.out.println();
            }
            return;
        }
        select.add(arr[index]); // pick
        printSubsequence(arr, index + 1, select, sum + arr[index], targetSum);
        select.remove(select.size() - 1); // non-pick
        printSubsequence(arr, index + 1, select, sum, targetSum);
    }

    /**
     * Printing only one subsequence of given Sum
     */
    private static boolean printOnlyOneSubsequence(int[] arr, int index, List<Integer> select, int sum, int targetSum) {
        if (index == arr.length) {
            if (sum == targetSum) {
                select.forEach(System.out::print);
                System.out.println();
                return true; // base case
            }
            return false;
        }
        select.add(arr[index]); // pick
        if (printOnlyOneSubsequence(arr, index + 1, select, sum + arr[index], targetSum)) {
            return true;
        }
        select.remove(select.size() - 1); // non-pick
        return printOnlyOneSubsequence(arr, index + 1, select, sum, targetSum);
    }

    /**
     * Printing count of all subsequences of given Sum
     * We remove output arraylist passed as an arg in other 2 methods because
     * we don't have to print or return the subsequences.
     */
    private static int printCountOfSubsequenceOfGivenSum(int[] arr, int index, int sum, int targetSum) {
        if (index == arr.length) {
            if (sum == targetSum) {
                return 1; // base case
            }
            return 0;
        }
        int left = printCountOfSubsequenceOfGivenSum(arr, index + 1, sum + arr[index], targetSum);
        int right = printCountOfSubsequenceOfGivenSum(arr, index + 1, sum, targetSum);
        return left + right; // remember this pattern
    }
}
