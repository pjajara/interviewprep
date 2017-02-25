package edu.sjsu.java.anoop;

import java.util.Collections;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Permutation2 
{
    
    public static ArrayList<String> permutations(String s)
    {
        ArrayList<String> result = new ArrayList<String>();
        Queue<String> q = new LinkedList<>();
        q.add("|"+s);
        while(!q.isEmpty())
        {
            String str = q.remove();
            if(str.substring(str.length()-1).equals("|"))
                result.add(str.substring(0, str.length()-1));
            else
            {
                int markerIndex = str.indexOf("|");
                String before = str.substring(0, markerIndex);
                for(int i=markerIndex+1;i<str.length();i++)
                {
                    q.add(before + String.valueOf(str.charAt(i)) + "|" + str.substring(markerIndex+1, i) + str.substring(i+1, str.length()));
                }
            }
        }
        
        return result;
    }
    
    public static ArrayList<String> permutationsRecur(String s)
    {
        ArrayList<String> result = new ArrayList<String>();
        if(s == null || s.length() == 0)
        {
            result.add("");
            return result;
        }
        
        char c = s.charAt(0);
        String remainder = s.substring(1);
        ArrayList<String> words = permutationsRecur(remainder);
        for(String str : words)
            for(int i=0;i<=str.length();i++)
                result.add(str.substring(0, i) + c + str.substring(i));
        return result;
    }
    
    
   public static void main(String[] args)
   {
      ArrayList<String> result = Permutation2.permutationsRecur("Is");
      Collections.sort(result);
      System.out.println("Actual: " + result);
      System.out.println("Expected: [Is, sI]");

      result = Permutation2.permutationsRecur("SJU");
      Collections.sort(result);
      System.out.println("Actual: " + result);
      System.out.println("Expected: [JSU, JUS, SJU, SUJ, UJS, USJ]");
   }    
}
