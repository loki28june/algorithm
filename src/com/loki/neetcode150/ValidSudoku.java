package com.loki.neetcode150;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (rowSet.contains(board[i][j])) {
                    return false;
                } else {
                    rowSet.add(board[i][j]);
                }
                if (board[j][i] == '.') {
                    continue;
                }
                if (colSet.contains(board[j][i])) {
                    return false;
                } else {
                    colSet.add(board[j][i]);
                }
            }
        }
        // Check repeat in square blocks
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j+ 3 ) {
                if(!checkBlock(i, j, board)){
                    return true;
                }
            }
        }
        return true;
    }

    private static boolean checkBlock(int idxI, int idxJ, char[][] board) {
        int rows = idxI + 3, columns = idxJ + 3;
        Set<Character> blockSet = new HashSet<>();
        for (int i = idxI; i < rows; i++) {
            for (int j = idxJ; j < columns; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (blockSet.contains(board[i][j])) {
                    return false;
                } else {
                    blockSet.add(board[i][j]);
                }
            }
        }
        return true;
    }
}
