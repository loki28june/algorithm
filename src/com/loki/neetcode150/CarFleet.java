package com.loki.neetcode150;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length == 1 && position.length==speed.length) return 1;
        Stack<Node> stack = new Stack<>();
        List<Node> nodes = new ArrayList<>();
        for(int i=0;i<position.length;i++){
            Node n = new Node(position[i],speed[i]);
            nodes.add(n);
        }
        nodes.sort((a, b) -> b.getPosition() - a.getPosition());
        for(Node node : nodes){
            stack.push(node);
            if(stack.size() >= 2){
                Node second = stack.pop();
                Node first = stack.pop();
                double time2 = (double) (target - second.getPosition()) /second.getSpeed();
                double time1 = (double) (target - first.getPosition()) /first.getSpeed();
                if(time2 <= time1){
                    stack.push(first);
                }
                else{
                    stack.push(first);
                    stack.push(second);
                }
            }
        }
        return stack.size();
    }

    static class Node{
        private int position;
        private int speed;
        public Node(int position,int speed){
            this.position = position;
            this.speed = speed;
        }
        public int getPosition(){
            return position;
        }
        public int getSpeed(){
            return speed;
        }
    }
}
