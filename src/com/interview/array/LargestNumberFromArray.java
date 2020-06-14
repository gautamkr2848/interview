package com.interview.array;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;

public class LargestNumberFromArray {

    public void largestNumber(Vector<String> arr) {

        Collections.sort(arr, (x, y) -> (y+x).compareTo(x+y));

        Iterator it = arr.iterator();

        while (it.hasNext())
            System.out.print(it.next());
    }
}
