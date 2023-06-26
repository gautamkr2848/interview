package com.interview.graph;


import java.util.Iterator;
import java.util.LinkedList;

class HasPath {

    public void hasPath() {
//        Graph g = new Graph(4);
//        g.addDirectedEdge(0, 1);
//        g.addDirectedEdge(0, 2);
//        g.addDirectedEdge(1, 2);
//        g.addDirectedEdge(2, 0);
//        g.addDirectedEdge(2, 3);
//        g.addDirectedEdge(3, 3);
//
//        int u = 1;
//        int v = 3;
//        if (isReachable(u, v))
//            System.out.println("There is a path from " + u +" to " + v);
//        else
//            System.out.println("There is no path from " + u +" to " + v);;
//
//        u = 3;
//        v = 1;
//        if (isReachable(u, v))
//            System.out.println("There is a path from " + u +" to " + v);
//        else
//            System.out.println("There is no path from " + u +" to " + v);;
    }

    //prints BFS traversal from a given source s
//    private Boolean isReachable(int s, int d) {
//        LinkedList<Integer>temp;
//        boolean visited[] = new boolean[V];
//
//        LinkedList<Integer> queue = new LinkedList<>();      // Create a queue for BFS
//
//        // Mark the current node as visited and enqueue it
//        visited[s]=true;
//        queue.add(s);
//
//        // 'i' will be used to get all adjacent vertices of a vertex
//        Iterator<Integer> i;
//        while (queue.size()!=0)
//        {
//            // Dequeue a vertex from queue and print it
//            s = queue.poll();
//
//            int n;
//            i = adj[s].listIterator();
//
//            // Get all adjacent vertices of the dequeued vertex s
//            // If a adjacent has not been visited, then mark it
//            // visited and enqueue it
//            while (i.hasNext())
//            {
//                n = i.next();
//
//                // If this adjacent node is the destination node,
//                // then return true
//                if (n==d)
//                    return true;
//
//                // Else, continue to do BFS
//                if (!visited[n])
//                {
//                    visited[n] = true;
//                    queue.add(n);
//                }
//            }
//        }
//
//        // If BFS is complete without visited d
//        return false;
//    }
}

