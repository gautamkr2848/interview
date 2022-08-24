package com.interview.tree;

public class MaxElement {

    public int maxElement(Node node){

        int max = 0;
        if(node != null){
            int leftMax = maxElement(node.left);
            int rightMax = maxElement(node.right);
            max = leftMax > rightMax ? (node.key > leftMax ? node.key : leftMax) : (node.key > rightMax ? node.key : rightMax);
        }
        return max;
    }
}
