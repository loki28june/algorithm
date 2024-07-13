package com.loki.neetcode150;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2 {
    TrieNode root = new TrieNode();
    List<String> output = new ArrayList<>();
    int ROWS, COLS;

    public List<String> findWords(char[][] board, String[] words) {
        // DFS + Backtracking on Board + Trie to Store the words to search
        for (String str : words) {
            addWord(str); // inserting all the words to Trie
        }
        ROWS = board.length;
        COLS = board[0].length;
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                dfs(i, j, board, "", root, visited);
            }
        }
        return output;
    }

    private void dfs(int i, int j, char[][] board, String currentWord, TrieNode node, Set<String> visited) {
        if (i < 0 || j < 0 || i == ROWS || j == COLS || visited.contains(i + "_" + j) || !node.contains(board[i][j])) {
            return; // base case
        }
        visited.add(i + "_" + j);
        currentWord += board[i][j];
        node = node.get(board[i][j]);
        if (node.isWord) {
            node.isWord = false;
            output.add(currentWord);
        }
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                if (r == c || r + c == 0) continue; // skipping diagonal directions
                dfs(i + r, j + c, board, currentWord, node, visited); //recursively call for neighbours
            }
        }
        visited.remove(i + "_" + j);

    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (!curr.contains(ch)) {
                curr.add(ch);
            }
            curr = curr.get(ch);
        }
        curr.isWord = true;
    }

    private static class TrieNode {
        TrieNode[] links = new TrieNode[26];
        boolean isWord = false;

        public boolean contains(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void add(char ch) {
            if (links[ch - 'a'] == null) {
                links[ch - 'a'] = new TrieNode();
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'},};
        String[] words = {"oath", "pea", "eat", "rain"};
        String[] words2 = {"oath", "pea", "eat", "rain", "hklf", "hf"};
        WordSearch2 wordSearch2 = new WordSearch2();
        List<String> ans2 = wordSearch2.findWords(board, words);
        ans2.forEach(a -> System.out.print(a + " "));
        System.out.println();
        List<String> ans = wordSearch2.findWords(board, words2);
        ans.forEach(a -> System.out.print(a + " "));
        // Output ["oath","eat","hklf","hklff"]
        // Expected ["oath","eat","hklf","hf"]
    }
}
