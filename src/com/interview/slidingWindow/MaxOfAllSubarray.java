package com.interview.slidingWindow;

import java.util.Deque;
import java.util.LinkedList;

public class MaxOfAllSubarray {

    public void maxOfAllSubarray(){
        int[] a = {1, 3, -3, 5, 3, 6, 7};
        int k = 3;
        int max = 0;

        for (int i = 0; i <= a.length - k; i++) {
            max = a[i];
            for (int j = 1; j < k; j++) {
                if (a[i + j] > max)
                    max = a[i + j];
            }
            System.out.print(max + " ");
        }
    }

    public void maxOfAllSubarray_2(){
        int[] arr = {1, 3, -3, 5, 3, 6, 7};
        int k = 3;

        Deque<Integer> q = new LinkedList<>();
        int i;
        for (i = 0; i < k; i++) {
            while (!q.isEmpty() && arr[i] >= arr[q.peekLast()])     //the previous smaller elements are useless so remove them from Queue
                q.removeLast();     // Remove from rear
            q.addLast(i);       // Add new element at rear of queue
        }

        for (; i < arr.length; i++) {
            System.out.print(arr[q.peek()] + " ");   // The element at the front of the queue is the largest element of previous window
            while (!q.isEmpty() && q.peek() <= i - k)         // Remove the elements which are out of this window
                q.removeFirst();

            while (!q.isEmpty() && arr[i] >= arr[q.peekLast()])       // remove useless elements
                q.removeLast();

            q.addLast(i);       // Add current element at the rear of Qi
        }
        System.out.print(arr[q.peek()]);
    }
}
