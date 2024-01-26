package com.interview.tree;

public class IsMirror {

    public Boolean isMirror(Node node1, Node node2){
        if(node1 == null && node2 == null)
            return true;
        if(node1 == null || node2 == null)
            return false;
        return (isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left));
    }
}
