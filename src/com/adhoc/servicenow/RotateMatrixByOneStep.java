/*
package com.adhoc.servicenow;

*/
/**
 * Input
 * 1    2    3
 * 4    5    6
 * 7    8    9
 * Output:
 * 4    1    2
 * 7    5    3
 * 8    9    6
 * Input:
 * 1    2    3    4
 * 5    6    7    8
 * 9    10   11   12
 * 13   14   15   16
 * Output:
 * 5    1    2    3
 * 9    10   6    4
 * 13   11   7    8
 * 14   15   16   12
 *//*

public class RotateMatrixByOneStep {
    public static void main(String[] args) {
        int[][] input1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] input2 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

    }

    private static void rotateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int layers = rows - 2;
        int startRowIndex = 0, startColIndex = 0, endRowIndex = rows - 1, endColIndex = cols - 1;
        for (int i = 0; i < layers; i++) {
            shiftElementsClockWise(matrix, startRowIndex++, startColIndex++, endRowIndex--, endColIndex--);
        }
    }

    private static void shiftElementsClockWise(int[][] matrix, int startRow, int startCol, int endRow, int endCol) {
        boolean moveRight = true, moveDown = false, moveLeft = false, moveUp = false;
        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                if (moveRight && i == startRow || j == startRow) {
                    int temp = matrix[i][j];
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        matrix[i][j] = matrix[i - 1][j - 1];
                    }
                    matrix[i + 1][j + 1] = temp;
                }
            }
        }
        moveRight = false;
        moveDown = true;
        startCol = endCol;
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                if(moveDown && )
            }
        }

    }
}
*/
