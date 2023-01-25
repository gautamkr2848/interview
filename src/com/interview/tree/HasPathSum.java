package com.interview.tree;

public class HasPathSum {

    public boolean hasPathSum(Node node, int sum) {
        if (node == null)
            return sum == 0;
        return hasPathSum(node.left, sum - node.key) ||
                hasPathSum(node.right, sum - node.key);
    }
}
