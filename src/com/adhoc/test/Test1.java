package com.adhoc.test;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(minCost(2,new int[]{0,1,0,1,1}, new int[]{4,74,47,744,7}));
    }

    private static int minCost(int numProjects, int[] projectIds, int[] bid) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numProjects; i++) {
            map.put(i, Integer.MAX_VALUE);
        }
        for (int i = 0; i < projectIds.length; i++) {
            int projectId = projectIds[i];
            int currentBid = bid[i];
            if (map.containsKey(projectId) && map.get(projectId) > currentBid) {
                map.put(projectId, currentBid);
            }
            else if(!map.containsKey(projectId)) {
                map.put(projectId, currentBid);
            }
        }
        for (int i = 0; i < numProjects; i++) {
            if(map.containsKey(i) && map.get(i) == Integer.MAX_VALUE) {
                map.put(i,-1);
            }
        }
        return map.values().stream().mapToInt(Integer::intValue).sum();
    }
}
