package com.interview.tree;

class Node {
    int key;
    Node left, right;

    public Node(int item){
        key = item;
        left = right = null;
    }
}

public class BinaryTree {

    Node root;

    BinaryTree(){
        root = null;
    }
}
