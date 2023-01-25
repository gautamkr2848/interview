package com.interview.tree;

import java.util.Stack;

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
        if (node != null){
            stack.push(node);
            pushLeftMostNode(node.left);
        }
    }
}
