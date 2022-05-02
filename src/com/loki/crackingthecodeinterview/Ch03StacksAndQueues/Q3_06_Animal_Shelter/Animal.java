package com.loki.crackingthecodeinterview.Ch03StacksAndQueues.Q3_06_Animal_Shelter;

public abstract class Animal {
    private String name;
    private int order;

    public Animal(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public boolean isOlder(Animal animal) {
        return this.getOrder() < animal.getOrder();
    }
}
