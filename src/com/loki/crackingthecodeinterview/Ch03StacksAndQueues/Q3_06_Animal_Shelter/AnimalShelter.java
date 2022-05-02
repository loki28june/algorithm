package com.loki.crackingthecodeinterview.Ch03StacksAndQueues.Q3_06_Animal_Shelter;


import java.util.LinkedList;

public class AnimalShelter {
    private LinkedList<Dog> dogs;
    private LinkedList<Cat> cats;
    private int order;

    AnimalShelter() {
        this.dogs = new LinkedList<>();
        this.cats = new LinkedList<>();
    }

    public void enqueue(Animal animal) {
        order++;
        animal.setOrder(order);
        if (animal instanceof Dog) {
            dogs.addLast((Dog) animal);
            return;
        }
        if (animal instanceof Cat) {
            cats.addLast((Cat) animal);
            return;
        }
    }

    public Animal dequeueAny() {
        if (dogs.size() == 0) {
            return dequeueCat();
        }
        if (cats.size() == 0) {
            return dequeueCat();
        }
        if (dogs.peekFirst().isOlder(cats.peekFirst())) {
            return dogs.pollFirst();
        }
        return cats.pollFirst();
    }

    public Animal dequeueDog() {
        return dogs.pollFirst();
    }

    public Animal dequeueCat() {
        return cats.pollFirst();
    }

    public static void main(String[] args) {
        AnimalShelter animalShelter = new AnimalShelter();
        animalShelter.enqueue(new Dog("Tommy"));
        animalShelter.enqueue(new Cat("Katie"));
        animalShelter.enqueue(new Dog("Whiskey"));
        animalShelter.enqueue(new Cat("Jane"));
        animalShelter.enqueue(new Dog("Robbie"));
        animalShelter.enqueue(new Cat("Cutie"));
        System.out.println(animalShelter.dequeueAny());
        System.out.println(animalShelter.dequeueDog());
        System.out.println(animalShelter.dequeueCat());

    }
}
