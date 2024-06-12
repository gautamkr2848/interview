package com.interview.tree.treeOrder;

import com.interview.tree.Node;

import java.util.Stack;

/*
                1
        2               3           => 4 5 2 6 3 1
    4       5       6
*/

public class c_PostOrder {

    public void postorder(Node node){
        if (node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.key + " ");
    }

    public static void postOrder2(Node root){
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        if (root == null)
            return;

        s1.push(root);
        while (!s1.isEmpty()) {
            Node temp = s1.pop();
            s2.push(temp);

            if (temp.left != null)
                s1.push(temp.left);
            if (temp.right != null)
                s1.push(temp.right);
        }

        while (!s2.isEmpty()) {
            Node temp = s2.pop();
            System.out.print(temp.key + " ");
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right = new Node(3);
        node.right.left = new Node(6);

        postOrder2(node);
    }

}
