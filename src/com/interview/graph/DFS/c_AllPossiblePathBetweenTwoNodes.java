package com.interview.graph.DFS;

import com.interview.graph.Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class c_AllPossiblePathBetweenTwoNodes {

    private static int countPathsUtil(ArrayList<ArrayList<Integer>> adj, int u, int d, int pathCount) {
        if (u == d) {
            pathCount++;
        } else {
            for(Integer neighbour : adj.get(u))
                pathCount = countPathsUtil(adj, neighbour, d, pathCount);
        }
        return pathCount;
    }

    public static int countPaths(ArrayList<ArrayList<Integer>> adj, int s, int d) {
        return countPathsUtil(adj, s, d, 0);
    }

    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);

        int s = 0, d = 3;
        System.out.println(countPaths(g.adj, s, d));
    }
}
