package com.interview.tree;

public class NodesAtDistanceFromLeaf {

    public void printNodes(){
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.right.left = new Node(5);
        root.right.right = new Node(9);
        root.left.left = new Node(4);
        root.left.left.left = new Node(25);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.left.left = new Node(15);
        root.left.right.left.right = new Node(18);
        root.left.right.left.right.right = new Node(23);
        root.left.right.right = new Node(14);

        printKDistantfromLeaf(root, 2);
    }

    private int printKDistantfromLeaf(Node node, int k) {
        if (node == null)
            return -1;
        
        int left = printKDistantfromLeaf(node.left, k);
        int right = printKDistantfromLeaf(node.right, k);

        boolean isLeaf = false;
        if(left == -1 && left == right)
            isLeaf = true;

        if (left == 0 || right == 0 || (isLeaf && k == 0))
            System.out.print(" " + node.key);
        if (isLeaf && k > 0)
            return k - 1; // leaf node
        if (left > 0 && left < k)
            return left - 1; // parent of left leaf
        if (right > 0 && right < k)
            return right - 1; // parent of right leaf

        return -2;
    }
}
