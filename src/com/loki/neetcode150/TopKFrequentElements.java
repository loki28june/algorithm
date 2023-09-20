package com.loki.neetcode150;

import java.util.*;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<List<Integer>> store = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            store.add(new ArrayList<>());
        }
        List<Integer> result = new ArrayList<>();
        populateFrequencyMap(nums, freqMap);
        StoreFreqAsIndexAndValueAsListValue(freqMap, store);
        int len = nums.length;
        while (k > 0 && len > 0) {
            if (!store.get(len - 1).isEmpty()) {
                List<Integer> values = store.get(len - 1);
                for (int no : values) {
                    result.add(no);
                    k--;
                }
            }
            len--;
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private static void StoreFreqAsIndexAndValueAsListValue(Map<Integer, Integer> freqMap, List<List<Integer>> store) {
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            store.get(entry.getValue() - 1).add(entry.getKey());
        }
    }

    private static void populateFrequencyMap(int[] nums, Map<Integer, Integer> freqMap) {
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 2}, 2)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{4, 4, 4, 2, 2, 2, 3, 3, 4, 4}, 2)));

    }
}
