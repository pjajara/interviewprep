package edu.sjsu.java.anoop;

public class InsertionSort 
{
    public static void sort(int a[])
    {
        int j=0;
        for(int i=1;i<a.length;i++)
        {
            int current = a[i];
            for(j=i-1;j>=0&&a[j] > current;j--)
                    a[j+1] = a[j];
            a[j+1] = current;
        }
        
    }
    
    public static void main(String[] args)
    {
        int a[] = new int[]{1,0,3,2,5};
        sort(a);
        for(int i=0;i<a.length;i++)
            System.out.println(a[i]);
    }
}
