package com.interview.list;

public class ListUnionAndIntersection {

    static Node head;
    public Node findUnion(Node head1, Node head2) {
        Node t1 = head1, t2 = head2;

        while (t1 != null) {
            push(t1.data);
            t1 = t1.next;
        }

        while (t2 != null) {
            if (!isPresent(head, t2.data))
                push(t2.data);
            t2 = t2.next;
        }
        return head;

    }

    private boolean isPresent(Node head, int data) {
        Node t = head;
        while (t != null) {
            if (t.data == data)
                return true;
            t = t.next;
        }
        return false;
    }

    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
}
