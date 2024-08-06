package com.interview.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NonOverlappingInterval {

    static int minRemoval(int N, int intervals[][]) {
        List<Pair> pairs = new ArrayList<>();
        for(int i=0; i<intervals.length; i++) {
            pairs.add(new Pair(intervals[i][0], intervals[i][1]));
        }

        Collections.sort(pairs, (o1, o2) -> o1.y.compareTo(o2.y));

        int count = 1, limit = pairs.get(0).y;

        for(int i=1; i<pairs.size(); i++) {
            if(pairs.get(i).x >= limit) {
                count++;
                limit = pairs.get(i).y;
            }
        }

        return N - count;
    }

}

class Pair{
    Integer x;
    Integer y;

    Pair(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
}
