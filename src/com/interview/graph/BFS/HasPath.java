package com.interview.graph.BFS;


import com.interview.graph.Graph;

import java.util.Iterator;
import java.util.LinkedList;

class HasPath {

    public void hasPath() {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        int s = 1;
        int d = 3;
        if (isReachable(s, d, g))
            System.out.println("There is a path from " + s +" to " + d);
        else
            System.out.println("There is no path from " + s +" to " + d);;

        s = 3;
        d = 1;
        if (isReachable(s, d, g))
            System.out.println("There is a path from " + s +" to " + d);
        else
            System.out.println("There is no path from " + s +" to " + d);;
    }

    //prints BFS traversal from a given source s
    private Boolean isReachable(int s, int d, Graph graph) {
        boolean visited[] = new boolean[graph.V];

        LinkedList<Integer> queue = new LinkedList<>();
        visited[s]=true;
        queue.add(s);

         //'i' will be used to get all adjacent vertices of a vertex
        Iterator<Integer> i;
        while (queue.size()!=0) {
            s = queue.poll();
            for (Integer n : graph.adj.get(s)) {
                if (n==d)       //If this adjacent node is the destination node, then return true
                    return true;

                if (!visited[n]) {      //Else, continue to do BFS
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return false;       //If BFS is complete without visited d
    }
}

