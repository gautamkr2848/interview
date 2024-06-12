package com.interview.tree;

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

public class RootToLeafPathsSum {

    public void RootToLeafPathsSum(Node root){
        System.out.print(treePathsSumUtil(root, 0));
    }

    private int treePathsSumUtil(Node node, int val) {
        if (node == null)
            return 0;
        val = (val * 10 + node.key);

        if (node.left == null && node.right == null)
            return val;

        return treePathsSumUtil(node.left, val) + treePathsSumUtil(node.right, val);
    }
}