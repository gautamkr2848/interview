package com.interview.dynamic.gridDP;

public class c_MaxSumMatrix {

    public static int maxCost_2(int[][] cost, int m, int n){
        if(m < 0 || n < 0)
            return Integer.MIN_VALUE;
        if(m == 0 && n == 0)
            return cost[m][n];
        return cost[m][n] + Math.max(maxCost_2(cost, m-1, n), maxCost_2(cost, m, n-1));
    }

    public static int MaximumPath_2(int [][]cost) {
        int m = cost.length;
        int n = cost[0].length;

        int [][]sum = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0 && j == 0)
                    sum[i][j] = cost[i][j];
                else
                    sum[i][j] = cost[i][j] + Math.max((i>0 ? sum[i-1][j] : Integer.MIN_VALUE), (j>0 ? sum[i][j-1] : Integer.MIN_VALUE));

            }
        }

        return sum[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] mat = {{348, 391},
                {618,193}};
        System.out.println(MaximumPath_2(mat));
    }
}
