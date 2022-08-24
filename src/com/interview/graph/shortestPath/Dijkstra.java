package com.interview.graph.shortestPath;

import com.interview.graph.Pair;

import java.util.*;

// O(ELogV)

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


