package edu.sjsu.java.anoop;

public class TreeOperations 
{
    final static int r;
    static{r=2;}
    public static int checkHeight(BinarySearchTree.Node root)
    {
        if(root == null)
            return 0;
        int leftHeight = checkHeight(root.left);
        if(leftHeight == -1)
            return -1;
        int rightHeight = checkHeight(root.right);
        if(rightHeight == -1)
            return -1;
        int diff = rightHeight - leftHeight;
        if(Math.abs(diff) > 1)
            return -1;
        else
            return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public static boolean checkBST(BinarySearchTree.Node root, int min)
    {
        if(root == null) return true;
        if(!checkBST(root.left, min)) return false;
        if(root.data.compareTo(min) < 1) 
            return false;
        min = Integer.valueOf(root.data.toString());
        if(!checkBST(root.right, min)) return false;
        return true;
    }

    public static BinarySearchTree.Node findLeftMostNode(BinarySearchTree.Node node)
    {
        if(node == null) return null;
        
        while(node.left != null)
            node = node.left;
        return node;
    }
        
    public static Object inorderSucc(BinarySearchTree.Node node)
    {
        BinarySearchTree.Node q = null;
        BinarySearchTree.Node x = null;
        
        if(node == null) return null;
        
        if(node.right != null)
            return findLeftMostNode(node.right).data;
        else
        {
            q = node;
            x = q.parent;
        }
        
        while(x != null && x.left != q)
        {
            q = x;
            x = x.parent;
        }
        return x.data;
    }

    public static boolean containsTree(BinarySearchTree t1, BinarySearchTree t2)
    {
        if(t2 == null) return true;
        return subTree(t1.getRoot(), t2.getRoot());
    }

    public static boolean subTree(BinarySearchTree.Node node1, BinarySearchTree.Node node2)
    {
        if(node1 == null) return false;
        if(node1.data.equals(node2.data))
            if(matchTree(node1, node2)) return true;
        return subTree(node1.left, node2) || subTree(node1.right, node2);
    }

    public static boolean matchTree(BinarySearchTree.Node node1, BinarySearchTree.Node node2)
    {
        if(node1 == null && node2 == null)
            return true;
        if(node1 == null || node2 == null)
            return false;
        if(!node1.data.equals(node2.data)) return false;
        return matchTree(node1.left, node2.left) && matchTree(node1.right, node2.right);
    }

    public static void findSum(BinarySearchTree.Node node, int path[],int sum, int level)
    {
        if(node == null)
            return;
        
        path[level] = Integer.parseInt(node.data.toString());
        int temp = 0;
        for(int i=level;i>=0;i--)
        {
            temp += path[i];
            if(temp == sum)
            {
                System.out.println();
                for(int j=i;j<=level;j++)
                {
                    System.out.print(path[j] + "->");
                }
            }
        }
        
        findSum(node.left, path, sum, level+1);
        findSum(node.right, path, sum, level+1);
        
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

        findSum(t.getRoot(), new int[t.height()], 5, 0);


    }
}
