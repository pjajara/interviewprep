package javatransient;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.*;

/**
 * Created by pjajara on 2/11/17.
 */
public final class Person implements Serializable {

    private String firstName;
    private String lastName;
    transient private String bio;

    public Person(String fName, String lName, String bio) {
        this.firstName = fName;
        this.lastName = lName;
        this.bio = bio;
    }

    public static void main(String args[]) throws IOException, ClassNotFoundException {

        Person person = new Person("Pawankumar", "Jajara", "Matrix Reloaded");
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("person"));
        o.writeObject(person);

        ObjectInputStream i = new ObjectInputStream(new FileInputStream("person"));
        Person readPerson = (Person) i.readObject();
        System.out.println(readPerson);

        MegaClass megaClass = new MegaClass();
        megaClass.packageAccess();

    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("bio", bio)
                .toString();
    }
}
