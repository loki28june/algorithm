package com.loki.crackingthecodeinterview.Ch03StacksAndQueues.Q3_01_Three_in_One;

import com.loki.crackingthecodeinterview.Ch03StacksAndQueues.util.StackWithArray;

public class ThreeInOne {

    public static void main(String[] args) {
        int n = 9;
        StackWithArray stackOne = new StackWithArray(-1, 0, n / 3);
        StackWithArray stackTwo = new StackWithArray(n / 3 - 1, n / 3, 2 * n / 3);
        StackWithArray stackThree = new StackWithArray(2 * n / 3 - 1, 2 * n / 3, n);
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
    }
}
