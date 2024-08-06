package com.interview.graph.BFS;

import java.util.*;

public class GraphCLone {

    public Node cloneGraph(Node source) {
        Queue<Node> q = new LinkedList<>();
        q.add(source);

        Map<Node, Node> map = new HashMap<>();
        map.put(source,new Node(source.val));

        while (!q.isEmpty()) {
            Node u = q.poll();
            Node cloneNodeU = map.get(u);

            if (u.neighbours != null) {
                List<Node> v = u.neighbours;
                for (Node graphNode : v) {
                    Node cloneNodeG = map.get(graphNode);
                    if (cloneNodeG == null) {
                        q.add(graphNode);
                        cloneNodeG = new Node(graphNode.val);
                        map.put(graphNode,cloneNodeG);
                    }
                    cloneNodeU.neighbours.add(cloneNodeG);
                }
            }
        }

        return map.get(source);
    }
}

class Node {
    int val;
    List<Node> neighbours;

    public Node(int val) {
        this.val = val;
        neighbours = new ArrayList<>();
    }
}
