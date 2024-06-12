package com.interview.array.priorityQueue_heap;

import java.util.Objects;
import java.util.PriorityQueue;

//Given a sorted array arr[] and a value X, find the k closest elements to X in arr[].
//
//Input: K = 4, X = 35
//       arr[] = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56}
//Output: 30 39 42 45

public class e_KClosestNumber {

    public void kClosestNumber(){

        int arr[] = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        int n = arr.length;
        int x = 35, k = 4;

        PriorityQueue<Value> pq = new PriorityQueue<>((o1, o2) -> o2.x.compareTo(o1.x));
        for(int i=0; i<k; i++)
            if(arr[i] != x)
                pq.add(new Value(Math.abs(arr[i] - x), arr[i]));

        for(int i=k; i<n; i++) {
            if(arr[i] != x) {
                pq.add(new Value(Math.abs(arr[i] - x), arr[i]));
                if (pq.size() > k)
                    pq.poll();
            }
        }

        while (!pq.isEmpty())
            System.out.print(pq.poll().y + " ");
    }
}

class Value implements Comparable<Value>{
     Integer x;
     Integer y;

     public Value(int x, int y){
         this.x = x;
         this.y = y;
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Value value = (Value) o;
        return Objects.equals(x, value.x) && Objects.equals(y, value.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }


    @Override
    public int compareTo(Value o) {
        int x1 = x * x;
        int y1 = y * y;
        int x2 = o.x * o.x;
        int y2 = o.y * o.y;
        return (x1 + y1) - (x2 + y2);
    }
}
