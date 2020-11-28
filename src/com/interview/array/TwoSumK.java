package com.interview.array;

import java.util.*;

public class TwoSumK {

    public void twoSumK(int[] a, int k){
        Set<Integer> s = new HashSet<Integer>();
        for(int i=0; i<a.length; i++){
            int temp = k - a[i];
            if (s.contains(temp))
                System.out.println(a[i] + ", " + temp);

            s.add(a[i]);
        }
    }
}
