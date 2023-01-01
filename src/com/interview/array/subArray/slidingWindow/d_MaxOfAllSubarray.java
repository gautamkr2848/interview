package com.interview.array.subArray.slidingWindow;

/*Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
        k = window size
        Output: 3 3 4 5 5 5 6*/

import java.util.Deque;
import java.util.LinkedList;

public class d_MaxOfAllSubarray {

    public void maxOfAllSubarray(){
        int[] a = {1, 3, -3, 5, 3, 6, 7};
        int k = 3;
        int max = 0;

        for (int i = 0; i <= a.length - k; i++) {
            max = a[i];
            for (int j = 1; j < k; j++)
                max = a[i+j] > max ? a[i+j] : max;
            System.out.print(max + " ");
        }
    }

    public void maxOfAllSubarray_2(){
        int[] arr = {1, 3, -3, 5, 3, 6, 7};
        int k = 3;

        Deque<Integer> q = new LinkedList<>();
        int i;
        for (i = 0; i < k; i++) {
            while (!q.isEmpty() && arr[q.peekLast()] <= arr[i])     // remove useless elements
                q.removeLast();
            q.addLast(i);
        }

        for (; i < arr.length; i++) {
            System.out.print(arr[q.peek()] + " ");   // largest element is at the front of the queue
            while (!q.isEmpty() && q.peek() <= i - k)    // Remove the elements which are out of this window
                q.removeFirst();

            while (!q.isEmpty() && arr[q.peekLast()] <= arr[i])       // remove useless elements
                q.removeLast();

            q.addLast(i);
        }
        System.out.print(arr[q.peek()]);
    }
}
