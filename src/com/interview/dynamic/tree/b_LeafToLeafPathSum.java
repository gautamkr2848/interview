package com.interview.dynamic.tree;

import com.interview.tree.Node;

public class b_LeafToLeafPathSum {

    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Node tree = new Node(-15);
        tree.left = new Node(5);
        tree.right = new Node(6);
        tree.left.left = new Node(-8);
        tree.left.right = new Node(1);
        tree.left.left.left = new Node(2);
        tree.left.left.right = new Node(6);
        tree.right.left = new Node(3);
        tree.right.right = new Node(9);
        tree.right.right.right = new Node(0);
        tree.right.right.right.left = new Node(4);
        tree.right.right.right.right = new Node(-1);
        tree.right.right.right.right.left = new Node(10);

        maxPathSumUtil(tree);
        System.out.println(result);
    }

    private static int maxPathSumUtil(Node node) {
        if (node == null)
            return 0;

        int left = maxPathSumUtil(node.left);
        int right = maxPathSumUtil(node.right);

        int temp = Math.max(left, right) + node.key;
        int ans = Math.max(temp, left + right + node.key);
        result = Math.max(result, ans);

        return temp;
    }
}