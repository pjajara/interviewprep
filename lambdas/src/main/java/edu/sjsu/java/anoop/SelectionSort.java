package edu.sjsu.java.anoop;

public class SelectionSort 
{
    
    public static void sort(int [] a)
    {
        for(int i=0;i<a.length-1;i++)
        {
            int minIndex = i;
            for(int j=i+1;j<a.length;j++)
            {
                if(a[j] < a[minIndex])
                    minIndex = j;
            }
            if(minIndex != i)
            {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
    }
    
    public static void main(String[] args)
    {
        int a[] = new int[]{5,4,3,2,-1,1};
        sort(a);
        for(int i=0;i<a.length;i++)
            System.out.println(a[i]);
    }
}
