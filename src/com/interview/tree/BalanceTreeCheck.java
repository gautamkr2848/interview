package com.interview.tree;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BalanceTreeCheck {

    public Boolean isBalanced(Node root){
        if(root == null)
            return true;
        int left = height(root.left);
        int right = height(root.right);

        if (isBalanced(root.right) && isBalanced(root.left)
                && Math.abs(left - right) <= 1)
            return true;
        return false;
    }

    private int height(Node root){
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
