package com.interview.tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TreeBuild {

    public Node buildTree(int[] preorder, int[] inorder) {

        Set<Node> set = new HashSet<>();
        Stack<Node> stack = new Stack<>();

        Node root = null;
        for (int pre = 0, in = 0; pre < preorder.length;) {
            Node node = null;
            do {
                node = new Node(preorder[pre]);
                if (root == null)
                    root = node;

                if (!stack.isEmpty()) {
                    if (set.contains(stack.peek())) {
                        set.remove(stack.peek());
                        stack.pop().right = node;
                    } else
                        stack.peek().left = node;
                }
                stack.push(node);
            } while (preorder[pre++] != inorder[in] && pre < preorder.length);

            node = null;
            while (!stack.isEmpty() && in < inorder.length && stack.peek().key == inorder[in]) {
                node = stack.pop();
                in++;
            }

            if (node != null) {
                set.add(node);
                stack.push(node);
            }
        }

        return root;
    }
}
