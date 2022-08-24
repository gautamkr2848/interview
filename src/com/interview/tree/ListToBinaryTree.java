package com.interview.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class ListToBinaryTree {

    public Node convertListToBinaryTree(com.interview.list.Node head) {
        if (head == null)
            return null;

        Node root = new Node(head.data);
        head = head.next;

        // create a queue to store tree pointers and enqueue the root node
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        // loop till the end of the linked list is reached
        while (head != null) {
            Node tmp = q.poll();
            tmp.left = new Node(head.data);
            q.add(tmp.left);
            head = head.next;

            if (head != null) {
                tmp.right = new Node(head.data);
                q.add(tmp.right);

                head = head.next;
            }
        }
        return root;
    }
}
