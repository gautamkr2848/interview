package com.interview.graph;

import java.util.ArrayList;

// Only applicable for Directed Graph

public class TransitiveCLosure {

    public ArrayList<ArrayList<Integer>> transitiveClosure(int V, int graph[][]) {
        int reach[][] = new int[V][V];
        int  i, j, k;

        for (i = 0; i < V; i++)         //initlize solution matrix same as graph matrix
            for (j = 0; j < V; j++)
                reach[i][j] = graph[i][j];

        for (k = 0; k < V; k++) {       // Pick all vertices as source one by one
            for (i = 0; i < V; i++) {       // Pick all vertices as destination for the above picked source
                for (j = 0; j < V; j++) {       // If vertex k is on a path from i to j, then make sure that the value of reach[i][j] is 1
                    reach[i][j] = (reach[i][j]==1) || ((reach[i][k]==1) && (reach[k][j]==1)) ? 1 : 0;
                }
            }
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (i = 0; i < V; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (j = 0; j < V; j++) {
                if (i == j)
                    tmp.add(1);
                else
                    tmp.add(reach[i][j]);
            }
            res.add(tmp);
        }
        return (res);
    }
}
