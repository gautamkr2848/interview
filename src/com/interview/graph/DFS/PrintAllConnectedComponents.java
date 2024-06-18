package com.interview.graph.DFS;

import com.interview.graph.Graph;

import java.util.ArrayList;

public class PrintAllConnectedComponents {

    private static void DFSUtil(int v, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");
        // Recur for all the vertices
        // adjacent to this vertex
        for (int x : adj.get(v)) {
            if (!visited[x])
                DFSUtil(x, visited, adj);
        }
    }

    private static void connectedComponents(ArrayList<ArrayList<Integer>> adj, Integer V) {
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];
        for (int v = 0; v < V; ++v) {
            if (!visited[v]) {
                DFSUtil(v, visited, adj);
                System.out.println();
            }
        }
    }
}
