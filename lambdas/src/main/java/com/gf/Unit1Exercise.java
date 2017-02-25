package com.gf;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pjajara on 2/1/17.
 */
public class Unit1Exercise {

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Jugal", "Caiwal", 33),
                new Person("Shanwar", "Paiwal", 32),
                new Person("Shyam", "Caiwal", 37),
                new Person("Rameshwar", "Paiwal", 55)
        );

        Class c = int.class;
        System.out.println(c.isPrimitive());
        System.out.println(c.getFields());
        Class c1 = Boolean.class;
        System.out.println(c1.isPrimitive());

        //step1: Sort list by lastName
       // Collections.sort(people);

        //step2; Create a method that prints all elements in list

        // step3: Print all people with lastName beginning with P
    }
}
