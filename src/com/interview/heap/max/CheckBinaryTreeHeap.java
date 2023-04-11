package com.interview.heap.max;

import com.interview.tree.Node;

//Given a binary tree, check if it has heap property or not, Binary tree needs to fulfill the following two conditions for being a heap –

//It should be a complete tree (i.e. all levels except the last should be full).
//Every node’s value should be greater than or equal to its child node (considering max-heap).

public class CheckBinaryTreeHeap {

    public boolean isHeap(Node root) {
        if (root == null)
            return true;

        int node_count = countNodes(root);
        if (isCompleteUtil(root, 0, node_count) && isHeapUtil(root))
            return true;
        return false;
    }

    private int countNodes(Node root) {
        if (root == null)
            return 0;
        return (1 + countNodes(root.left) + countNodes(root.right));
    }

    // This function checks if the binary tree is complete or not
    private boolean isCompleteUtil(Node root, int index, int number_nodes) {
        if (root == null)       // An empty tree is complete
            return true;

        // If index assigned to current node is more than number of nodes in tree,  then tree is not complete
        if (index >= number_nodes)
            return false;

        return isCompleteUtil(root.left, 2 * index + 1, number_nodes)
                && isCompleteUtil(root.right, 2 * index + 2, number_nodes);
    }

    // This Function checks the heap property in the tree.
    private boolean isHeapUtil(Node root) {

        if (root.left == null && root.right == null)        //  Base case : single node satisfies property
            return true;

        if (root.right == null)   //  check heap property at Node No recursive call , because no need to check last level
            return root.key >= root.left.key;
        else  //  Check heap property at Node and Recursive check heap property at left and right subtree
            if (root.key >= root.left.key && root.key >= root.right.key)
                return isHeapUtil(root.left) && isHeapUtil(root.right);
            else
                return false;
    }
}
