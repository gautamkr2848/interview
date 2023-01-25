package com.interview.list;

public class ListUnionAndIntersection {

    static Node head;
    public void getUnion(Node head1, Node head2) {

        Node t1 = head1, t2 = head2;

        while (t1 != null) {    // insert all elements of list1 in the result
            push(t1.data);
            t1 = t1.next;
        }

        while (t2 != null) {    // insert all elements of list2 in the result
            if (!isPresent(head, t2.data))
                push(t2.data);
            t2 = t2.next;
        }
    }

    void getIntersection(Node head1, Node head2) {
        Node result = null;
        Node t1 = head1;

        while (t1 != null) {
            if (isPresent(head2, t1.data))
                push(t1.data);
            t1 = t1.next;
        }
    }


    private void push(int new_data) {   /*  Inserts a node at start of linked list */
        Node node = new Node(new_data);
        node.next = head;
        head = node;
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
}
