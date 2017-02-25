package edu.sjsu.java.anoop;

import java.util.Stack;

public class Palindrome 
{
    
    public static void isPalindrome(SingleLinkedList names)
    {
        Stack<SingleLinkedList.Node> stk = new Stack<SingleLinkedList.Node>();
        SingleLinkedList.Node fast = names.getHead();
        SingleLinkedList.Node slow = names.getHead();
        
        while(fast != null && fast.next != null)
        {
            stk.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast != null)
            slow = slow.next;
        while(slow != null)
        {
            SingleLinkedList.Node n = stk.pop();
            if(!n.data.equals(slow.data))
            {
                System.out.println("Not a Palindrome");
                return;
            }
            slow = slow.next;
        }
            System.out.println("Palindrome");
    }
    
    public static void main(String[] args)
    {
      SingleLinkedList names = new SingleLinkedList();
      names.addFirst("a");
      names.addFirst("n");
      names.addFirst("s");

      isPalindrome(names);


    }
}
