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

    public int getPairsCount(int arr[], int n, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (m.containsKey(k - arr[i]))
                count = count + m.get(k - arr[i]);

            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        }
        return count;
    }
}