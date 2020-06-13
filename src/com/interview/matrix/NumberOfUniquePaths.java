package com.interview.matrix;

public class NumberOfUniquePaths {

    public int uniquePaths(int m, int n){
        if (m == 1 || n == 1)
            return 1;

        // If diagonal movements are allowed then
        // the last addition is required.
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        // + numberOfPaths(m-1, n-1);
    }

}
