package com.interview.graph;

import java.util.ArrayList;

public class Graph {

    public Integer V;
    public ArrayList<ArrayList<Integer>> adj;

    public Graph(Integer v){
        this.V = v;
        this.adj = new ArrayList<>(V);
        for(int i=0; i<v; i++)
            adj.add(i, new ArrayList<>());
    }

    public void addUndirectedEdge(int v, int w){
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

    public void addEdge(int v, int w){
        if(adj.get(v).size() == 0)
            adj.get(v).add(v);
        adj.get(v).add(w);
    }
}
