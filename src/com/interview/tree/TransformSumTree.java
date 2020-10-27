package com.interview.tree;

public class TransformSumTree {

    public int transformSumTree(Node node){
        if (node == null)
            return 0;
        int old_val = node.key;
        node.key = transformSumTree(node.left) + transformSumTree(node.right);
        return node.key + old_val;
    }

}
