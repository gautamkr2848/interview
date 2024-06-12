package com.interview.graph.DFS;

import com.interview.graph.Graph;

import java.util.ArrayList;
import java.util.List;

public class d_printAllPaths {

    public static void printAllPaths(ArrayList<ArrayList<Integer>> adj, int s, int d) {
        boolean[] isVisited = new boolean[adj.size()];
        ArrayList<Integer> path = new ArrayList<>();

        path.add(s);
        printAllPathsUtil(adj, s, d, isVisited, path);
    }

    private static void printAllPathsUtil(ArrayList<ArrayList<Integer>> adj, Integer u, Integer d, boolean[] isVisited, List<Integer> path) {
        if (u.equals(d)) {
            System.out.println(path);
            return;
        }

        isVisited[u] = true;
        for (Integer i : adj.get(u)) {
            if (!isVisited[i]) {
                path.add(i);
                printAllPathsUtil(adj, i, d, isVisited, path);
                path.remove(i);
            }
        }

        isVisited[u] = false;       // Mark the current node
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);

        int s = 2, d = 3;
        printAllPaths(g.adj, s, d);
    }
}
