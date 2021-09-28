package com.interview.tree;

public class IsSubTree {

    public boolean isSubtree(Node T, Node S) {
        if (S == null)
            return true;

        if (T == null)
            return false;

        if (areIdentical(T, S))
            return true;

        return isSubtree(T.left, S) || isSubtree(T.right, S);
    }

    private boolean areIdentical(Node root1, Node root2){
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        return (root1.key == root2.key
                && areIdentical(root1.left, root2.left)
                && areIdentical(root1.right, root2.right));
    }
}
