package com.loki.basic.dsa.recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(findFibonacci(4));
        // 0,1,1,2,3
    }

    private static int findFibonacci(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        return findFibonacci(n-1) + findFibonacci(n-2);
    }
}
