package com.loki.crackingthecodeinterview.Ch04TreesAndGraphs.Q4_01_Route_Between_Nodes;

import com.loki.crackingthecodeinterview.Ch04TreesAndGraphs.Q4_01_Route_Between_Nodes.Question.State;

public class Node {
    private Node[] adjacent;
    public String vertex;
    public State state;
    public int adjacentCount;

    public Node(String vertex, int adjacentLength) {
        this.vertex = vertex;
        this.adjacentCount = 0;
        this.adjacent = new Node[adjacentLength];
    }

    public Node[] getAdjacent() {
        return adjacent;
    }

    public void addAdjacent(Node node) {
        if (adjacentCount < adjacent.length) {
            this.adjacent[adjacentCount] = node;
            adjacentCount++;
        } else {
            System.out.println("No More adjacent can be added");
        }
    }
}
