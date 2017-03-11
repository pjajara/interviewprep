package edu.sjsu.java.shallow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pjajara on 3/11/17.
 */
public class TestCustomer {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("PK", "Finance");
        map.put("Varun", "Eating");

        Customer customer = new Customer(32, "Pawankumar", map);

        map.put("Jass", "Cooking");
        map.put("Vihaan", "Carying");

        System.out.println(map);
        System.out.println(customer);
    }

}
