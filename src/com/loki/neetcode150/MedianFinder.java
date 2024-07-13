package com.loki.neetcode150;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue();
        minHeap = new PriorityQueue();
    }

    public void addNum(int num) {
        maxHeap.add(num);
        if(Math.abs(maxHeap.size()-minHeap.size()) > 1){
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if((minHeap.size() + maxHeap.size())%2 == 0){
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        }
        return maxHeap.size() > minHeap.size()? (double)maxHeap.peek():(double)minHeap.peek();
    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(-1);
        finder.addNum(-2);
        finder.addNum(-3);
        System.out.println(finder.findMedian());
    }
}
