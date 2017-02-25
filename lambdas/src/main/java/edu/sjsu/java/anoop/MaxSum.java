package edu.sjsu.java.anoop;
public class MaxSum
{
    public static void main(String[] args)
    {
        int a[] = new int[]{5, -9, 6, -2, 3};
        
        int maxsum = 0;
        int sum = 0;
        
        for(int i=0;i<a.length;i++)
        {
            sum += a[i];
            if(sum < 0)
                sum = 0;
            if(sum > maxsum)
                maxsum = sum;
        }
        
        System.out.println(maxsum);
    }
}
