package com.interview.graph.minSpanningTree;

import com.interview.graph.Pair;

import java.util.*;

public class PrimMinimumSpanningTree {

    public int primMst(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.getW().compareTo(o2.getW()));
        Map<Integer, Integer> map = new HashMap<>();

        pq.add(new Pair(0,0));
        int ans = 0;

        while (pq.size() != 0){
            Pair curr = pq.remove();
            int u = curr.getV();
            if(visited[u]){
                continue;
            }

            ans += curr.getW();

            for(ArrayList<Integer> list : adj.get(u)){
                int vertex = list.get(0);
                int w = list.get(1);

                if(!visited[vertex]) {
                    if(map.containsKey(vertex) && map.get(vertex) > w){
                        pq.remove(vertex);
                        pq.add(new Pair(vertex, w));
                        map.put(vertex, u);
                    } else {
                        pq.add(new Pair(vertex, w));
                        map.put(vertex, w);
                    }
                }
            }
        }
        return ans;
    }
}
