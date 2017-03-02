package edu.sjsu.java.anoop;

public class WorkOrder implements Comparable {
    private int priority;
    private String description;

    public WorkOrder(int p, String d) {
        priority = p;
        description = d;
    }

    public String toString() {
        return "priority=" + priority + ", description=" + description;
    }

    public int compareTo(Object otherObject) {
        WorkOrder other = (WorkOrder) otherObject;
        if (priority < other.priority) {
            return -1;
        }
        if (priority > other.priority) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
    /*    MinHeap q = new MinHeap();
        q.addR(new WorkOrder(3, "Shampoo carpets"));
        q.addR(new WorkOrder(7, "Empty trash"));
        q.addR(new WorkOrder(8, "Water plants"));
        q.addR(new WorkOrder(10, "Remove pencil sharpener shavings"));
        q.addR(new WorkOrder(6, "Replace light bulb"));
        q.addR(new WorkOrder(1, "Fix broken sink"));
        q.addR(new WorkOrder(9, "Clean coffee maker"));
        q.addR(new WorkOrder(2, "Order cleaning supplies"));
        while (!q.empty())
        {
            System.out.println(q.remove());
        }       */
    }

}
