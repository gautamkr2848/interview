package com.interview.list;

public class mergeKSortedList {

    public Node mergeKLists(Node[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        int last = lists.length - 1;

        while (last != 0) {
            int i = 0, j = last;

            while (i < j) {
                lists[i] = sortedMerge(lists[i], lists[j]);
                i++;
                j--;

                if (i >= j)
                    last = j;
            }
        }
        return lists[0];
    }

    private  Node sortedMerge(Node a, Node b) {

        if (a == null) return b;
        if (b == null) return a;

        Node result;

        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }
}
