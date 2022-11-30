package com.interview.tree;

import java.util.*;

public class RootToLeafPath {

    public static ArrayList<ArrayList<Integer>> Paths(Node root){

        List<Node> leafs = new ArrayList<>();
        Map<Node, Node> map = new HashMap<>();
        map.put(root, null);
        storeParent(root, map, leafs);

        return findPaths(map, leafs);

    }

    private static void storeParent(Node root, Map<Node, Node> map, List<Node> leafs){
        if(root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node tmp = q.poll();

            if(tmp.left == null && tmp.right == null)
                leafs.add(tmp);

            if(tmp.left != null) {
                map.put(tmp.left, tmp);
                q.add(tmp.left);
            }

            if(tmp.right != null) {
                map.put(tmp.right, tmp);
                q.add(tmp.right);
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> findPaths(Map<Node, Node> map, List<Node> leafs){
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        for(Node node : leafs){
            ArrayList<Integer> path = new ArrayList<>();
            path.add(node.key);
            while(map.get(node) != null){
                path.add(map.get(node).key);
                node = map.get(node);
            }
            Collections.reverse(path);
            paths.add(path);
        }
        return paths;
    }
}
