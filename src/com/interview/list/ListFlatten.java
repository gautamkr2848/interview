package com.interview.list;

/*
5 -> 10 -> 19 -> 28
|    |     |     |
7    20    22    35
|          |     |         ==>  5 -> 7 -> 8 -> 10 -> 19 -> 20 -> 22 -> 28 -> 30 -> 35 -> 40 -> 45 -> 50
8          50    40
|                |
30               45
*/

public class ListFlatten {

    class Node{
        int data;
        Node next, down;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.down = null;
        }
    }

    Node flatten(Node root) {
        if (root == null || root.next == null)
            return root;

        return merge(root, flatten(root.next));
    }

    // An utility function to merge two sorted linked lists
    private Node merge(Node a, Node b) {
        if (a == null)      return b;
        if (b == null)      return a;

        Node result;
        if (a.data < b.data) {
            result = a;
            result.down =  merge(a.down, b);
        } else {
            result = b;
            result.down = merge(a, b.down);
        }

        result.next = null;
        return result;
    }
}
