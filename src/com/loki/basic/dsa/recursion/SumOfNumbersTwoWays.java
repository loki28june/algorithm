package com.loki.basic.dsa.recursion;

public class SumOfNumbersTwoWays {
    public static void main(String[] args) {
        System.out.println(printSumFunctionalWay(10));
        System.out.println(printSumParameterWay(10, 0));
        System.out.println(factorial(4));
    }

    //functional recursion
    private static int printSumFunctionalWay(int n) {
        if (n < 1) {
            return 0;
        }
        return n + printSumFunctionalWay(n - 1);
    }

    // parameterized recursion
    private static int printSumParameterWay(int n, int sum) {
        if (n < 1) {
            return sum;
        }
        return printSumParameterWay(n - 1, sum + n);
    }

    private static int factorial(int n) {
        if(n < 1){
            return 1;
        }
        return n * factorial(n - 1);
    }
}
