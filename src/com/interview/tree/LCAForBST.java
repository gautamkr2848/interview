package com.interview.tree;

import java.util.List;

public class LCAForBST {

    public void lCAForBST(Node root, int n1, int n2){
        while (root != null) {
            if (root.key > n1 && root.key > n2)
                root = root.left;
            else if (root.key < n1 && root.key < n2)
                root = root.right;
            else break;
        }
        System.out.println(root);
    }

    public Node findLCA(Node node, int n1, int n2) {

        if (node == null || node.key == n1 || node.key == n2)
            return node;

        Node left = findLCA(node.left, n1, n2);
        Node right = findLCA(node.right, n1, n2);

        if(left == null)
            return right;
        else if(right == null)
            return left;
        else
            return node;
    }

    public int findLCA_2(Node node, int n1, int n2){
        BTPath btPath = new BTPath();
        List<Integer> path1 = btPath.findPath(node, n1);
        List<Integer> path2 = btPath.findPath(node, n2);

        int res = -1;
        for(int i=0; i<path1.size(); i++){
            res = path1.get(i);
            if(path1.get(i) == path2.get(i))
                continue;
            else
                break;
        }
        return res;
    }
}

