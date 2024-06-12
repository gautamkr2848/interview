package com.interview.tree;

import java.util.Stack;

/*
Approach
    Push all the left nodes to the stack starting from the root in the constructor. This will push the nodes in
    descending order.

    In the hasNext() return true if the stack has elements and false if its empty

    In the next(), pop the node from the stack, push to the stack the right subtree of this node and return its value.

Run Time Complexity
    hasNext(): O(1)
    next(): O(logn)
    memory: O(logn)
 */

public class BSTIterator {

    Stack<Node> stack = new Stack<>();

    public BSTIterator(Node root) {
        pushLeftMostNode(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext(){
        if(stack.empty())
            return false;
        return true;
    }

    /** @return the next smallest number */
    public int next(){
        Node node = stack.pop();
        pushLeftMostNode(node.right);
        return node.key;
    }

    private void pushLeftMostNode(Node node){
        while (node != null){
            stack.push(node);
            node = node.left;
        }
    }
}
