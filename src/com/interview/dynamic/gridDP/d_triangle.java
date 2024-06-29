package com.interview.dynamic.gridDP;

// Fixed starting point & variable ending point in last row

// [[2],
//  [3,4],
//  [6,5,7],
//  [4,1,8,3]]

public class d_triangle {

    public static int minSum(int[][] grid, int m, int n) {
        if (m == grid.length-1)
            return grid[m][n];

        return grid[m][n] + Math.min(minSum(grid, m+1, n+1), minSum(grid, m+1, n));
    }

    public static void main(String[] args) {
        int triangle [][] = {   { 2 },
                                { 3, 9 },
                                { 1, 6, 7 }  };
        System.out.println(minSum_dp(triangle, 3, 3));
    }

    // Time complexity - O(2pow(m*n))

    public static int minSum_dp(int[][] grid, int m, int n) {
        int[][] t = new int[m][n];

        for(int j=0; j<n; j++)
            t[n-1][j] = grid[n-1][j];

        for(int i=n-2; i>=0; i--) {
            for(int j=i; j>=0; j--) {
                t[i][j] = grid[i][j] + Math.min(t[i+1][j+1],t[i+1][j]);
            }
        }

        return t[0][0];
    }

}
