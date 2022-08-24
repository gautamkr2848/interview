package com.interview.tree;

/*
                    10                                      20
            -2              6           =>          4               12
        8       -4      7       5               0       0       0       0
*/

public class TransformSumTree {

    public int transformSumTree(Node node){
        if (node == null)
            return 0;
        int old_val = node.key;
        node.key = transformSumTree(node.left) + transformSumTree(node.right);
        return node.key + old_val;
    }
}
