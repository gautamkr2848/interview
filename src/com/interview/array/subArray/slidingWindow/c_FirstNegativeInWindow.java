package com.interview.array.subArray.slidingWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class c_FirstNegativeInWindow {

    public static void printFirstNegativeInteger() {
        int arr[] = { 12, -1, -7, 8, 15, 30, -16, 28 };
        int k = 3;
        Deque<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            if (!q.isEmpty() && q.peekFirst() <= i - k)
                q.removeFirst();

            if (arr[i] < 0)
                q.addLast(i);

            if (i >= k - 1) {
                if (!q.isEmpty()) {
                    System.out.print(arr[q.peekFirst()] + " ");
                } else {
                    System.out.print("0 ");
                }
            }
        }
    }

    public static void main(String[] args) {
        printFirstNegativeInteger();
    }

    public void printFirstNegativeInteger_2() {
        int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        Deque<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        int i;
        for (i = 0; i < k; i++)
            if (arr[i] < 0)
                q.addLast(i);

        for (; i < arr.length; i++) {
            if (q.peek() != null)
                result.add(arr[q.peek()]);

            while (!q.isEmpty() && q.peek() <= i - k)       // Remove the elements which are out of this window
                q.removeFirst();

            while (!q.isEmpty() && arr[q.peekLast()] >= 0)      // remove useless elements
                q.removeLast();

            q.addLast(i);
        }
    }
}
