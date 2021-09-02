package com.interview.array.sort;

import java.util.Iterator;
import java.util.PriorityQueue;

public class KSmallerElements {

    public void FirstKelements() {
        int[] arr = {12,5,787,1,23};
        int size = arr.length;
        int k = 2;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < k; i++)
            minHeap.add(arr[i]);

        for(int i = k; i < size; i++) {

            if (minHeap.peek() > arr[i])
                continue;
            else {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        // Now min heap contains k maximum
        // elements, Iterate and print
        Iterator iterator = minHeap.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
