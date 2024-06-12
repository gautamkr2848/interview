package com.interview.tree;

import java.util.Stack;

public class IsMirror {

    public Boolean isMirror(Node node1, Node node2){
        if(node1 == null && node2 == null)
            return true;
        if(node1 == null || node2 == null)
            return false;
        return (node1.key == node2.key && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left));
    }

    //Time Complexity: O(n)
    //Auxiliary Space: O(h) where h is height of binary tree

    public boolean isMirrorIterative(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root1);
        s2.push(root2);

        while (!s1.empty() && !s2.empty()) {
            Node curr1 = s1.pop();
            Node curr2 = s2.pop();

            if (curr1.key != curr2.key)
                return false;

            if (curr1.left != null && curr2.right != null) {
                s1.push(curr1.left);
                s2.push(curr2.right);
            } else if (curr1.left != null || curr2.right != null)
                return false;

            if (curr1.right != null && curr2.left != null) {
                s1.push(curr1.right);
                s2.push(curr2.left);
            } else if (curr1.right != null || curr2.left != null)
                return false;
        }

        if (!s1.empty() || !s2.empty())
            return false;

        return true;
    }

    public boolean isMirrorIterative_2(Node root) {

        if(root == null)
            return true;

        Stack<Node> s1 = new Stack<>();
        s1.push(root.left);
        s1.push(root.right);

        while (!s1.empty()) {
            Node curr1 = s1.pop();
            Node curr2 = s1.pop();

            if(curr1 == null && curr2 == null)
                continue;
            if(curr1 != null || curr2 != null || curr1.key != curr2.key)
                return false;

            s1.push(curr1.left);
            s1.push(curr2.right);
            s1.push(curr1.right);
            s1.push(curr2.left);
        }

        return true;
    }

    //Time Complexity: O(n)
    //Auxiliary Space: O(h) where h is height of binary tree
}
