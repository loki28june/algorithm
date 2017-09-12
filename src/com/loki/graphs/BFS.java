package com.loki.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

	private int V; // no of vertices
	private LinkedList<Integer> adj[];

	public void bfs(int s){
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[V];
		visited[s] = true;	
		q.add(s);
		

		while(!q.isEmpty()){
			int t = q.poll();
			System.out.println("node is=> "+t);
			// finding neighbours of this vertex
			Iterator<Integer> itr = adj[t].iterator();
			while(itr.hasNext()){
				int i = itr.next();
				if(!visited[i]){
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}

	public BFS(int v){
		this.V = v;
		adj = new LinkedList[v];
		for(int i = 0 ; i < v; i++){
			adj[i] = new LinkedList<>();
		}
	}

	public void makeEdge(int v, int w){
		adj[v].add(w);
	}


	public static void main(String[] args) {
		BFS bf = new BFS(4);
		 bf.makeEdge(0, 1);
	        bf.makeEdge(0, 2);
	        bf.makeEdge(1, 2);
	        bf.makeEdge(2, 0);
	        bf.makeEdge(2, 3);
	        bf.makeEdge(3, 3);
		
		bf.bfs(2);

	}

}
