package com.interview.graph.DFS;

import java.util.ArrayList;

public class c_AllPossiblePathBetweenTwoNodes {

    public int countPaths(ArrayList<ArrayList<Integer>> adj, int s, int d) {
        return countPathsUtil(s, d, adj, 0);
    }

    private int countPathsUtil(int s, int d, ArrayList<ArrayList<Integer>> adj, int pathCount) {

        if (s == d) {
            pathCount++;
        } else {
            for(Integer neighbour : adj.get(s))
                pathCount = countPathsUtil(neighbour, d, adj, pathCount);
        }
        return pathCount;
    }
}
