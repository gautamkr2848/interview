package com.interview.list;

public class SumOfLists {

    public void sumOfLists(Node a, Node b){
        Node result = null, prev = null, temp;
        int carry = 0, sum;

        while (a != null || b != null) {
            sum = carry + (a != null ? a.data : 0) + (b != null ? b.data : 0);
            carry = sum / 10;
            sum = sum % 10;
            temp = new Node(sum);

            if (result == null)
                result = temp;
            else
                prev.next = temp;

            prev = temp;

            if (a != null) a = a.next;
            if (b != null) b = b.next;
            if (carry > 0)
                temp.next = new Node(carry);
        }
        System.out.println(result);
    }
}

