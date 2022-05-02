package com.loki.crackingthecodeinterview.Ch03StacksAndQueues.Q3_06_Animal_Shelter;

public class Cat extends Animal {

    Cat(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + this.getName() + '\'' +
                '}';
    }
}
