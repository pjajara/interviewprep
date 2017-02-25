package edu.sjsu.java.anoop;

public class Ranking 
{
    private static RankNode root = null;
    
    public static void insert(int d)
    {
        if(root == null)
            root = new RankNode(d);
        else
            root.insert(d);
    }
    
    public static int getRank(int d)
    {
        return root.getRank(d);
    }
    

    public static void main(String[] args)
    {
        Ranking r = new Ranking();
        insert(20);
        insert(15);
        insert(10);
        insert(5);
        insert(13);
        insert(25);
        insert(23);
        insert(24);
        
        System.out.println(getRank(24));
    }
}

class RankNode
{
    public int leftCount = 0;
    public RankNode left, right;
    public int data;

    public RankNode(int d)
    {
        data = d;
    }

    public void insert(int d)
    {
        if(d <= data)
        {
            if(left != null)
                left.insert(d);
            else
                left = new RankNode(d);
            leftCount++;
        }
        else
        {
            if(right != null)
                right.insert(d);
            else
                right = new RankNode(d);
        }
    }

    public int getRank(int d)
    {
        if(d == data)
            return leftCount;
        if(d < data)
        {
            if(left == null) return -1;
            else return left.getRank(d); 
        }
        else
        {
            if(right == null) return -1;
            else return leftCount + 1 + right.getRank(d);
        }
    }
}
