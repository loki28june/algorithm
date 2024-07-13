package com.loki.neetcode150;

public class WordDictionary {
    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i));
            }
            node = node.get(word.charAt(i));
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(root, 0, word);
    }

    private boolean searchHelper(Node curr, int index, String word) {
        Node node = curr;
        for (int i = index; i < word.length(); i++) {
            if (word.charAt(i) != '.' && !node.containsKey(word.charAt(i))) {
                return false;
            }
            if (word.charAt(i) != '.') {
                node = node.get(word.charAt(i));
                continue;
            }
            for (Node temp : node.links) {
                if (temp != null && searchHelper(temp, i + 1, word)) {
                    return true;
                }
            }
            return false;
        }
        return node.isWord;
    }

    private class Node {
        private Node[] links = new Node[26];
        boolean isWord = false;

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public Node get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch) {
            links[ch - 'a'] = new Node();
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("b.."));
//        System.out.println(wordDictionary.search("pad"));
//        System.out.println(wordDictionary.search("bad"));
//        System.out.println(wordDictionary.search(".ad"));
    }


}
