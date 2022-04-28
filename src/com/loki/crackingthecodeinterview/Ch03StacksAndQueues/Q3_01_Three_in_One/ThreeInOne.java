package com.loki.crackingthecodeinterview.Ch03StacksAndQueues.Q3_01_Three_in_One;

import com.loki.crackingthecodeinterview.Ch03StacksAndQueues.util.StackWithArray;

public class ThreeInOne {

    public static void main(String[] args) {
        int n = 9;
        int[] array = new int[n];
        StackWithArray stackOne = new StackWithArray(array, 0, n / 3);
        StackWithArray stackTwo = new StackWithArray(array, n / 3, 2 * n / 3);
        StackWithArray stackThree = new StackWithArray(array, 2 * n / 3, n);
        stackOne.push(9);
        stackOne.push(8);
        stackOne.push(7);
        stackOne.pop();

        stackTwo.push(6);
        stackTwo.push(5);
        stackTwo.push(4);
        stackTwo.pop();

        stackThree.push(3);
        stackThree.push(2);
        stackThree.push(1);
        stackThree.pop();

        stackOne.print();
        stackTwo.print();
        stackThree.print();
        for (int i:array) {
            System.out.print(" "+i);
        }
    }
}
