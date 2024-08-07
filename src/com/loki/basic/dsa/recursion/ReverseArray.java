package com.loki.basic.dsa.recursion;


public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverseArray(arr, 0, arr.length - 1);
        printArray(arr);
        reverseArraySecondWay(arr, 0);
        System.out.println();
        printArray(arr);
    }

    private static void reverseArray(int[] arr, int i, int j) {
        if (i >= j) {
            return;
        }
        swap(arr, i, j);
        reverseArray(arr, i + 1, j - 1);
    }

    private static void reverseArraySecondWay(int[] arr, int i) {
        if (i >= arr.length / 2) {
            return;
        }
        swap(arr, i, arr.length - i - 1);
        reverseArraySecondWay(arr, i + 1);
    }

    private static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
