package com.interview.dynamic.tree;

public class NodeToNodePathSum {

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

        int temp = Math.max(Math.max(left, right) + node.data, node.data);
        int ans = Math.max(temp, left + right + node.data);
        result = Math.max(result, ans);

        return temp;
    }
}
