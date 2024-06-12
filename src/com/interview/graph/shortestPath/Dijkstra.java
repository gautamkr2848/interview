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

    private ArrayList<ArrayList<iPair>> adj;
    private int V;

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

    void shortestPath(int src) {
        PriorityQueue<iPair> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.first));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new iPair(0, src));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll().second;

            for (iPair v : adj.get(u)) {
                if (dist[v.first] > dist[u] + v.second) {
                    dist[v.first] = dist[u] + v.second;
                    pq.add(new iPair(dist[v.first], v.first));
                }
            }
        }

        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    static class iPair {
        int first, second;

        iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}


