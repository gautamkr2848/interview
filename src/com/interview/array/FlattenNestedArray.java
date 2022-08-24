package com.interview.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlattenNestedArray {

    public Integer[] flatten(Object[] a){

        if (a == null) return null;

        List<Integer> flatList = new ArrayList<Integer>();

        for (Object element : a) {
            if (element instanceof Integer) {
                flatList.add((Integer) element);
            } else if (element instanceof Object[]) {
                flatList.addAll(Arrays.asList(flatten((Object[]) element)));
            } else {
                throw new IllegalArgumentException("Input must be an array of Integers or nested arrays of Integers");
            }
        }
        return flatList.toArray(new Integer[flatList.size()]);
    }
}
