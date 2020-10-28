package com.interview.tree;

public class IdenticalTree {

    public Boolean isIdentical(Node node1, Node node2){
        if(node1 == null && node2 == null)
            return true;
        if(node1 == null || node2 == null)
            return false;
        return (isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right));
    }
}
