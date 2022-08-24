package com.interview.dynamic.tree;

import com.interview.tree.Node;

public class d_RootToLeaf {

    int maxSum = Integer.MIN_VALUE;
    Node maxLeaf=null;

    public void maxPathSumRootToLeafUtil(Node root, int sum) {
        if (root != null) {
            sum = sum + root.key;
            if (sum > maxSum && root.left == null && root.right == null) {
                maxLeaf = root;
                maxSum = sum;
            }
            maxPathSumRootToLeafUtil(root.left, sum);
            maxPathSumRootToLeafUtil(root.right, sum);
        }
    }

    public Boolean path(Node root, Node leaf){      //leaf = maxLeaf
        if(root==null) return false;
        if ((root == leaf) || path(root.left, leaf) || path(root.right, leaf) ) {
            System.out.print(" " + root.key);
            return true;
        }
        return false;
    }
}
