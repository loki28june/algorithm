package com.loki.crackingthecodeinterview.Ch04TreesAndGraphs.Q4_06_OrderBuilder;

import java.util.Stack;

public class OrderBuilder {
    public static void main(String[] args) {
        Project[] projects = new Project[6];
        projects[0] = new Project("a", 3);
        projects[1] = new Project("b", 3);
        projects[2] = new Project("c", 3);
        projects[3] = new Project("d", 3);
        projects[4] = new Project("e", 3);
        projects[5] = new Project("f", 3);
        Project[][] dependencies = {{projects[0], projects[3]},
                {projects[5], projects[1]},
                {projects[1], projects[3]},
                {projects[5], projects[0]},
                {projects[3], projects[2]}};
        OrderBuilder orderBuilder = new OrderBuilder();
        Project[] projects1 = orderBuilder.buildGraph(projects, dependencies);
        Stack<Project> stack = orderBuilder.orderProjects(projects1);
        printStack(stack);
    }

    public Project[] buildGraph(Project[] projects, Project[][] dependencies) {
        for (Project[] pair : dependencies) {
            pair[0].makeEdge(pair[1]);
        }
        return projects;
    }

    public Stack<Project> orderProjects(Project[] projects) {
        Stack<Project> stack = new Stack<>();
        for (Project project : projects) {
            if (project.getState() == Project.State.BLANK) {
                if (!doDFS(project, stack)) {
                    return null;
                }
            }
        }
        return stack;
    }

    private boolean doDFS(Project project, Stack stack) {
        if (project.getState() == Project.State.PARTIAL) {
            return false; //cycle
        }

        if (project.getState() == Project.State.BLANK) {
            project.setState(Project.State.PARTIAL);
            for (Project child : project.getChildren()) {
                if (child != null) {
                    if (!doDFS(child, stack)) {
                        return false;
                    }
                }
            }
            project.setState(Project.State.COMPLETED);
            stack.push(project);
        }
        return true;
    }

    private static void printStack(Stack<Project> stack) {
        while (!stack.empty()) {
            System.out.print(stack.pop().getName() + " ");
        }
    }
}
