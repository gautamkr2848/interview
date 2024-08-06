package com.interview.array.pairCount;

// Count pairs (i, j) from an array such that i < j and arr[j] – arr[i] = X * (j – i)

import java.util.HashMap;

public class c_PairCount {

    static void countPairs(int arr[], int n, int x) {

        int count = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i < n; i++) {        // Stores count of distinct values of arr[i] - x * i
            mp.put(arr[i] - x * i, mp.getOrDefault(arr[i] - x * i, 0) + 1);
        }

        for(int v : mp.values()) {
            count = count + (v * (v - 1)) / 2;
        }

        System.out.println(count);
    }
}
