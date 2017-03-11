package edu.sjsu.java.bindingdynamic;

/**
 * Created by pjajara on 3/5/17.
 */
public class Animal {
    void eat() {
        System.out.println("animal is eating...");
    }
}

class Dog extends Animal {

    public static void main(String args[]) {
        Animal a = new Dog();
        a.eat(); // prints >> dog is eating...
    }

    @Override
    void eat() {
        System.out.println("dog is eating...");
    }
}

