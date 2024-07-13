package com.loki.neetcode150;

import javafx.util.Pair;

public class NoOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (m == 1 && n == 1) return grid[0][0] == 1 ? 1 : 0;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, new Pair<>(i, j));
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, Pair<Integer, Integer> node) {
        if (grid[node.getKey()][node.getValue()] == '0') {
            return;
        }
        int m = grid.length, n = grid[0].length;
        int row = node.getKey();
        int column = node.getValue();
        visited[row][column] = true;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == j || i + j == 0) continue;
                int r = row + i;
                int c = column + j;
                if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c] && grid[r][c] == '1') {
                    dfs(grid, visited, new Pair<>(r, c));
                }
            }
        }
    }
}
