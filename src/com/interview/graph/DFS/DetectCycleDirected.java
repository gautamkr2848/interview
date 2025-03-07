package com.interview.graph.DFS;

import java.util.ArrayList;

public class DetectCycleDirected {

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++)
            if(!visited[i])
                if (isCyclicUtil(i, adj, visited, recStack))
                    return true;

        return false;
    }

    private boolean isCyclicUtil(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recStack) {
        visited[i] = true;
        recStack[i] = true;

        for (Integer neighbour: adj.get(i)) {
            if(!visited[neighbour]) {
                if (isCyclicUtil(neighbour, adj, visited, recStack)) ;
                return true;
            } else if(recStack[neighbour])
                return true;
        }

        recStack[i] = false;
        return false;
    }
}
