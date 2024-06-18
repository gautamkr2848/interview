package com.interview.graph.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CountNodesAtGivenLevel {

    public int BFS(int s, int level, int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        int[] levelArr = new int[V];

        Queue<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);
        int count = 0;
        while (!queue.isEmpty()) {
            s = queue.poll();

            for (Integer neighbour : adj.get(s)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    levelArr[neighbour] = levelArr[s] + 1;
                    queue.add(neighbour);
                }
            }

            count = 0;
            for (int i = 0; i < V; i++)
                if (levelArr[i] == level)
                    count++;
        }
        return count;
    }
}
