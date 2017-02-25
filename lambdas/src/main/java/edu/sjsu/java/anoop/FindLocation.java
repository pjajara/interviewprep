
package edu.sjsu.java.anoop;
import java.util.List;
import java.util.ArrayList;


public class FindLocation
{   
    
   public static List<Integer> findLocationsHelper(List<Integer> a, String s, String t, int start)
   {
       if(start == s.length()) return a;
       int pos = s.indexOf(t, start);
       if(!a.contains(pos) && pos != -1)
           a.add(pos);
       a = findLocationsHelper(a, s, t, start+1);
       return a;
   }
   
   public static int[] findLocations(String s, String t)
   {
      List<Integer> a = new ArrayList<Integer>();
      a = findLocationsHelper(a, s, t, 0);
      int[] pos = new int[a.size()];
      for(int i = 0; i < a.size(); i++)
      {
          pos[i] = a.get(i);
      }
      return pos;
   }

   public static void main(String[] args)
   {
       int a[] = findLocations("Frances ran and ran", "a");
       for(int i=0;i<a.length;i++)
           System.out.println(a[i]);
   }
}