package com.interview.tree;

import java.util.Stack;

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
