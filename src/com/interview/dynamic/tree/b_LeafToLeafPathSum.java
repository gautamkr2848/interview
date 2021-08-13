package com.interview.dynamic.tree;

import com.interview.tree.Node;

public class b_LeafToLeafPathSum {

    public void maxPathSum(Node node) {
        int result = Integer.MIN_VALUE;
        maxPathSumUtil(node, result);
        System.out.println(result);
    }

    private int maxPathSumUtil(Node node, int result) {
        if (node == null)
            return 0;

        int left = maxPathSumUtil(node.left, result);
        int right = maxPathSumUtil(node.right, result);

        int temp = Math.max(left, right) + node.key;
        int ans = Math.max(temp, left + right + node.key);
        result = Math.max(result, ans);

        return temp;
    }
}
