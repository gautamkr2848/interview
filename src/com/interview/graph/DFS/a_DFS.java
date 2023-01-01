package com.interview.graph.DFS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a_DFS {

    //Handling A Disconnected Graph
    public void DFS_2(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; ++i)
            if (visited[i] == false)
                DFSUtil(i, visited, adj);
    }

    //Handling A Connected Graph
    public void DFS_1(int v, int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited, adj);
    }

    private void DFSUtil(int v, boolean visited[], ArrayList<ArrayList<Integer>> adj) {
        visited[v] = true;
        System.out.print(v + " ");

        for(Integer n : adj.get(v)) {
            if (!visited[n])
                DFSUtil(n, visited, adj);
        }
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
