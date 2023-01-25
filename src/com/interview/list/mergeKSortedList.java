package com.interview.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class mergeKSortedList {

    public Node mergeKLists_2(Node[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(Arrays.asList(lists).subList(0, lists.length));  // push the first node of each list into the min-heap

        Node head = null;   // head points to the first node of the output list
        Node last = null;   // tail points to its last node

        while (!pq.isEmpty()) {
            Node min = pq.poll();

            if (head == null)      // add the minimum node to the output list
                head = last = min;
            else {
                last.next = min;
                last = min;
            }

            if (min.next != null)       // take the next node from the "same" list and insert it into the min-heap
                pq.add(min.next);
        }
        return head;
    }
}
