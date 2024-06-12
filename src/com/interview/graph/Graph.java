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

    public void addUndirectedEdge(int x, int y){
        adj.get(x).add(y);
        adj.get(y).add(x);
    }

    public void addEdge(int x, int y){
        adj.get(x).add(y);
    }
}
