package com.interview.matrix;

public class MinCostPath {

    public void minCostPath(){
        int cost[][]= {{9, 4, 9, 9},
                {6, 7, 6, 4},
                {8, 3, 3, 7},
                {7, 4, 9, 10}};
        int m=3, n=3;
        int sum[][]=new int[m+1][n+1];

        sum[0][0] = cost[0][0];
        for (int i = 1; i <= m; i++)
            sum[i][0] = sum[i-1][0] + cost[i][0];

        for (int j = 1; j <= n; j++)
            sum[0][j] = sum[0][j-1] + cost[0][j];

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                sum[i][j] = cost[i][j] + min(sum[i-1][j-1], sum[i-1][j], sum[i][j-1]);

        System.out.println(sum[m][n]);
    }

    public int minCost_2(int[][] cost, int m, int n){
        if(m < 0 || n < 0)
            return Integer.MAX_VALUE;
        if(m == 0 && n == 0)
            return cost[m][n];
        return cost[m][n] + min(minCost_2(cost, m-1, n), minCost_2(cost, m, n-1), minCost_2(cost, m-1, n-1));
    }

    int min(int x, int y, int z) {
        if (x < y)
            return (x < z)? x : z;
        else
            return (y < z)? y : z;
    }
}
