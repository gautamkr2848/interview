package com.interview.greedy;

import java.util.Vector;

public class SumOfDependency {

    public void sumOfDependency(){

        int V = 4;
        Vector<Integer> adj[] = new Vector[V];

        for (int i = 0; i < adj.length; i++)
            adj[i] = new Vector<>();

        addEdge(adj, 0, 2);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 3);

        int sum = 0;
        for (int u = 0; u < V; u++)
            sum = sum + adj[u].size();
        System.out.println(sum);
    }

    static void addEdge(Vector<Integer> adj[], int u, int v){
        adj[u].addElement((v));
    }
}
