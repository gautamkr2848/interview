package com.interview.tree;

public class BTToDLL {

    public void bTToDLL(Node root){

        Node prev = null, head;
        if (root == null)
            return;

        bTToDLL(root.left);     // Recursively convert left subtree

        if (prev == null)
            head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        bTToDLL(root.right);    // Finally convert right subtree
    }
}
