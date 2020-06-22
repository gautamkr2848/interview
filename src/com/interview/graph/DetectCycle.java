package com.interview.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DetectCycle {
    private int v;
    private LinkedList<Integer> adj[];

    DetectCycle(int v) {
        v = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v,int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    Boolean isCyclic(){
        Boolean visited[] = new Boolean[v];
        for (int i = 0; i < v; i++)
            visited[i] = false;

        for (int u = 0; u < v; u++)
            if (!visited[u] && isCyclicUtil(u, visited, -1))
                return true;
        return false;
    }


    Boolean isCyclicUtil(int v, Boolean visited[], int parent) {
        visited[v] = true;
        Integer i;

        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();

            if (!visited[i] && isCyclicUtil(i, visited, v))
                return true;
            else if (i != parent)
                return true;
        }
        return false;
    }
}