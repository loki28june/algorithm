package com.loki.crackingthecodeinterview.Ch03StacksAndQueues.Q3_06_Animal_Shelter;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + this.getName() + '\'' +
                '}';
    }
}
