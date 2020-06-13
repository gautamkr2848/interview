package com.interview.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/* usages
* Build systems
* Task scheduling
* pre-requisite problems */

public class TopologicalSort {

    private int V;  // no. of vertices
    private ArrayList<ArrayList<Integer>> adj;  // Adjacency List as ArrayList of ArrayList's

    //Constructor
    public TopologicalSort(int v){
        V = v;
        adj = new ArrayList<>(v);
        for (int i=0; i<v; ++i)
            adj.add(new ArrayList<>());
    }

    public void addEdge(int v,int w) { adj.get(v).add(w); }

    // A recursive function used by topologicalSort
    void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack){
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> it = adj.get(v).iterator();
        while (it.hasNext()){
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        // Push current vertex to stack which stores result
        stack.push(new Integer(v));
    }

    public void topologicalSort(){
        Stack<Integer> stack = new Stack<>();

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        // call util function for all the vertices
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);

        // Print contents of stack
        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
    }
}
