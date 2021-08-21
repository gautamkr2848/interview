package com.interview.array;

import java.util.*;

public class LargestNumberFromArray {

    public void largestNumber() {
        List<String> arr = new ArrayList<>();
        arr.add("2");
        arr.add("0");
        arr.add("0");
        arr.add("1");
        Collections.sort(arr, (o1, o2) -> (o2+o1).compareTo(o1+o2));

        Iterator it = arr.iterator();

        while (it.hasNext())
            System.out.print(it.next());
    }
}
