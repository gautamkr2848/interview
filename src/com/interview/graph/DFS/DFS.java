package com.interview.graph.DFS;

import java.util.ArrayList;
import java.util.Iterator;

public class DFS {

    void DFSUtil(int v, boolean visited[], ArrayList<ArrayList<Integer>> adj) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> i = adj.get(v).listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited, adj);
        }
    }

    void DFS(int v, int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited, adj);
    }

    //Handling A Disconnected Graph
    public void DFS(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; ++i)
            if (visited[i] == false)
                DFSUtil(i, visited, adj);
    }
}

/*
DFS
    1. Detecting cycle in a graph
    2. Path Finding
    3. Topological Sorting
    4. To test if a graph is bipartite
    5. Finding Strongly Connected Components of a graph
    6. Solving puzzles with only one solution, such as mazes
*/
