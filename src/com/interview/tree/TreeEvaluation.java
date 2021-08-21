package com.interview.tree;

public class TreeEvaluation {

    class Node{
        private String key;
        private com.interview.tree.Node left, right;

        public Node(String item){
            key = item;
            left = right = null;
        }
    }

    public int evalTree(com.interview.tree.Node root) {
        if (root == null)
            return 0;

        if (isLeaf(root))
            return Integer.valueOf(root.key);

        int x = evalTree(root.left);
        int y = evalTree(root.right);

        return process(String.valueOf(root.key), x, y);
    }

    public static int process(String op, int x, int y){
        if (op == "+") { return x + y; }
        if (op == "-") { return x - y; }
        if (op == "×") { return x * y; }
        if (op == "/") { return x / y; }

        return 0;
    }

    public static boolean isLeaf(com.interview.tree.Node node) {
        return node.left == null && node.right == null;
    }
}
