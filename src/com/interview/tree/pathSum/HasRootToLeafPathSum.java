package com.interview.tree.pathSum;

import com.interview.tree.Node;

public class HasRootToLeafPathSum {

    public boolean hasPathSum(Node node, int sum) {
        if (node == null)
            return sum == 0;
        return hasPathSum(node.left, sum - node.key) ||
                hasPathSum(node.right, sum - node.key);
    }
}
