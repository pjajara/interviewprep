package com.gf;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by pjajara on 2/1/17.
 */
public class Greeter {

    public void greet(Greeting greeting){
        greeting.perform();
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();
       // Greeting greeting = new HelloWorldGreeting();
        // greeter.greet(greeting);

       //Greeting g = () -> System.out.print("Matrix Reloaded!");
        greeter.greet(() -> System.out.print("Matrix Reloaded!"));

        MyLambda myLambda = (int number) ->{
            return number * 2;
        };

        MyAdd myAdd = (int a, int b) -> {return a+ b;};

        Person person = new Person("PK", "Jajara", 32);
        List<Person> people = new ArrayList<>();
        people.add(person);

        Stream<Person> stream = people.stream();
        Stream<Person> pStream = people.parallelStream();


    }

    public int returnDouble(int number){
        return number * 2;
    }


}

interface MyLambda{
    public int returnDouble(int a);
}

interface MyAdd{
    public int returnAddition(int a, int b);
}
