package com.interview.graph.shortestPath;

// works with negative weight edges
// time complexity - O(EV)

//1. Initialize distances from the source to all vertices as infinite and distance to the source itself as 0. Create an
// array dist[] of size |V| with all values as infinite except dist[src] where src is the source vertex.

//2. This step calculates the shortest distances. Do the following |V|-1 times where |V| is the number of vertices in the given graph.
//Do the following for each edge u-v.
//If dist[v] > dist[u] + weight of edge uv, then update dist[v].
//dist[v] = dist[u] + weight of edge uv.

//3. This step reports if there is a negative weight cycle in the graph. Do the following for each edge u-v
//If dist[v] > dist[u] + weight of edge uv, then the “Graph has a negative weight cycle”

import java.util.Arrays;

public class BellmanFord {

    public int isNegativeWeightCycle(int n, int[][] edges) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;

        for(int count = 1; count < n; count++){
            for(int j=0; j<edges.length; j++){
                int src = edges[j][0];
                int des = edges[j][1];
                int wt = edges[j][2];
                if(dist[src] != Integer.MAX_VALUE && dist[src] + wt < dist[des]){
                    dist[des] = dist[src] + wt;
                }
            }
        }


        for(int j=0; j<edges.length; j++){
            int src = edges[j][0];
            int des = edges[j][1];
            int wt = edges[j][2];
            if(dist[src] != Integer.MAX_VALUE && dist[src] + wt < dist[des]){
                return 1;
            }
        }

        return 0;
    }
}
