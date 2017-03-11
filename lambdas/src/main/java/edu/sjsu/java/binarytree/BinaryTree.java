package edu.sjsu.java.binarytree;

import org.junit.Test;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public Node insert(Node node, int d) {

        if (node == null) {
            node = new Node(d);
        } else {
            if (d <= node.data) {
                node.left = insert(node.left, d);
            } else {
                node.right = insert(node.right, d);
            }
        }
        return node;
    }

    public boolean lookUp(Node node, int d) {

        if (node == null) {
            return false;
        } else if (d <= node.data) {
            return lookUp(node.left, d);
        } else {
            return lookUp(node.right, d);
        }
    }

    @Test
    public void testInsert() {
        BinaryTree b = new BinaryTree();
        Node n = b.insert(root, 35);
        b.insert(n, 25);
        b.insert(root, 45);
    }
}
