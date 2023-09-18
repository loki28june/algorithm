package com.loki.blind75.arrays;

import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int currentDay=0;currentDay<temperatures.length;currentDay++){
            while(!stack.isEmpty()
                    && temperatures[currentDay] > temperatures[stack.peek()]){
                int prevDay = stack.pop();
                answer[prevDay] = currentDay-prevDay;
            }
            stack.push(currentDay);
        }
        return answer;

    }
}
