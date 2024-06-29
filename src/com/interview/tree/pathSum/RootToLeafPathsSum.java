package com.interview.tree.pathSum;

/*
Input :
          6
        /   \
       3     5
     /   \     \
    2     5      4
         /  \
        7    4

        Output: 13997

        Explanation :
        There are 4 leaves, hence 4 root to leaf paths:
        Path                      Number
        6->3->2                   632
        6->3->5->7                6357
        6->3->5->4                6354
        6->5>4                    654
        Answer = 632 + 6357 + 6354 + 654 = 13997
*/

import com.interview.tree.Node;

public class RootToLeafPathsSum {

    public static void rootToLeafPathsSum(Node root){
        System.out.print(treePathsSumUtil(root, 0));
    }

    private static int treePathsSumUtil(Node node, int val) {
        if (node == null)
            return 0;
        val = (val * 10 + node.key);

        if (node.left == null && node.right == null)
            return val;

        return treePathsSumUtil(node.left, val) + treePathsSumUtil(node.right, val);
    }

    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(3);
        node.left.left = new Node(2);
        node.left.right = new Node(4);

        node.right = new Node(7);
        node.right.left = new Node(6);

        rootToLeafPathsSum(node);
    }
}