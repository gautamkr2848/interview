package com.interview.dynamic.tree;

class Node {

    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class TreeDiameter {

    public int diameterUtil(Node root, int result){
        if(root == null)
            return 0;

        int left = diameterUtil(root.left, result);
        int right = diameterUtil(root.right, result);

        int temp = Math.max(left, right) + 1;
        int ans = Math.max(temp, left + right + 1);
        result = Math.max(result, ans);

        return temp;
    }
}
