package com.loki.techinterviews;

public class SecondMaximum {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 5, 6, 7, 8, 1, 10,9};
        int max2 = getMax2(arr);
        System.out.println(max2);
    }

    private static int getMax2(int[] arr) {
        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int value : arr) {
            if (value > firstMax) {
                secondMax = firstMax;
                firstMax = value;
            }
            else if (value > secondMax) {
                secondMax = value;
            }
        }
        return secondMax;
    }
}
