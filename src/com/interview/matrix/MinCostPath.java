package com.interview.matrix;

public class MinCostPath {

    public void minCostPath(){
        int cost[][]= {{1, 2, 3}, {4, 8, 2}, {1, 5, 3}};
        int m=2, n=2;
        int tc[][]=new int[m+1][n+1];

        tc[0][0] = cost[0][0];

        /* Initialize first column of total cost(tc) array */
        for (int i = 1; i <= m; i++)
            tc[i][0] = tc[i-1][0] + cost[i][0];

        /* Initialize first row of tc array */
        for (int j = 1; j <= n; j++)
            tc[0][j] = tc[0][j-1] + cost[0][j];

        /* Construct rest of the tc array */
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                tc[i][j] = cost[i][j] + min(tc[i-1][j-1], tc[i-1][j], tc[i][j-1]);

        System.out.println(tc[m][n]);
    }

    int min(int x, int y, int z) {
        if (x < y)
            return (x < z)? x : z;
        else
            return (y < z)? y : z;
    }

    public int minCost_2(int[][] cost, int m, int n){
        if(m < 0 || n < 0)
            return Integer.MAX_VALUE;
        if(m == 0 && n == 0)
            return cost[m][n];
        return cost[m][n] + min(minCost_2(cost, m-1, n), minCost_2(cost, m, n-1), minCost_2(cost, m-1, n-1));
    }
}
