package com.interview.graph.DFS;

import com.interview.tree.Node;

import java.util.HashMap;
import java.util.Map;

public class TreeLongestZigZag {

    static int ans = 0;

    public static int longestZigZag(Node root) {
        dfs(root.left, true, 1);
        dfs(root.right, false, 1);
        return ans;
    }

    public static void dfs(Node root, boolean left, int count) {
        if (root == null) return;
        ans = Math.max(count, ans);
        dfs(root.left, true, left ? 1 : count+1);
        dfs(root.right, false, left ? count+1 : 1);
    }

    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(3);
        node.right = new Node(7);
        node.left.right = new Node(2);

        System.out.println(longestZigZag(node));
    }
}
