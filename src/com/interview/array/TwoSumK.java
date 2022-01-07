package com.interview.array;

import java.util.*;

public class TwoSumK {

    public void twoSumK(int[] a, int sum){
        Set<Integer> s = new HashSet<>();
        for(int i=0; i<a.length; i++){
            if (s.contains(sum - a[i]))
                System.out.println(a[i] + ", " + (sum - a[i]));

            s.add(a[i]);
        }
    }
}
