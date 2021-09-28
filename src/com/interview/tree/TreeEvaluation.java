package com.interview.tree;

public class TreeEvaluation {

    public int evalTree(Node root) {
        if (root == null)
            return 0;

        if (isLeaf(root))
            return root.key;

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

    public static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }
}
