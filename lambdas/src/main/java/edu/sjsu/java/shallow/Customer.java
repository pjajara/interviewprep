package edu.sjsu.java.shallow;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Map;

/**
 * Created by pjajara on 3/11/17.
 */
public final class Customer {

    private final int age;
    private final String firstName;
    private final Map<String, String> hobbies;

    public Customer(int a, String fName, Map<String, String> hobbies){
        this.age = a;
        this.firstName = fName;
        //this.hobbies = new HashMap<>(hobbies);
        this.hobbies = hobbies;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public Map<String, String> getHobbies() {
        return hobbies;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("age", age)
                .append("firstName", firstName)
                .append("hobbies", hobbies)
                .toString();
    }
}
