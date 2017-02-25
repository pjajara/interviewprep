package javatransient;

/**
 * Created by pjajara on 2/11/17.
 */
public class KitchenSink {

    Integer i;

    public static void main(String args[]) {
        myMethod();
        String[] strings = {"A", "B"};
    }

    public static void myMethod() {
        try {
            int i = 1 / 0;
        } finally {
            System.out.println("I know what shit happened!");
        }
    }
}
