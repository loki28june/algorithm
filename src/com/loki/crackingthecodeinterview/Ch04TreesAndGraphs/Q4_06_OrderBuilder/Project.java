package com.loki.crackingthecodeinterview.Ch04TreesAndGraphs.Q4_06_OrderBuilder;


public class Project {
    public enum State {BLANK,PARTIAL,COMPLETED};
    private State state = State.BLANK;
    private String name;
    private Project[] children;
    private int count;

    public Project(String name, int noOfChildren) {
        this.name = name;
        children = new Project[noOfChildren];
        count = 0;
    }

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Project[] getChildren() {
        return children;
    }

    public void makeEdge(Project project){
        if(count < children.length){
            children[count] = project;
            count++;
        }
        else{
            System.out.println("project children limit is full");
        }
    }
}
