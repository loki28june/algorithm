package com.loki.neetcode150;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {

    public static int networkDelayTime(int[][] times, int n, int k) {
        int[] distance = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        List<List<Pair<Integer,Integer>>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] time : times){
            adj.get(time[0]).add(new Pair<>(time[1],time[2]));
        }
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((a, b) -> a.getKey()-b.getKey());
        pq.add(new Pair<>(0,k));
        distance[k] = 0;
        while(!pq.isEmpty()){
            Pair<Integer,Integer> p = pq.poll();
            int dist = p.getKey();
            int node = p.getValue();
            for(Pair<Integer,Integer> neigbour : adj.get(node)){
                if(distance[neigbour.getKey()] > dist + neigbour.getValue()){
                    distance[neigbour.getKey()] = dist + neigbour.getValue();
                    pq.add(new Pair<>(dist + neigbour.getValue(),neigbour.getKey()));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(distance[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, distance[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        int n = 4,k=2;
        System.out.println(networkDelayTime(input,n,k));
    }
}
