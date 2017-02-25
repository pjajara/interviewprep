package edu.sjsu.java.anoop;

public class MergeSort
{
    
    public static void sort(int [] a)
    {
        if(a.length < 2)
            return;
        int size = 1;
        while(size < a.length)
        {
            int from = 0;
            int mid = from+size;
            int to = mid+size;
            
            while(to <= a.length)
            {
                merge(a, from, mid, to);
                from = mid + size;
                mid = from+size;
                to = mid+size;
            }
            if(mid < a.length)
                merge(a, from, mid, a.length);
            size *= 2;
        }
    }
    
    public static void merge(int []a, int from, int mid, int to)
    {
        int[] first = new int[mid-from+1];
        int[] second = new int[to-mid+1];
        
        for(int i=0,j=from;i<first.length-1;i++)
            first[i] = a[j++];    
        for(int i=0,j=mid;i<second.length-1;i++)
            second[i] = a[j++];

        first[first.length-1] = Integer.MAX_VALUE;
        second[second.length-1] = Integer.MAX_VALUE;

        int f = 0;
        int s = 0;
        int i = from;
        while(i < to)
        {
            if(first[f] > second[s])
                a[i++] = second[s++];
            else
                a[i++] = first[f++];
        }
    }
    
    public static void main(String[] args)
    {
        int a[] = new int[]{6,5,4,3,2,1};
        sort(a);
        for(int i=0;i<a.length;i++)
            System.out.println(a[i]);
    }    
}
