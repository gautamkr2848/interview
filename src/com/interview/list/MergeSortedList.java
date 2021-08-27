package com.interview.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedList {

    public void mergeSortedList(){
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(5);
        list1.add(7);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);

        List<Integer> list3 = new ArrayList<>();

        int i=0;
        int j=0;
        while(i<list1.size() && j<list2.size()){
            if(list1.get(i) < list2.get(j))
                list3.add(list1.get(i++));
            else
                list3.add(list2.get(j++));
        }

        while(i< list1.size())
            list3.add(list1.get(i++));
        while (j < list2.size())
            list3.add(list2.get(j++));

        System.out.println(list3.toString());
    }

    public Node mergeKLists_2(Node arr[], int last) {    //last = k-1;
        while (last != 0) {
            int i = 0, j = last;

            while (i < j) {
                arr[i] = SortedMerge(arr[i++], arr[j--]);
                if (i >= j)
                    last = j;
            }
        }
        return arr[0];
    }

    private Node SortedMerge(Node a, Node b) {
        Node result = null;

        if (a == null)
            return b;
        else if (b == null)
            return a;

        if (a.data <= b.data) {
            result = a;
            result.next = SortedMerge(a.next, b);
        } else {
            result = b;
            result.next = SortedMerge(a, b.next);
        }

        return result;
    }
}


