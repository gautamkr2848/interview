package com.interview.list;

public class AddTwoNumbers {

    public Node addTwoNumbers(Node l1, Node l2) {
        int carry = 0;

        Node head = new Node(-1);
        Node l = head;

        while(l1 != null || l2 != null){
            int a = l1 != null ? l1.data : 0;
            int b = l2 != null ? l2.data : 0;

            int data = carry + a + b;
            carry = 0;

            if(data > 9){
                carry = data / 10;
                data = data % 10;
            }
            Node tmp = new Node(data);
            head.next = tmp;
            head = head.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if(carry != 0){
            Node tmp = new Node(carry);
            head.next = tmp;
        }

        return l.next;
    }
}
