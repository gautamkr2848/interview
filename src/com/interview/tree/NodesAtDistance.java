package com.interview.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class NodesAtDistance {

    static HashMap<Node, Node> parentChildMap = new HashMap<>();    //<child, parent>

    public void nodesAtDistance(Node target, int k){
        HashSet<Node> s = new HashSet<>();
        int dist = 0;

        Queue<Node> q = new LinkedList<>();
        q.add(target);
        s.add(target);

        while (!q.isEmpty()) {
            if (dist == k) {
                while (!q.isEmpty()){
                    System.out.print(q.peek().key + " ");
                    q.poll();
                }
            }

            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node p = q.poll();

                if (p.left != null && !s.contains(p.left)) {
                    q.add(p.left);
                    s.add(p.left);
                }

                if (p.right != null && !s.contains(p.right)) {
                    q.add(p.right);
                    s.add(p.right);
                }

                if (parentChildMap.get(p) != null && !s.contains(parentChildMap.get(p))) {
                    q.add(parentChildMap.get(p));
                    s.add(parentChildMap.get(p));
                }
            }
            dist++;
        }
    }

    void storeParent(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node p = q.poll();
            if (p == root)
                parentChildMap.put(p, null);

            if (p.left != null) {
                parentChildMap.put(p.left, p);
                q.add(p.left);
            }
            if (p.right != null) {
                parentChildMap.put(p.right, p);
                q.add(p.right);
            }
        }
    }

    public void nodes(){
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.right.left = new Node(5);
        root.right.right = new Node(8);
        root.left.left = new Node(4);
        root.left.left.left = new Node(25);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.left.left = new Node(15);
        root.left.right.left.right = new Node(18);
        root.left.right.left.right.right = new Node(23);
        root.left.right.right = new Node(14);
        Node target = root.left.right;

        storeParent(root);
        nodesAtDistance(target, 3);
    }
}
