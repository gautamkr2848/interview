package com.interview.array.sumProblems;

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

    public static void getPairsCount(int arr[], int n, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (m.containsKey(k - arr[i]))
                count = count + m.get(k - arr[i]);

            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        }
        System.out.println(count);
    }

    public static void printPairs(int[] arr, int n, int sum) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int remaining = sum - arr[i];

            if (remaining == arr[i]) {
                if (m.containsKey(remaining) && m.get(remaining) == 1) {
                    System.out.println(remaining + " " + arr[i]);
                }
            } else if (m.containsKey(remaining) && !m.containsKey(arr[i])) {
                System.out.println(remaining + " " + arr[i]);
            }
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 7, -1, 3, 3, 3};
        getPairsCount(a, a.length, 6);
    }
}