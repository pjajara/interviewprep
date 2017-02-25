package edu.sjsu.java.anoop;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;


public class Tree 
{
    private Node root;
    
    public Tree(Object rootData)
    {
        root = new Node();
        root.data = rootData;
        root.children = new ArrayList<Node>();
    }
    
    public void addSubtree(Tree subTree)
    {
        root.children.add(subTree.root);
    }
    
    public int interiorNodes()
    {
        if(this.root == null) return 0;
        return root.interiorNodes();
    }
    
    class Node
    {
        public Object data;
        public List<Node> children;
        
        public int interiorNodes()
        {
            int count = 0;
            if(this != null)
            {
                if(this.children.size() == 0) count++;
                for(Node n : this.children)
                {
                    count += n.interiorNodes();
                }
            }
            return count;
        }        
    }
    
    public void depthFirst(Visitor v)
    {
        if(root == null) return;
        
        Queue<Node> stk = new LinkedList<Node>();
        stk.add(root);
        boolean more = true;
        while(more && stk.size() > 0)
        {
            Node n = stk.remove();
            more = v.visit(n.data);
            
            if(more)
            {
                for(Node nd : n.children)
                    stk.add(nd);
            }
        }
    }
    
    public static void main(String[] args){
        
      class SearchVisitor implements Visitor
      {
          private int target;
          public SearchVisitor(int target)
          {
              this.target = target;
          }

          public boolean visit(Object data)
            {
                System.out.print(data.toString() + " ");
                target--;
                if(target == 0)
                    return false;
                return true;
            }
      }
      
     Tree t1 = new Tree("A");
      
      SearchVisitor visitor = new SearchVisitor(1);
      t1.depthFirst(visitor);
      
      System.out.println("Expected: A ");
      
      Tree t7 = new Tree(1);
      Tree t8 = new Tree(4);
      Tree t9 = new Tree(5);
      Tree t10 = new Tree(9);
      
      t7.addSubtree(t8);
      t8.addSubtree(t9);
      t7.addSubtree(t10);
      
      visitor = new SearchVisitor(4);
      t7.depthFirst(visitor);
      
      System.out.println("Expected: 1 4 5 9 ");
    }    
}
