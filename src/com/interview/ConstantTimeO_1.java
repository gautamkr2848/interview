package com.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class ConstantTimeO_1 {

    ArrayList<Integer> arr;
    HashMap<Integer, Integer> map;

    public ConstantTimeO_1() {
        arr = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }

    void add(int x) {
        if (map.get(x) != null)
            return;

        int s = arr.size();
        arr.add(x);
        map.put(x, s);
    }

    void remove(int x) {
        Integer index = map.get(x);
        if (index == null)
            return;
        map.remove(x);

        // Swap element with last element so that remove from
        // arr[] can be done in O(1) time
        int size = arr.size();
        Integer last = arr.get(size-1);
        Collections.swap(arr, index,  size-1);
        arr.remove(size-1);     // Remove last element
        map.put(last, index);     // Update hash table for new index of last element
    }

    int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(arr.size());
        return arr.get(index);  // Return element at randomly picked index
    }

    Integer search(int x) {
        return map.get(x);
    }
}
