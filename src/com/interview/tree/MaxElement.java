package com.interview.tree;

public class MaxElement {

    public int maxElement(BinaryTree node){

        int max = 0;
        if(node != null){
            int leftMax = maxElement(node.getLeft());
            int rightMax = maxElement(node.getRight());
            max = leftMax > rightMax ? leftMax : rightMax;
            max = node.data > max ? node.data : max;
        }
        return max;
    }
}
