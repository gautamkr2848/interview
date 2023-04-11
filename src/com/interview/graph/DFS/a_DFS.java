package com.interview.graph.DFS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
Input: n = 4, e = 6
0 -> 1, 0 -> 2, 1 -> 2, 2 -> 0, 2 -> 3, 3 -> 3
Output: DFS from vertex 1 : 1 2 0 3
*/

// V = no. of vertices
// v = starting vertices

public class a_DFS {

    //Handling A Disconnected Graph
    public void DFS_2(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; ++i)
            if (!visited[i])
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

        for(Integer i : adj.get(v)) {
            if (!visited[i])
                DFSUtil(i, visited, adj);
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
