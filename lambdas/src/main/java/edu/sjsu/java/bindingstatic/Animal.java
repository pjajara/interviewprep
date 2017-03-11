package edu.sjsu.java.bindingstatic;

/**
 * Created by pjajara on 3/5/17.
 */
class Animal {
    static void eat() {
        System.out.println("animal is eating...");
    }
}

class Dog extends Animal {

    public static void main(String args[]) {

        Animal a = new Dog();
        a.eat(); // prints >> animal is eating...

    }

    static void eat() {
        System.out.println("dog is eating...");
    }
}


