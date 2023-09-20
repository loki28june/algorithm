package com.loki.blind75.arrays;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
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

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));

    }
}
