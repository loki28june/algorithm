package com.loki.techinterviews;

public class ServiceNow2ndRound {
    // Question 1 : Ternary Search
    // Question 2 Print Excel Column Count
    public static void main(String[] args) {
        System.out.println(countExcelColumnNumberV2("CDA"));
    }

    private static int countExcelColumnNumberV2(String input) { // ABC
        int length = input.length();
        int count = 0, indexMultiplier = 1;
        for (int i = length - 1; i >= 0; i--) {
            int index = input.charAt(i) - 'A';
            count = count + ((index + 1) * indexMultiplier);
            indexMultiplier = indexMultiplier * 26;
        }
        return count;
    }

    private static int ternarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 3;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
