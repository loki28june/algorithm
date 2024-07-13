package com.loki.neetcode150;

import java.util.*;

public class EventualSafeNodes {
    static List<Integer> result = new ArrayList<>();

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        if (graph.length == 0) return Collections.emptyList();
        if (graph.length == 1) return Collections.singletonList(0);
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
            int[] nodes = graph[i];
            for (int v : nodes) {
                adj.get(i).add(v);
                indegree[v]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int v = 0; v < graph.length; v++) {
            if (indegree[v] == 0) {
                q.add(v);
                result.add(v);
            }
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int v : adj.get(node)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    result.add(v);
                    q.add(v);
                }
            }
        }
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        //int[][] graph = {{1,2}, {2,3}, {5},{0},{5},{},{}};
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK","SFO"));
        tickets.add(Arrays.asList("JFK","ATL"));
        tickets.add(Arrays.asList("SFO","ATL"));
        tickets.add(Arrays.asList("ATL","JFK"));
        tickets.add(Arrays.asList("ATL","SFO"));
        printListOfLists(tickets);
        tickets.sort((a, b) -> {
            if (!a.get(0).equals(b.get(0))) return a.get(0).compareTo(b.get(0));
            return a.get(1).compareTo(b.get(1));
        });
        printListOfLists(tickets);
    }

    private static void printListOfLists(List<List<String>> listOfLists) {
        System.out.println("\n           List of Lists          ");
        System.out.println("-------------------------------------");
        listOfLists.forEach(innerList -> {
            String line = String.join(", ", innerList);
            System.out.println(line);
        });
    }
}
