package com.interview.stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IntervalMerge {

    public int[][] mergeInterval() {
        int[][] intervals = {{1, 4}, {0, 4}};
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {

            if (merged.isEmpty() || merged.get(merged.size()-1)[1] < interval[0])
                merged.add(interval);
            else
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1], interval[1]);
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
