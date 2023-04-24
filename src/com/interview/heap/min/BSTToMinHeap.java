package com.interview.heap.min;

// Given a binary search tree which is also a complete binary tree. The problem is to convert the given BST into a Min
// Heap with the condition that all the values in the left subtree of a node should be less than all the values in the
// right subtree of the node. This condition is applied to all the nodes, in the resultant converted Min Heap.

/*
Follow the given steps to solve the problem:

Create a list.
Perform the inorder traversal of the BST and copy the node values in the list in sorted order.
Now perform the preorder traversal of the tree.
While traversing the root during the preorder traversal, one by one copy the values from the array arr[] to the nodes
of the BST.
*/

import com.interview.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class BSTToMinHeap {

    static int index = 0;

    public void BSTToMinHeap(String[] args) {

        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        System.out.println( "Preorder Traversal Before Conversion :");
        preOrder(root);

        convertToMinHeap(root);

        System.out.println("Preorder Traversal After Conversion :");
        preOrder(root);
    }

    private void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.key + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private void convertToMinHeap(Node root) {
        List<Integer> arr = new ArrayList<>();
        bstToArray(root, arr);
        arrToMinHeap(root, arr);
    }

    private void bstToArray(Node root, List<Integer> arr) {
        if (root == null)       // ArrayList stores elements in inorder fashion
            return;

        bstToArray(root.left, arr);
        arr.add(root.key);
        bstToArray(root.right, arr);
    }

    private void arrToMinHeap(Node root, List<Integer> arr) {
        if (root == null)
            return;
        root.key = arr.get(index++);

        arrToMinHeap(root.left, arr);
        arrToMinHeap(root.right, arr);
    }
}
