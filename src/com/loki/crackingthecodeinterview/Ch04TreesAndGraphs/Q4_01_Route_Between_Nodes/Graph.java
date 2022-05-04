package com.loki.crackingthecodeinterview.Ch04TreesAndGraphs.Q4_01_Route_Between_Nodes;

public class Graph {
    public final int MAX_VERTICES = 6;
    public Node[] vertices;
    public int count;
    public Graph() {
        this.vertices = new Node[MAX_VERTICES];
        this.count = 0;
    }

    public Node[] getVertices() {
        return vertices;
    }

    public void addNode(Node node) {
        if (count < vertices.length) {
            vertices[count] = node;
            count++;
        } else {
            System.out.println("Graph is full");
        }
    }
}
