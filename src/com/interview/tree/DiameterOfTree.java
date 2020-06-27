package com.interview.tree;

public class DiameterOfTree {

    public int diameter(Node root){
        if (root == null)
            return 0;

        int lheight = height(root.left);
        int rheight = height(root.right);
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);

        return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
    }

    int height(Node node){
        if (node == null)
            return 0;
        return (1 + Math.max(height(node.left), height(node.right)));
    }
}
