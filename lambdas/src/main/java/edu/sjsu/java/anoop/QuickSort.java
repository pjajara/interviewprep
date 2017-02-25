package edu.sjsu.java.anoop;

public class QuickSort 
{
    
    public static int partition(int [] a, int left, int right)
    {
        int pivotIndex = (left+right)/2;
        int pivot = a[pivotIndex];
        
        while(left <= right)
        {
            while(pivot > a[left])
                left++;
            while(pivot < a[right])
                right--;
            if(left <= right)
            {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
    
    public static void sort(int [] a, int left, int right)
    {
        int index = partition(a, left, right);
        if(left < index)
            partition(a, left, index-1);
        else
            partition(a, index, right);
    }
    
    public static void main(String[] args)
    {
        int a[] = new int[]{6,5,4,3,2,1};
        sort(a, 0, a.length-1);
        for(int i=0;i<a.length;i++)
            System.out.println(a[i]);
    }    
}
