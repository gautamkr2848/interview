package com.interview.array;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MissingSmallestPositiveNo {

    public int solution() {
        Integer A[] = { 0, 10, 2, -10, -20 };

        Set<Integer> distinct = new HashSet<>();
        Collections.addAll(distinct, A);

        int index = 1;
        while (true) {
            if (!distinct.contains(index)) {
                return index;
            }
            index++;
        }
    }
}
