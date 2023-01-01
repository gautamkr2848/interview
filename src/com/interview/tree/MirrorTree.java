package com.interview.tree;

public class MirrorTree {

    public Node convertMirrorTree(Node node) {

        if(node == null)
                return node;

        Node left = convertMirrorTree(node.left);
        Node right = convertMirrorTree(node.right);

        node.left = right;
        node.right = left;

        return node;
    }
}
