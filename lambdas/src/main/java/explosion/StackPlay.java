package explosion;

import java.util.Stack;

/**
 * Created by pjajara on 2/25/17.
 */
public class StackPlay {

    public static Integer counter = 0;

    public static Integer printGreeting(Integer greetingId) {
       // System.out.println(greetingId + ". " + "Greeting");
        return greetingId;

    }

    public static Integer printNumber() {
       // System.out.println(counter++);
        return counter++;
    }

    public static void main(String... args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(printGreeting(0));
        stack.push(printGreeting(1));
        stack.push(printGreeting(2));
        stack.push(printGreeting(3));
        stack.push(printGreeting(4));

        stack.push(printNumber());
        stack.push(printNumber());
        stack.push(printNumber());
        stack.push(printNumber());
        stack.push(printNumber());

        System.out.println("Done with playing with Stack");

        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }
}
