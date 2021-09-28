package com.interview.array;

import java.util.HashSet;
import java.util.Set;

public class TripletSum {

    public static boolean find3Numbers(int A[], int n, int sum) {
        for (int i = 0; i < n - 2; i++) {

            Set<Integer> s = new HashSet<>();
            int curr_sum = sum - A[i];
            for (int j = i + 1; j < n; j++){
                if (s.contains(curr_sum - A[j]))
                    return true;

                s.add(A[j]);
            }
        }
        return false;
    }
}
