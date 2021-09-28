package com.interview.array.sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallerElements {

    public void FirstKelements() {
        int[] arr = {12,5,787,1,23};
        int size = arr.length;
        int k = 2;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < k; i++)
            queue.add(arr[i]);

        for(int i = k; i < size; i++) {

            if (queue.peek() > arr[i])
                continue;
            else {
                queue.poll();
                queue.add(arr[i]);
            }
        }

        Iterator iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
