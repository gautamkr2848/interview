package com.interview.graph.DFS;

import java.util.ArrayList;
import java.util.Stack;

/*
//Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u v,
// vertex u comes before v. Topological Sorting for a graph is not possible if the graph is not a DAG.

A directed acyclic graph is a directed graph with no directed cycles. That is, it consists of vertices and edges, with
each edge directed from one vertex to another, such that following those directions will never form a closed loop.


/* usages
* Build systems
* Task scheduling
* pre-requisite problems */

public class b_TopologicalSort {

    //Same as DFS for disconnected graph
    public void topologicalSort(int V, ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack, adj);

        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }

    private void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj){

        visited[v] = true;
        for(Integer neighbour : adj.get(v)){
            if (!visited[neighbour])
                topologicalSortUtil(neighbour, visited, stack, adj);
        }

        stack.push(new Integer(v));
    }
}
