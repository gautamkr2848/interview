package com.interview.tree;

/*Input:
        Inorder traversal in[] = {4, 2, 5, 1, 3, 6}
        Preorder traversal pre[] = {1, 2, 4, 5, 3, 6}

        Output:
        Postorder traversal is {4, 5, 2, 6, 3, 1}*/

public class Postorder_Pre_In {

    int preIndex = 0;
    public void postorder_Pre_In(int[] inorder, int[] preorder, int start, int end){
        if (start > end)
            return;

        int index = search(inorder, start, end, preorder[preIndex++]);       // Find index of next item in preorder traversal in inorder
        postorder_Pre_In(inorder, preorder, start, index - 1);     // traverse left tree
        postorder_Pre_In(inorder, preorder, index + 1, end);      // traverse right tree

        System.out.print(inorder[index] + " ");
    }

    private int search(int[] in, int startIn, int endIn, int data) {
        int i = 0;
        for (i = startIn; i < endIn; i++)
            if (in[i] == data)
                return i;
        return i;
    }
}
