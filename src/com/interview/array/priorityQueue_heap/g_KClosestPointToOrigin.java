package com.interview.array.priorityQueue_heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class g_KClosestPointToOrigin {

    public void kClosestPoints(int x[], int y[], int n, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++)
            pq.add(new Pair(x[i], y[i]));

        for(int i = 0; i < k; i++) {
            Pair p = pq.poll();
            System.out.println(p.first + " " + p.second);
        }
    }

    public void kClosest(int[][] pts, int k) {

        int[] distance = new int[pts.length];
        for(int i = 0; i < pts.length; i++) {
            int x = pts[i][0], y = pts[i][1];
            distance[i] = (x * x) + (y * y);
        }

        Arrays.sort(distance);
        int distk = distance[k - 1];

        for(int i = 0; i < pts.length; i++) {
            int x = pts[i][0], y = pts[i][1];
            int dist = (x * x) + (y * y);

            if (dist <= distk)
                System.out.println("[" + x + ", " + y + "]");
        }
    }
}

class Pair implements Comparable<Pair> {
    int first, second;

    Pair(int a, int b) {
        first = a;
        second = b;
    }

    public int compareTo(Pair o) {
        int x1 = first * first;
        int y1 = second * second;
        int x2 = o.first * o.first;
        int y2 = o.second * o.second;
        return (x1 + y1) - (x2 + y2);
    }
}
