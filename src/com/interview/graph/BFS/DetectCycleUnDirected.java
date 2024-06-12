package com.interview.graph.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleUnDirected {

    public static boolean isCyclicConnected(ArrayList<Integer>[] adj, int s, int V, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        while (!q.isEmpty()) {
            int v = q.poll();

            if (visited[v]) {
                return true; // Cycle detected
            }

            visited[v] = true; // Mark as visited

            for (int it : adj[v]) {
                if (!visited[it]) {
                    q.add(it);
                }
            }
        }
        return false;
    }

    public static boolean isCyclicDisconnected(ArrayList<Integer>[] adj, int V) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCyclicConnected(adj, i, V, visited)) {
                return true;
            }
        }
        return false;
    }
}
