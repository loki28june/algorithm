package com.loki.crackingthecodeinterview.Ch01ArraysandStrings.Q1_07_rotate_image;

public class RotateImage {
    public static void rotateImage(int[][] image) {
        if (image.length == 0 || image.length != image[0].length) {
            return; // not a sqare
        }
        int n = image.length;
        int left = 0, right = n - 1;
        while (left < right) {
            for (int i = 0; i < right - left; i++) {
                int top = left, bottom = right;
                int topLeft = image[top][left + i]; // save the top left

                image[top][left + i] = image[bottom - i][left];
                image[bottom - i][left] = image[bottom][right - i];
                image[bottom][right - i] = image[top + i][right];
                image[top + i][right] = topLeft;
            }
            left++;
            right--;
        }

    }

    public static void main(String[] args) {
        int[][] n = {{1, 2, 3, 4}
                , {5, 6, 7, 8}
                , {9, 10, 11, 12}
                , {13, 14, 15, 16}};
        printArray(n);
        rotateImage(n);
        System.out.println();
        printArray(n);
    }

    private static void printArray(int[][] image) {
        int N = image.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
}
