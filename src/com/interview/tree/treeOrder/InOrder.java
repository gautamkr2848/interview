package com.interview.tree.treeOrder;

import java.util.Stack;

/*
                1
        2               3           => 4 2 5 1 6 3
    4       5       6
*/

class Node{
    int key;
    Node left, right;

    public Node(int key){
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

public class InOrder {

    public void inOrder(Node node){
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.key + " ");
        inOrder(node.right);
    }

    public void inOrder2(Node node){
        if (node == null)
            return;

        Stack<Node> s = new Stack<Node>();
        Node curr = node;

        while (curr != null || s.size() > 0){
            while (curr !=  null){
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            System.out.print(curr.key + " ");
            curr = curr.right;
        }
    }
}
    // O(n) time complexity
