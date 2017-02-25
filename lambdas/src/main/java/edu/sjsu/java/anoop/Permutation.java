package edu.sjsu.java.anoop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Permutation
{
    
    public static Set<String> subsequencesHelper(String s)
    {
        Set<String> set = new HashSet<String>();
        if(s.length() == 0)
        {
            set.add("");
            return set;
        }
        String str = String.valueOf(s.charAt(0));
        for(String temp : subsequencesHelper(s.substring(1)))
        {
            set.add(temp);
            set.add(str.concat(temp));
        }
        return set;
    }   
    
    public static ArrayList<String> subsequences(String s)
    {
        ArrayList<String> lst = new ArrayList<String>();
        for(String str : subsequencesHelper(s))
            lst.add(str);
        return lst;
    }
    
    public static void main(String[] args)
    {
       ArrayList<String> a = subsequences("123");
       for(int i=0;i<a.size();i++)
           System.out.print(a.get(i) + " ");
   }    
}
