package com.interview.tree;

public class LCAForBST {

    public void lCAForBST(Node root, int n1, int n2){
        while (root != null) {
            if (root.key > n1 && root.key > n2)
                root = root.left;
            else if (root.key < n1 && root.key < n2)
                root = root.right;
            else break;
        }
        System.out.println(root);
    }

    public Node findLCA(Node node, int n1, int n2) {
        if (node == null)
            return null;

        if (node.key == n1 || node.key == n2)
            return node;

        Node left = findLCA(node.left, n1, n2);
        Node right = findLCA(node.right, n1, n2);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left!=null && right!=null)
            return node;

        return (left != null) ? left : right;
    }
}
