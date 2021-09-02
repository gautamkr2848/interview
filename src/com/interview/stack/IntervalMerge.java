package com.interview.stack;

import java.util.Arrays;
import java.util.Stack;

public class IntervalMerge {
    public void mergeIntervals() {
        Interval arr[]=new Interval[4];
        arr[0]=new Interval(6,8);
        arr[1]=new Interval(1,9);
        arr[2]=new Interval(2,4);
        arr[3]=new Interval(4,7);

        if (arr.length <= 0)
            return;

        Stack<Interval> stack=new Stack<>();
        Arrays.sort(arr, (o1, o2) -> o1.start - o2.start);
        stack.push(arr[0]);

        for (int i = 1 ; i < arr.length; i++) {
            Interval top = stack.peek();

            if (top.end < arr[i].start)
                stack.push(arr[i]);
            else if (top.end < arr[i].end) {
                top.end = arr[i].end;
                stack.pop();
                stack.push(top);
            }
        }

        while (!stack.isEmpty()) {
            Interval t = stack.pop();
            System.out.print(t.start + " " + t.end);
        }
    }
}

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
