package javatransient;

/**
 * Created by pjajara on 2/11/17.
 */
public class KitchenSink {

    Integer i;

    public static void main(String args[]) {
        // myMethod();
        String[] strings = {"A", "B"};

        String string = "samplestring";

        string.chars().forEach(c -> processCharacter((char)c));
    }

    public static void myMethod() {
        try {
            int i = 1 / 0;
        } finally {
            System.out.println("I know what shit happened!");
        }
    }

    public static void processCharacter(char c){
        System.out.println("c");
        System.out.print(c);
    }
}
