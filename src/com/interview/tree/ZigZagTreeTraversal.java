package com.interview.tree;

public class ZigZagTreeTraversal {

    public void zigZagTree(Node root){
        Boolean flag = true;
        int height = height(root);
        for(int i=1; i<=height; i++){
            printLevel(root, i, flag);
            flag = !flag;
        }
    }

    void printLevel(Node root, int level, Boolean flag){
        if(level == 1)
            System.out.println(root);
        else if(level > 1){
            if(flag){
                printLevel(root.left, level-1, flag);
                printLevel(root.right, level-1, flag);
            } else {
                printLevel(root.right, level-1, flag);
                printLevel(root.left, level-1, flag);
            }
        }
    }

    int height(Node root){
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

}
