package edu.sjsu.java.anoop;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Median 
{

    public static PriorityQueue<Integer> maxHeap;
    public static PriorityQueue<Integer> minHeap;
    public static Comparator<Integer> minHeapComparator = new MinHeapComparator();
    public static Comparator<Integer> maxHeapComparator = new MaxHeapComparator();
    
    public static void addToHeap(int num)
    {
        if(minHeap.size() == maxHeap.size())
        {
            if(minHeap.peek() != null && num > minHeap.peek())
            {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            }
            else
            {
                maxHeap.offer(num);
            }
        }
        else
        {
            if(num < maxHeap.peek())
            {
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }
            else
            {
                minHeap.add(num);
            }
        }
    }
    
    public static double getMedian()
    {
        if(maxHeap.size() == 0)
            return 0.0;
        else if(maxHeap.size() == minHeap.size())
            return ((double)maxHeap.peek() + (double)minHeap.peek()) / 2;
        else
            return maxHeap.peek();
        
    }
    
    public static void addNewNumberAndPrintMedian(int num)
    {
        addToHeap(num);
        System.out.println(getMedian());
    }
    
    public static void main(String[] args)
    {
        int size = 10;
        
        maxHeap = new PriorityQueue<Integer>(size, maxHeapComparator);
        minHeap = new PriorityQueue<Integer>(size-size/2, minHeapComparator);
        
        addNewNumberAndPrintMedian(6);
        addNewNumberAndPrintMedian(5);
        addNewNumberAndPrintMedian(1);
        addNewNumberAndPrintMedian(0);
        addNewNumberAndPrintMedian(9);
        addNewNumberAndPrintMedian(2);
        addNewNumberAndPrintMedian(4);
        addNewNumberAndPrintMedian(3);
        addNewNumberAndPrintMedian(7);
        addNewNumberAndPrintMedian(8);
    }
//012345678
}

    class MaxHeapComparator implements Comparator<Integer>
    {
        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1 < o2) return 1;
            else if(o1 > o2) return -1;
            else return 0;
        }
    }

    class MinHeapComparator implements Comparator<Integer>
    {
        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1 > o2) return 1;
            else if(o1 < o2) return -1;
            else return 0;
        }
    }
