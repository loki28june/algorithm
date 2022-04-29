package com.loki.crackingthecodeinterview.Ch03StacksAndQueues.Q3_03_Stack_of_Plates;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetOfStacks {
    private List<Stack> stacks = new ArrayList<>();
    private final int threshold = 3;

    public void push(int data) {
        if (stacks.size() == 0) {
            Stack<Integer> stack = new Stack<>();
            stack.push(data);
            stacks.add(stack);
            return;
        }
        Stack<Integer> stack = stacks.get(stacks.size() - 1);
        if (stack.size() < threshold) {
            stack.push(data);
            return;
        }
        Stack<Integer> newStack = new Stack<>();
        newStack.push(data);
        stacks.add(newStack);
    }

    public int pop() {
        if (stacks.isEmpty()) {
            System.out.println("Underflow Condition");
        }
        Stack<Integer> lastStack = stacks.get(stacks.size() - 1);
        int popped = lastStack.pop();
        if (lastStack.empty()) {
            stacks.remove(lastStack);
        }
        return popped;
    }

    public int popAt(int index) {
        Stack stackAtIndex = stacks.get(index - 1);
        int popped = (int) stackAtIndex.pop();
        if (stackAtIndex.empty()) {
            stacks.remove(stackAtIndex);
        }
        return popped;
    }

    public void printValues() {
        for (Stack s : stacks) {
            s.stream().forEach(i -> System.out.println(i));
        }
    }

    public static void main(String[] args) {
        SetOfStacks setOfStacks = new SetOfStacks();
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);
        setOfStacks.push(6);
        setOfStacks.pop();
        setOfStacks.pop();
        setOfStacks.popAt(1);
        setOfStacks.printValues();

    }
}
