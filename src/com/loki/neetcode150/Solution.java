package com.loki.neetcode150;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n=grid[0].length;
        Queue<Pair<Integer,Pair<Integer,Integer>>> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0){
                    q.add(new Pair(0,new Pair(i,j)));
                }
            }
        }
        int[] rowD = {-1,0,1,0}, colD= {0,1,0,-1};
        while(!q.isEmpty()){
            Pair<Integer,Pair<Integer,Integer>> node = q.poll();
            int count = node.getKey();
            int row = node.getValue().getKey();
            int col = node.getValue().getValue();
            grid[row][col] = count;
            for(int i=0;i<4;i++){
                int r = row + rowD[i], c = col + colD[i];
                if(r>=0 && r<m && c>=0 && c<n && grid[r][c] != -1){
                    q.add(new Pair(count + 1,new Pair(r,c)));
                }
            }
        }
    }
//    private class Pair<T,V>{
//        T key;
//        V value;
//        Pair(T key,V value){
//            this.key=key;
//            this.value = value;
//        }
//        public T getKey(){
//            return key;
//        }
//        public V getValue(){
//            return value;
//        }
//    }
}


