package com.interview.list;

public class Add_One {

    public void addOne(){
        Node head = new Node(1);
        head.next = new Node(9);
        head.next.next = new Node(9);
        head.next.next.next = new Node(9);

        int carry = addWithCarry(head);
        if (carry > 0) {
            Node newNode = new Node(carry);
            newNode.next = head;
            System.out.print(newNode);
        }
        System.out.print(head.data);
    }

    private int addWithCarry(Node head) {
        if (head == null)   // If linked list is empty, then return carry
            return 1;

        int res = head.data + addWithCarry(head.next);
        head.data = (res) % 10;
        return (res) / 10;
    }
}
