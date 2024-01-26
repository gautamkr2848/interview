package com.interview.graph.shortestPath;

import com.interview.graph.Pair;

import java.util.*;

// First choose a source vretex, let's say 0
// Start selecting the closest nodes from all the adjacent reachable nodes
// Stop when all the nodes have been included and we are left with shortest path tree
// O(ELogV)

//Input:
//V = 3, E = 3
//adj = {{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}}
//S = 2
//Output:
//4 3 0

// follows greedy algo

public class Dijkstra {

    public int[] dijkstra(int V, int S, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.getW().compareTo(o2.getW()));

        pq.add(new Pair(S,0));
        int[] ans = new int[V];
        Arrays.fill(ans, 1000000);
        ans[S] = 0;

        while (pq.size() != 0){
            Pair curr = pq.remove();
            int u = curr.getV();
            if(visited[u]){
                continue;
            }
            visited[u] = true;

            for(ArrayList<Integer> neighbour : adj.get(u)){
                int vertex = neighbour.get(0);
                int w = neighbour.get(1);

                if(ans[vertex] > ans[u] + w){
                    ans[vertex] = ans[u] + w;
                    pq.add(new Pair(vertex, ans[vertex]));
                }
            }
        }
        return ans;
    }
}


