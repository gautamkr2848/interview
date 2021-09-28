package com.interview.tree.distance;

import com.interview.tree.Node;

import java.util.*;

public class NodesAtDistance {

    public void nodes(){
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        Node target = root.left.right;

        kDistanceNodes(root, target, 2);
    }

    List<Node> path = null;
    private void kDistanceNodes(Node node, Node target, int k){
        path = new ArrayList<>();
        findPath(node, target);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < path.size(); i++) {
            findKDistanceFromNode(path.get(i), k - i, result, i == 0 ? null : path.get(i - 1));
        }

        result.stream().forEach(x -> System.out.print(x+ " "));
    }

    private void findKDistanceFromNode(Node node, int dist, List<Integer> result, Node blocker) {
        if (dist < 0 || node == null || (blocker != null && node == blocker))
            return;

        if (dist == 0)
            result.add(node.key);

        findKDistanceFromNode(node.left, dist - 1, result, blocker);
        findKDistanceFromNode(node.right, dist - 1, result, blocker);
    }

    private boolean findPath(Node node, Node target) {
        if (node == null)
            return false;

        if (node == target || findPath(node.left, target) || findPath(node.right, target)) {
            path.add(node);
            return true;
        }
        return false;
    }
}
