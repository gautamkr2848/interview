package com.interview.dynamic.tree;

import com.interview.tree.Node;

public class c_NodeToNodePathSum {

    static int result = Integer.MIN_VALUE;
    public static void maxPathSum(Node node) {

        maxPathSumUtil(node);
        System.out.println(result);
    }

    private static int maxPathSumUtil(Node node) {
        if (node == null)
            return 0;

        int left = maxPathSumUtil(node.left);
        int right = maxPathSumUtil(node.right);

        int temp = Math.max(Math.max(left, right) + node.key, node.key);
        int ans = Math.max(temp, left + right + node.key);
        result = Math.max(result, ans);

        return temp;
    }
    
    public static void main(String[] args) {
        Node tree = new Node(10);
        tree.left = new Node(2);
        tree.right = new Node(10);
        tree.left.left = new Node(20);
        tree.left.right = new Node(1);
        tree.right.right = new Node(-25);
        tree.right.right.left = new Node(3);
        tree.right.right.right = new Node(4);

        maxPathSum(tree);
    }


}
