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

class Node_Flatten{
    int data;
    Node_Flatten next, down;

    public Node_Flatten(int data){
        this.data = data;
        this.next = null;
        this.down = null;
    }
}

public class ListFlatten {

    Node_Flatten flatten(Node_Flatten root) {
        if (root == null || root.next == null)
            return root;

        return merge(root, flatten(root.next));
    }

    // An utility function to merge two sorted linked lists
    private Node_Flatten merge(Node_Flatten a, Node_Flatten b) {
        if (a == null)      return b;
        if (b == null)      return a;

        Node_Flatten result;
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
