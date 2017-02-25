package edu.sjsu.java.anoop;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class SuffixTree 
{
    Node root = new Node();
    public SuffixTree(String str)
    {
        for(int i=0;i<str.length();i++)
            root.insertString(str.substring(i), i);
    }
    
    public ArrayList<Integer> search(String str)
    {
        return root.search(str);
    }
    
    class Node
    {
        char value;
        Map<Character, Node> children = new HashMap<Character, Node>();
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        
        public void insertString(String str, int index)
        {
            indexes.add(index);
            if(str != null && str.length() > 0)
            {
                char value = str.charAt(0);
                Node child = null;
                if(children.containsKey(value))
                    child = children.get(value);
                else
                {
                    child = new Node();
                    children.put(value, child);
                }
                child.insertString(str.substring(1), index);
            }
        }

        public ArrayList<Integer> search(String str)
        {
            if(str == null || str.length() == 0 )
                return indexes;
            char value = str.charAt(0);
            if(children.containsKey(value))
                return children.get(value).search(str.substring(1));
            return null;
        }
    
    }
    
    public static void main(String[] args) 
    {
        String testString = "mississippi";
        String[] stringList = {"is", "sip", "hi", "sis"};
        SuffixTree tree = new SuffixTree(testString);
        for (String s : stringList)
        {
            ArrayList<Integer> list = tree.search(s);
            if (list != null)
                System.out.println(s + ": " + list.toString());
        }
    }
}
