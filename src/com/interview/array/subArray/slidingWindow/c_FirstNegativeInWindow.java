package com.interview.array.subArray.slidingWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class c_FirstNegativeInWindow {

    public static void printFirstNegativeInteger2() {
        int arr[] = { 12, -1, -7, 8, 15, 30, -16, 28 };
        int k = 3;
        int n = arr.length;
        Deque<Integer> q = new LinkedList<>();
        int i;
        for (i = 0; i < k; i++) {
            if (arr[i] < 0)
                q.addLast(i);
        }

        for ( ; i < n; i++) {
            if (!q.isEmpty())
                System.out.print(arr[q.peekFirst()] + " ");
            else
                System.out.print("0" + " ");

            while ((!q.isEmpty()) && q.peekFirst() <= i - k )
                q.removeFirst();

            if (arr[i] < 0)
                q.addLast(i);
        }

        if (!q.isEmpty())
            System.out.print(arr[q.peekFirst()] + " ");
        else
            System.out.print("0" + " ");
    }

    public static void main(String[] args) {
        printFirstNegativeInteger2();
    }
}
