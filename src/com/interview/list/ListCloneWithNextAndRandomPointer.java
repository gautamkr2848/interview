package com.interview.list;

import java.util.HashMap;
import java.util.Map;

public class ListCloneWithNextAndRandomPointer {
    class Node {
        int data;
        Node next,random;
        Node(int x){
            data = x;
            next = random = null;
        }
    }

    public Node listCloneWithNextAndRandomPointer(Node head){

        Node curr1 = head;
        Node curr2 = null;
        Map<Node, Node> map = new HashMap<>();

        while (curr1 != null) {
            curr2 = new Node(curr1.data);
            map.put(curr1, curr2);
            curr1 = curr1.next;
        }

        curr1 = head;
        while (curr1 != null){
            curr2 = map.get(curr1);
            curr2.next = map.get(curr1.next);
            curr2.random = map.get(curr1.random);
            curr1 = curr1.next;
        }
        return map.get(head);
    }

    public Node cloneLinkedList(Node head) {
        if (head == null)
            return null;

        Node curr = head;       // Step 1: Create new nodes and insert them next to the original nodes
        while (curr != null) {
            Node newNode = new Node(curr.data);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        curr = head;        // Step 2: Set the random pointers of the new nodes
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;

            curr = curr.next.next;
        }

        curr = head;        // Step 3: Separate the new nodes from the original nodes
        Node clonedHead = head.next;
        Node clonedCurr = clonedHead;
        while (clonedCurr.next != null) {
            curr.next = curr.next.next;
            clonedCurr.next = clonedCurr.next.next;
            curr = curr.next;
            clonedCurr = clonedCurr.next;
        }
        curr.next = null;
        clonedCurr.next = null;

        return clonedHead;
    }


    /*1       2       3       4       5
          1       2       3       4       5*/
}
