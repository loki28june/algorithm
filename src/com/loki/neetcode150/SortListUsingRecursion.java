package com.loki.neetcode150;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SortListUsingRecursion {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>(Arrays.asList(6, 5, 4, 3, 2, 1));
        sort(list);
        System.out.println(list);
    }

    private static void sort(List<Integer> list) {
        if (list.size() == 1) {
            return;
        }
        int lastElement = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        sort(list); // hypothesis 1
        //induction 1
        insert(list, lastElement);
    }

    private static void insert(List<Integer> list, int lastElement) {
        if (list.isEmpty() || list.get(list.size() - 1) <= lastElement) {
            list.add(lastElement); // BC 2
            return;
        }
        int lastElement2 = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        insert(list, lastElement); // hypothesis 2
        list.add(lastElement2); // induction 2
    }
}
