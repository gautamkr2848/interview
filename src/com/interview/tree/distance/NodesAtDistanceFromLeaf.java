package com.interview.tree.distance;

import com.interview.tree.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NodesAtDistanceFromLeaf {

    public void printNodes(){
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.right.left = new Node(5);
        root.right.right = new Node(9);
        root.left.left = new Node(4);
        root.left.left.left = new Node(25);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.left.left = new Node(15);
        root.left.right.left.right = new Node(18);
        root.left.right.left.right.right = new Node(23);
        root.left.right.right = new Node(14);

        Map<Node, Node> map = new HashMap<>();
        storeParent(root, map);
        nodesFromLeaf(root, 2, map);
    }

    public void storeParent(Node root, Map<Node, Node> map) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        map.put(root, null);

        while (!q.isEmpty()) {
            Node tmp = q.poll();

            if (tmp.left != null) {
                map.put(tmp.left, tmp);
                q.add(tmp.left);
            }

            if (tmp.right != null) {
                map.put(tmp.right, tmp);
                q.add(tmp.right);
            }
        }
    }

    private void nodesFromLeaf(Node root, int k, Map<Node, Node> parentMap){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
            Node tmp = q.poll();

            if(tmp.left == null && tmp.right == null){
                Node tmp2 = tmp;
                int dist = 0;
                while(tmp2 != null && dist < k){
                    tmp2 = parentMap.get(tmp2);
                    dist++;
                }
                System.out.println(tmp.key + " => "+ tmp2.key);
            }

            if(tmp.left != null)
                q.add(tmp.left);

            if(tmp.right != null)
                q.add(tmp.right);
        }
    }
}
