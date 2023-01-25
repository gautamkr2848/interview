package com.interview.graph.DFS;

import java.util.ArrayList;
import java.util.Iterator;

public class DetectCycleUndirected {

    public Boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

        Boolean visited[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                if (isCyclicUtil(i, adj, visited, -1))
                    return true;
        }
        return false;
    }

    private Boolean isCyclicUtil(int v, ArrayList<ArrayList<Integer>> adj, Boolean visited[], int parent) {

        visited[v] = true;
        Iterator<Integer> it = adj.get(v).iterator();

        while (it.hasNext()) {
            Integer i = it.next();
            if (!visited[i]) {
                if (isCyclicUtil(i, adj, visited, v))
                    return true;
            } else if (i != parent)
                return true;
        }
        return false;
    }
}
