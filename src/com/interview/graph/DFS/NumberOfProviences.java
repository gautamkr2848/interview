package com.interview.graph.DFS;

import java.util.ArrayList;

public class NumberOfProviences {

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V+1];
        int count = 0;
        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                dfsUtil(adj, i, visited);
                count++;
            }
        }
        return count;
    }

    static void dfsUtil(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited){
        visited[s] = true;

        for(Integer i : adj.get(s)){
            if(!visited[i])
                dfsUtil(adj, i, visited);
        }
    }

    // 1 0
    // 0 1

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> a  =new ArrayList<>();
        adj.add(a);

        ArrayList<Integer> b  =new ArrayList<>();
        adj.add(b);

        System.out.println(numProvinces(adj, 2));
    }
}
