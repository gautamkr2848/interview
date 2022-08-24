package com.interview.graph.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CountNodesAtGivenLevel {

    int BFS(int s, int l, int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        int[] level = new int[V];

        for (int i = 0; i < V; i++) {
            visited[i] = false;
            level[i] = 0;
        }

        Queue<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);
        level[s] = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            s = queue.peek();
            queue.poll();

            ArrayList<Integer> list = adj.get(s);

            for (Integer neighbour : list) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    level[neighbour] = level[s] + 1;
                    queue.add(neighbour);
                }
            }

            count = 0;
            for (int i = 0; i < V; i++)
                if (level[i] == l)
                    count++;
        }
        return count;
    }
}
