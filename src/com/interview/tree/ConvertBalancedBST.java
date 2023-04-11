package com.interview.tree;

import java.util.ArrayList;
import java.util.List;

public class ConvertBalancedBST {

    public Node buildTree(Node root) {
        List<Node> nodes = new ArrayList<>();
        storeBSTNodes(root, nodes);

        int n = nodes.size();
        return buildTreeUtil(nodes, 0, n - 1);
    }

    private void storeBSTNodes(Node root, List<Node> nodes) {
        if (root == null)
            return;

        storeBSTNodes(root.left, nodes);
        nodes.add(root);
        storeBSTNodes(root.right, nodes);
    }

    private Node buildTreeUtil(List<Node> nodes, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;    /* Get the middle element and make it root */
        Node node = nodes.get(mid);

        node.left = buildTreeUtil(nodes, start, mid - 1);
        node.right = buildTreeUtil(nodes, mid + 1, end);

        return node;
    }

}
