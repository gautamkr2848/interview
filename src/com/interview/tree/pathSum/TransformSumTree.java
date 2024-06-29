package com.interview.tree.pathSum;

/*
                    10                                      20(-2+6+4+12)
            -2              6           =>          4(8-4+0+0)               12(7+5+0+0)
        8       -4      7       5                0               0       0                  0
*/


import com.interview.tree.Node;

public class TransformSumTree {

    private int transformSumTree(Node node){
        if (node == null)
            return 0;
        int old_val = node.key;
        node.key = transformSumTree(node.left) + transformSumTree(node.right);
        return old_val + node.key ;
    }
}
