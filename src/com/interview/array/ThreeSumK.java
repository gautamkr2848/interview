package com.interview.array;

import java.util.HashSet;
import java.util.Set;

public class ThreeSumK {

    public boolean find3Numbers(int A[], int n, int k) {
        for (int i = 0; i < n - 2; i++) {
            Set<Integer> s = new HashSet<>();
            for (int j = i + 1; j < n; j++){
                if (s.contains(k - A[i] - A[j]))
                    return true;

                s.add(A[j]);
            }
        }
        return false;
    }
}
