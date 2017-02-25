package edu.sjsu.java.anoop;

public class UnsortedSequence 
{
    public static int findLeftSubsequence(int[] a)
    {
        for(int i=1;i<a.length;i++)
            if(a[i] < a[i-1]) return i-1;
        return a.length - 1;
    }
    
    public static int findRightSubsequence(int[] a)
    {
        for(int i=a.length-1;i>0;i--)
            if(a[i] < a[i-1]) return i;
        return 0;
    }

    public static int shrinkLeft(int[] a, int minIndex, int endLeft)
    {
        for(int i=endLeft-1;i>=0;i--)
            if(a[minIndex] >= a[i]) return i+1;
        return 0;
    }

    public static int shrinkRight(int[] a, int maxIndex, int startRight)
    {
        for(int i=startRight;i<a.length;i++)
            if(a[maxIndex] <= a[i]) return i-1;
        return a.length-1;
    }
        
    public static void findUnsortedSequence(int[] a)
    {
        int endLeft = findLeftSubsequence(a);
        int startRight = findRightSubsequence(a);
        
        int minIndex = endLeft + 1;
        if(minIndex >= a.length) return;
        int maxIndex = startRight - 1;
        for(int i=endLeft;i<=startRight;i++)
        {
            if(a[i] < a[minIndex]) minIndex = i;
            if(a[i] > a[maxIndex]) maxIndex = i;
        }
        System.out.println(shrinkLeft(a, minIndex, endLeft) + " " + shrinkRight(a, maxIndex, startRight));
    }

    public static void main(String[] args)
    {
        findUnsortedSequence(new int[]{4,3,2,5});
    }
}
