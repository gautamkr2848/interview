package com.interview.array.priorityQueue_heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class g_MideanOfRunningInt {

    public void printMedian() {

        int[] a = { 5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };
        double med = a[0];

        PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> greater = new PriorityQueue<>();

        smaller.add(a[0]);
        System.out.println(med);

        for(int i = 1; i < a.length; i++) {
            int x = a[i];

            if(smaller.size() > greater.size()) {
                if(x < med) {
                    greater.add(smaller.remove());
                    smaller.add(x);
                } else
                    greater.add(x);

                med = (double)(smaller.peek() + greater.peek())/2;

            } else if(smaller.size() == greater.size()) {
                if(x < med) {
                    smaller.add(x);
                    med = (double)smaller.peek();
                } else {
                    greater.add(x);
                    med = (double)greater.peek();
                }
            } else {
                if(x > med) {
                    smaller.add(greater.remove());
                    greater.add(x);
                } else
                    smaller.add(x);

                med = (double)(smaller.peek() + greater.peek())/2;
            }
            System.out.println(med);
        }
    }

    public void streamMed() {
        int A[] = { 5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };
        int N = A.length;

        PriorityQueue<Double> greater = new PriorityQueue<>();
        PriorityQueue<Double> smaller = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {

            smaller.add(-1.0 * A[i]);
            greater.add(-1.0 * smaller.poll());

            if (greater.size() > smaller.size())
                smaller.add(-1.0 * greater.poll());

            if (greater.size() != smaller.size())
                System.out.print((-1.0 * smaller.peek()) + "     ");
            else
                System.out.print(((greater.peek() - smaller.peek()) / 2) + "     ");
        }
    }
}
