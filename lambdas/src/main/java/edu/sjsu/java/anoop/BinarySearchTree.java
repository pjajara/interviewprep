package edu.sjsu.java.anoop;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.ArrayList;


public class BinarySearchTree
{
    private Node root;
    
    public BinarySearchTree()
    {
        root = null;
    }
    
    public Node getRoot()
    {
        return root;
    }
    public void add(Comparable obj)
    {
        Node newNode = new Node();
        newNode.data = obj;
        newNode.left = null;
        newNode.right = null;
        newNode.parent = null;
        root = addNode(root, newNode);
    }
    
   
   
    public static Node addNode(Node parent, Node newNode)
    {
        if(parent == null)
        {
            parent = newNode;
            return newNode;
        }
        else
        {
            if(newNode.data.compareTo(parent.data) < 0)
            {
                parent.left = addNode(parent.left, newNode);
                parent.left.parent = parent;
                return parent;
            }
            else
            {
                parent.right = addNode(parent.right, newNode);
                parent.right.parent = parent;
                return parent;
            }
        }
    }
    
   public String toString()
   {  
      return toString(root);
   }  

   private static String toString(Node parent)
   {  
      if (parent == null) { return ". "; }
      else 
      { 
         return "( " + toString(parent.left) 
            + parent.data + " " 
            + toString(parent.right) + ") "; 
      }
   }    
   
    class Node
    {
        public Comparable data;
        public Node left;
        public Node right;
        public Node parent;
    }
    
    public Comparable smallest()
    {
        if(root != null) return smallest(root, root.data);
        return "";
    }
    
    public Comparable smallest(Node node, Comparable small)
    {
        if(node != null)
        {
            if(node.data.compareTo(small) < 0)
                small = node.data;
            small = smallest(node.left, node.data);
        }
        return small;
    }
    
    public void remove(Comparable obj)
    {
        Node toBeRemoved = root;
        Node parent = null;
        boolean found = false;
        
        while(!found && toBeRemoved != null)
        {
            int d = toBeRemoved.data.compareTo(obj);
            if(d == 0)
                found = true;
            else
            {
                parent = toBeRemoved;
                if(d > 0)
                    toBeRemoved = toBeRemoved.left;
                else
                    toBeRemoved = toBeRemoved.right;
            }
        }
        
        if(!found) return;
        
        if(toBeRemoved.left == null || toBeRemoved.right == null)
        {
            Node newChild;
            if(toBeRemoved.right == null)
                newChild = toBeRemoved.left;
            else
                newChild = toBeRemoved.right;
            
            if(parent == null)
                root = newChild;
            else if(parent.left == toBeRemoved)
                parent.left = newChild;
            else
                parent.right = newChild;
            return;
        }
        
        Node smallestParent = toBeRemoved;
        Node smallest = toBeRemoved.right;
        while(smallest.left != null)
        {
            smallestParent = smallest;
            smallest = smallest.left;
        }
        
        toBeRemoved.data = smallest.data;
        if(smallestParent == toBeRemoved)
            smallestParent.right = smallest.right;
        else
            smallestParent.left = smallest.right;
            
    }
    
    public void preorder(Visitor v)
    {
        if(root != null)
            preorder(root, v);
    }
    
    public static void preorder(Node n,Visitor v)
    {
        if(n == null) return;
        v.visit(n.data);
        preorder(n.left, v);
        preorder(n.right, v);
    }
    
    public void postorder(Visitor v)
    {
        if(root != null)
            postorder(root, v);
    }
    
    public static void postorder(Node n,Visitor v)
    {
        if(n == null) return;
        postorder(n.left, v);
        postorder(n.right, v);
        v.visit(n.data);
    }
    
    public void inorder(Visitor v)
    {
        if(root != null)
            inorder(root, v);
    }
    
    public static void inorder(Node n,Visitor v)
    {
        if(n == null) return;
        inorder(n.left, v);
        v.visit(n.data);
        inorder(n.right, v);
    }
    
   class SortedIterator implements Iterator 
   {
      Stack<Node> stk = new Stack<Node>();

      public SortedIterator(Node root) 
      {
          while(root != null)
          {
            stk.add(root);
            root = root.left;
          }
      }
		
      public boolean hasNext() 
      {
         return stk.size() > 0;
      }

      public Object next() 
      {
         Node n = stk.pop(); 
         Node n1 = n.right;
          while(n1 != null)
          {
            stk.add(n1);
            n1= n1.left;
          }
          return n.data;
      }

      public void remove() 
      {
         throw new UnsupportedOperationException();
      }
		 
   }
	 
   public Iterator iterator() 
   {
      return new SortedIterator(root);
   }
   
   public int height()
   {
       if(root == null) return 0;
       else return height(root);
   }
   
   public static int height(Node n)
   {
       if(n == null) return 0;
       else return 1 + Math.max(height(n.left), height(n.right));
   }   
   
   public static boolean existsIn(BinarySearchTree.Node root, Comparable node)
   {
       if(root == null)
           return false;
       if(root.data == node)
           return true;
       return existsIn(root.left, node) || existsIn(root.right, node);
   }
   
   public static Comparable commonAncestor1(BinarySearchTree.Node root, Comparable node1, Comparable node2)
   {
       if(!existsIn(root, node1) || !existsIn(root, node2))
           return null;
       return commonAncestorHelper(root, node1, node2);
   }

   public static Comparable commonAncestorHelper(BinarySearchTree.Node root, Comparable node1, Comparable node2)
   {
       if(root == null)
           return null;
       if(root.data == node1 || root.data == node2)
           return root.data;
       boolean onLeft1 = existsIn(root.left, node1);
       boolean onLeft2 = existsIn(root.left, node2);
       if(onLeft1 != onLeft2)
           return root.data;
       if(onLeft1)
           return commonAncestorHelper(root.left, node1, node2);
       else
           return commonAncestorHelper(root.right, node1, node2);
   }

   public static Comparable commonAncestor2(BinarySearchTree.Node root, Comparable node1, Comparable node2)
   {
       if(root == null)
           return null;
       Comparable x = commonAncestor2(root.left, node1, node2);
       if(x != null && x != node1 && x != node2)
           return x;
       Comparable y = commonAncestor2(root.right, node1, node2);
       if(y != null && y != node1 && y != node2)
           return y;
       
       if(x != null && y != null)
           return root.data;
       else if(root.data == node1 || root.data == node2)
           return root.data;
       else if(x == null)
           return y;
       else
           return x;
           
   }
   
   public static void findPairSums(int[] a, int sum)
   {
       Arrays.sort(a);
       int left = 0;
       int right = a.length-1;
       
       while(left < right)
       {
           int s = a[left] + a[right];
           if(s == sum)
               System.out.println(a[left++] + "  " + a[right--]);
           else if(s < sum)
               left++;
           else
               right--;
       }
   }

   public Node createMinimalBST(int[] a, int start, int end)
   {
        if(end < start)
            return null;
        int mid = (start + end) / 2;
        Node newNode = new Node();
        newNode.data = a[mid];
        newNode.left = createMinimalBST(a, start, mid-1);
        newNode.right = createMinimalBST(a, mid+1, end);
        return newNode;
   }

   public static void createLevelLinkedList(BinarySearchTree.Node node, ArrayList<LinkedList<BinarySearchTree.Node>> lists, int level)
   {
       if(node == null)
           return;
       if(lists.size() == level)
       {
           LinkedList<BinarySearchTree.Node> list = new LinkedList<BinarySearchTree.Node>();
           lists.add(list);
       }
       LinkedList<BinarySearchTree.Node> list = lists.get(level);
       list.add(node);
       createLevelLinkedList(node.left, lists, level+1);
       createLevelLinkedList(node.right, lists, level+1);
   }
   
   public static void main(String[] args)
   {  
        BinarySearchTree t = new BinarySearchTree();
        t.add(5);
        t.add(2);
        t.add(8);
        t.add(3);
        t.add(1);
        t.add(0);
        t.add(10);
        t.add(6);
        t.add(4);
        
        //ArrayList<LinkedList<BinarySearchTree.Node>> lists = new ArrayList<LinkedList<BinarySearchTree.Node>>();
        //createLevelLinkedList(t.getRoot(), lists, 0);
      

   }    
    
}
