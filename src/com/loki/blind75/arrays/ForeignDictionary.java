package com.loki.blind75.arrays;

import java.util.*;

public class ForeignDictionary {
    public String foreignDictionary(String[] words) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int v = 0; v <26; v++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }
        int[] ans = topoSort(adj);
        StringBuilder str = new StringBuilder();
        for (int a : ans) {
            if(a == -1) continue;
            str.append((char) (a + (int) ('a')));
        }
        return str.toString();
    }

    private int[] topoSort(List<List<Integer>> adj) {
        int[] result = new int[26];
        Arrays.fill(result,-1);
        int[] indegree = new int[26];
        for (List<Integer> list : adj) {
            for (int k : list) {
                indegree[k]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int counter=0;
        while (!q.isEmpty()) {
            int node = q.poll();
            result[counter++] = node;
            List<Integer> neighbours = adj.get(node);
            for (int n : neighbours) {
                indegree[n]--;
                if (indegree[n] == 0) {
                    q.offer(n);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        ForeignDictionary foreignDictionary = new ForeignDictionary();
        System.out.println(foreignDictionary.foreignDictionary(new String[]{"hrn","hrf","er","enn","rfnn"}));
    }
}
