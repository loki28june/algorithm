package com.loki.crackingthecodeinterview.Ch04TreesAndGraphs.Q4_01_Route_Between_Nodes;

import java.util.LinkedList;
import java.util.Queue;

public class Question {
    public static void main(String[] args) {
        Graph graph = populateGraph();
        System.out.println(findRoute(graph.nodes[0], graph.nodes[2]));
    }

    public static boolean findRoute(Node start, Node end) {
        if (start == end) return true;
        Queue<Node> queue = new LinkedList<>();
        start.visited = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            Node parent = queue.poll();
            if (parent != null) {
                parent.visited = true;
                for (Node child : parent.children) {
                    if (!child.visited) {
                        if (end == child) {
                            return true;
                        }
                        child.visited = true;
                        queue.add(child);
                    }
                }
            }
        }
        return false;
    }

    private static Graph populateGraph() {
        Graph graph = new Graph();
        Node A = new Node();
        A.name = "A";
        Node B = new Node();
        B.name = "B";
        Node C = new Node();
        C.name = "C";
        Node D = new Node();
        D.name = "D";
        Node E = new Node();
        E.name = "E";
        A.children = new Node[]{C};
        B.children = new Node[]{E};
        C.children = new Node[]{D};
        D.children = new Node[]{A};
        E.children = new Node[]{B};
        graph.nodes = new Node[]{A, B, C, D, E};
        return graph;
    }
}
