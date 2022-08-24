package com.interview.graph;

import java.util.ArrayList;

public class Graph {

    private Integer V;
    private ArrayList<ArrayList<Integer>> adj;

    Graph(Integer v){
        this.V = v;
        this.adj = new ArrayList<>();
        for(int i=0; i<v; i++)
            adj.set(i, new ArrayList<>());
    }

    public void addUndirectedEdge(int v, int w){
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

    public void addDirectedEdge(int v, int w){
        adj.get(v).add(w);
    }
}
