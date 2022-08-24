package com.interview.graph.DFS;

import java.util.ArrayList;

public class AllPossiblePathBetweenTwoNodes {

    int countPathsUtil(int u, int d, ArrayList<ArrayList<Integer>> adj, int pathCount) {

        if (u == d) {
            pathCount++;
        } else {
            for(Integer neighbour : adj.get(u)) {
                pathCount = countPathsUtil(neighbour, d, adj, pathCount);
            }
        }
        return pathCount;
    }

    int countPaths(ArrayList<ArrayList<Integer>> adj, int s, int d) {
        int pathCount = 0;
        pathCount = countPathsUtil(s, d, adj, pathCount);
        return pathCount;
    }
}
