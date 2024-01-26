package com.interview.graph.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleUnDirected {

    public boolean isCyclicConnected(ArrayList<ArrayList<Integer>> adj, int s) {

        int parent[] = new int[adj.size()];
        Arrays.fill(parent, -1);        // Set parent vertex for every vertex as -1.

        Queue<Integer> q = new LinkedList<>();      // Create a queue for BFS
        boolean[] visited = new boolean[adj.size()];
        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {

            int u = q.poll();
            for (Integer v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                    parent[v] = u;
                } else if (parent[u] != v)
                    return true;
            }
        }
        return false;
    }
}
