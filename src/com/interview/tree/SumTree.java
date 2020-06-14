package com.interview.tree;

public class SumTree {

    public int toSumTree(Node node) {
        if (node == null)
            return 0;
        int old_val = node.key;
        node.key = toSumTree(node.left) + toSumTree(node.right);
        return node.key + old_val;
    }

}
