package com.interview.graph.BFS;

import java.util.*;

public class CountNodesAtGivenLevel {

    static int countNodes(int root, ArrayList<ArrayList<Integer>> graph, int level, int n) {
        boolean [] visited = new boolean[n];
        HashMap<Integer,Integer> um = new HashMap<>();

        Queue<PairA> q = new LinkedList<>();
        q.add(new PairA(root,1));

        while(!q.isEmpty()) {
            PairA tmp = q.poll();
            visited[tmp.data] = true;
            um.put(tmp.level, um.getOrDefault(tmp.level, 0)+1);

            for(Integer i : graph.get(tmp.data)) {
                if(!visited[i])
                    q.add(new PairA(i, tmp.level + 1));
            }
        }
        return um.get(level);
    }
}

class PairA {
    int data, level;
    PairA(int u, int v) {
        data = u;
        level = v;
    }
}
