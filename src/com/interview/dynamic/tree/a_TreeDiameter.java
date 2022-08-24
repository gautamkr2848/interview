package com.interview.dynamic.tree;

import com.interview.tree.Node;

public class a_TreeDiameter {

    public void treeDiameter(Node node){
        int result = Integer.MIN_VALUE;
        diameterUtil(node, result);
        System.out.println(result);
    }

    private int diameterUtil(Node root, int result){
        if(root == null)
            return 0;

        int left = diameterUtil(root.left, result);
        int right = diameterUtil(root.right, result);

        int temp = Math.max(left, right) + 1;
        int ans = Math.max(temp, left + right + 1);
        result = Math.max(result, ans);

        return temp;
    }

    public int diameter_2(Node root){
        if (root == null)
            return 0;

        int lheight = height(root.left);
        int rheight = height(root.right);
        int ldiameter = diameter_2(root.left);
        int rdiameter = diameter_2(root.right);

        return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
    }

    int height(Node node){
        if (node == null)
            return 0;
        return (1 + Math.max(height(node.left), height(node.right)));
    }
}
