package edu.sjsu.java.todelete;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by pjajara on 2/12/17.
 */

public class AppMain {

    @Ignore
    @Test
    public void testReverseString(){
        assertEquals(null, Delete1.reverseString(null));
        assertEquals("a", Delete1.reverseString("a"));
        assertEquals("", Delete1.reverseString(""));
        assertEquals(" ", Delete1.reverseString(" "));
        assertEquals("cba", Delete1.reverseString("abc"));
        assertEquals("+_)(*&^%$#@!", Delete1.reverseString("!@#$%^&*()_+"));
        assertEquals("DCBA", Delete1.reverseString("ABCD"));
    }

    @Test (expected = IllegalStateException.class)
    public void testFullStack(){

        IntStack stack = new IntStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
    }

    @Test (expected = IllegalStateException.class)
    public void testEmptyStack(){

        IntStack stack = new IntStack(1);
        stack.push(1);
        stack.pop();
        stack.pop();
    }

    @Test
    public void testPushPopOnStack(){
        IntStack stack = new IntStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.pop();
        stack.push(4);
        stack.push(5);
        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println(stack);
    }
}
