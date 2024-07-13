package com.loki.basic.dsa.recursion;

public class BasicRecursionBacktracking {
    public static void main(String[] args) {
        printNameNTimes( 5);
        System.out.println();
        printLinearlyOneToN(10, 1);
        System.out.println();
        printLinearlyNToOne(10);
        System.out.println();
        printLinearlyOneToNBackTracking(10);
        System.out.println();
        printLinearlyNToOneBackTracking(10, 1);
    }

    private static void printLinearlyNToOneBackTracking(int n, int i) {
        if (i > n) {
            return;
        }
        printLinearlyNToOneBackTracking(n, i + 1);
        System.out.print(i + " ");
    }

    private static void printLinearlyOneToNBackTracking(int n) {
        if (n < 1) {
            return;
        }
        printLinearlyOneToNBackTracking(n - 1);
        System.out.print(n + " ");
    }

    private static void printLinearlyNToOne(int n) {
        if (n < 1) {
            return;
        }
        System.out.print(n + " ");
        printLinearlyNToOne(n - 1);
    }

    private static void printLinearlyOneToN(int n, int i) {
        if (i > n) {
            return;
        }
        System.out.print(i + " ");
        printLinearlyOneToN(n, i + 1);
    }

    private static void printNameNTimes(int n) {
        if (n < 1) {
            return;
        }
        System.out.print("Lokesh" + " ");
        printNameNTimes(n - 1);
    }
}