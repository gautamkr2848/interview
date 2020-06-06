package com.interview.array;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;

public class LargestNumberFromArray {

    public void largestNumber(Vector<String> arr) {

        Collections.sort(arr, new Comparator<String>() {

            @Override
            public int compare(String X, String Y) {

                String XY = X + Y;  // first append Y at the end of X
                String YX = Y + X;  // then append X at the end of Y

                return XY.compareTo(YX) > 0 ? -1 : 1;
            }
        });

        Iterator it = arr.iterator();

        while (it.hasNext())
            System.out.print(it.next());
    }
}
