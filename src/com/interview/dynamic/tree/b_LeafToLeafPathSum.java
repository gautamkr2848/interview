package com.interview.dynamic.tree;

import com.interview.tree.Node;

public class b_LeafToLeafPathSum {

    Res res = new Res();

    public void maxPathSum() {
        Node tree = new Node(-9);
        tree.left = new Node(6);
        tree.right = new Node(-10);

        res.val = Integer.MIN_VALUE;
        maxPathSumUtil(tree, res);
        System.out.println(res.val);
    }

    private int maxPathSumUtil(Node node, Res result) {
        if (node == null)
            return 0;

        int left = maxPathSumUtil(node.left, result);
        int right = maxPathSumUtil(node.right, result);

        int temp = Math.max(left, right) + node.key;
        int ans = Math.max(temp, left + right + node.key);
        result.val = Math.max(result.val, ans);

        return temp;
    }

    int maxPathSumUtil_2(Node node) {
        if (node == null) return 0;

        int left = maxPathSumUtil_2(node.left);
        int right = maxPathSumUtil_2(node.right);

        if (node.left == null)
            return right + node.key;

        if (node.right == null)
            return left + node.key;

        int temp = Math.max(left, right) + node.key;
        res.val = Math.max(res.val, left + right + node.key);

        return temp;
    }
}

class Res{
    int val;
}