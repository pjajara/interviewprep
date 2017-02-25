package edu.sjsu.java.anoop;

public class LinkedSum {
    
    static SingleLinkedList result = new SingleLinkedList();
    static int carry = 0;
    
    public static void addLists(SingleLinkedList num1, SingleLinkedList num2)
    {
        int len1 = 4;
        int len2 = 3;
        
        if(len1 > len2)
            num2 = pad(num2, len1 - len2);
        else
            num1 = pad(num1, len2 - len1);
        
        addListsHelper(num1.getHead(), num2.getHead());
        if(carry != 0)
            result.addFirst(1);
    }
    
    public static void addListsHelper(SingleLinkedList.Node node1, SingleLinkedList.Node node2)
    {
        if(node1 == null && node2 == null)
            return;
        int sum = Integer.parseInt(node1.data.toString()) + Integer.parseInt(node2.data.toString()) + carry;
        carry  = sum / 10;
        result.addFirst(sum % 10);
        addListsHelper(node1.next, node2.next);
    }
    
    
    public static SingleLinkedList pad(SingleLinkedList num, int padding)
    {
        for(int i=0;i<padding;i++)
        {
            num.addFirst(0);
        }
        return num;
    }
    public static void main(String[] args)
    {
      SingleLinkedList num1 = new SingleLinkedList();
      num1.addFirst(4);
      num1.addFirst(3);
      num1.addFirst(2);
      num1.addFirst(1);

      SingleLinkedList num2 = new SingleLinkedList();
      num2.addFirst(7);
      num2.addFirst(6);
      num2.addFirst(5);

      addLists(num1, num2);
      ListIterator iter1 = result.listIterator();
      while (iter1.hasNext()) System.out.print(iter1.next() + "->");

    }
    
}
