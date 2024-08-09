package com.interview.graph.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    // Go to nearest neighbour, level wise

    // In Binary tree, for level order we use Queue data structure

    public void BFS(int s, ArrayList<ArrayList<Integer>> adj) {

        boolean visited[] = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();       // Create a queue for BFS

        visited[s] = true;        // Mark the current node as visited and enqueue it
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();       // Dequeue a vertex from queue and print it
            System.out.print(s + " ");

            for(Integer i : adj.get(s)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}

    /*BFS
    1. Shortest Path and Minimum Spanning Tree for unweighted graph
    2. Peer to Peer Networks
    3. Crawlers in Search Engines
    4. Social Networking Websites
    5. GPS Navigation systems
    6. Broadcasting in Network
    7. In Garbage Collection
    8. Cycle detection in undirected graph
    9. Ford-Fulkerson algorithm
    10. To test if a graph is Bipartite
    11. Path Finding
    12. Finding all nodes within one connected component
*/