package com.loki.crackingthecodeinterview.Ch04TreesAndGraphs.Q4_01_Route_Between_Nodes;

import java.util.LinkedList;
import java.util.Queue;

public class Question {
    public enum State {
        VISITED, VISITING, UNVISITED
    }

    public static void main(String[] args) {
        Graph graph = createNewGraph();
        System.out.println(findRoute(graph, graph.vertices[3], graph.vertices[5]));
    }

    private static Graph createNewGraph() {
        Graph graph = new Graph();
        Node[] temp = new Node[6];

        temp[0] = new Node("a", 3);
        temp[1] = new Node("b", 0);
        temp[2] = new Node("c", 0);
        temp[3] = new Node("d", 1);
        temp[4] = new Node("e", 1);
        temp[5] = new Node("f", 0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);

        for (int i = 0; i < 6; i++) {
            graph.addNode(temp[i]);
        }
        return graph;
    }

    public static boolean findRoute(Graph g, Node start, Node end) {
        if (start == end) return true;
        Queue<Node> queue = new LinkedList<>();
        for (Node u : g.getVertices()) {
            u.state = State.UNVISITED;
        }
        start.state = State.VISITING;
        queue.add(start);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current != null) {
                for (Node child : current.getAdjacent()) {
                    if (child.state == State.UNVISITED) {
                        if (end == child) {
                            return true;
                        }
                        child.state = State.VISITING;
                        queue.add(child);
                    }
                }
                current.state = State.VISITED;
            }
        }
        return false;
    }
}
