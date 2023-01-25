package com.interview.stack;

import java.util.*;

public class IntervalMerge {

    private static void mergeIntervals(Interval[] a){
        List<Interval> list = Arrays.asList(a);
        Collections.sort(list, (o1, o2) -> o1.start.compareTo(o2.start));

        Stack<Interval> stk = new Stack<>();
        stk.push(list.get(0));
        for (int i = 1 ; i < list.size(); i++) {

            Interval top = stk.peek();

            if (top.end < list.get(i).start)
                stk.push(list.get(i));
            else if (top.end < list.get(i).end) {
                top.end = list.get(i).end;
                stk.pop();
                stk.push(top);
            }
        }

        // Print contents of stack
        System.out.print("The Merged Intervals are: ");
        while (!stk.isEmpty()) {
            Interval t = stk.pop();
            System.out.print("["+t.start+","+t.end+"] ");
        }
    }
}

class Interval {
    Integer start,end;
    Interval(Integer start, Integer end) {
        this.start=start;
        this.end=end;
    }
}
