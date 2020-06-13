package com.interview.list;

class Node {
    public int data;
    public Node next;

    public Node(int d) {
        data = d;
        next = null;
    }
}

public class RemoveLoop {

    public int detectAndRemoveLoop(Node node) {
        Node slow = node, fast = node;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet at same point then loop is present
            if (slow == fast) {
                //removeLoop(slow, node);
                slow.next.next = null;
                return 1;
            }
        }
        return 0;
    }

    // Function to print the linked list
    public void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

}
