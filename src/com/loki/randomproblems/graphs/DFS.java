package com.loki.randomproblems.graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
	int V;
	LinkedList<Integer>[] adj;
	
	DFS(int v){
		this.V = v;
		adj = new LinkedList[V];
		for(int i = 0; i < v; i++ ){
			adj[i] = new LinkedList<>();
		}
	}
	
	public void makeEdge(int v, int w){
		adj[v].add(w);
	}
	
	public void makeEdgeVersion2(int v, int w){
		adj[v - 1].add(w - 1);
	}
	
	public void dfs(int s){
		//Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[V];
		//visited[s] = true;	
		DFSUtil(visited, s);
	
	}
	
	public int countMinFriends(int s){
		//Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[V];
		//visited[s] = true;	
		DFSUtilMinFriends(visited, s);
	
		return 0;
	}
	
	public void DFSUtil(boolean[] visited, int s){
		visited[s] = true;
		System.out.println("data is=>"+s);
		
		Iterator<Integer> it = adj[s].listIterator();
		while(it.hasNext()){
		int t = it.next();
		
		if(!visited[t])
		DFSUtil(visited, t);
			
		}
		
	}
	
	public void DFSUtilMinFriends(boolean[] visited, int s){
		int count = 0;
		visited[s-1] = true;
		System.out.println("data is=>"+s);
		
		Iterator<Integer> it = adj[s].listIterator();
		while(it.hasNext()){
		int t = it.next();
		
		if(!visited[t]){
			visited[t-1] = true;
			DFSUtilMinFriends(visited, t);
		}
		else{
			
		}
			
		}
		
	}



	public static void main(String[] args) {
		DFS df = new DFS(4);
		 df.makeEdge(0, 1);
	        df.makeEdge(0, 2);
	        df.makeEdge(1, 2);
	        df.makeEdge(2, 0);
	        df.makeEdge(2, 3);
	        df.makeEdge(3, 3);
		
		df.dfs(2);

	}

}
