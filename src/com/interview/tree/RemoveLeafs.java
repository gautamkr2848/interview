package com.interview.tree;

import java.util.*;

public class RemoveLeafs {

    static Map<Integer, List<Integer>> resultMap = new HashMap<>();

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);

        printLeafNodes(root);
    }

    private static void printLeafNodes(Node root) {
        if (root == null)
            return;

        int maxDepth = fillMap(root);
        for (int i = 1; i <= maxDepth; i++) {
            List<Integer> currentList = resultMap.get(i);

            System.out.print("Iteration " + i + " : ");
            for (int j = 0; j < currentList.size(); j++)
                System.out.print(currentList.get(j) + " ");

            System.out.println();
        }
    }

    private static int fillMap(Node root) {
        if (root == null) {
            return 0;
        }
        int left = fillMap(root.left);
        int right = fillMap(root.right);
        int height = Math.max(left, right) + 1;
        resultMap.computeIfAbsent(height, k -> new Vector<>()).add(root.key);

//        List<Integer> currentList = null;
//        if(resultMap.containsKey(height)) {
//            currentList = resultMap.get(height);
//        } else {
//            currentList = new ArrayList<>();
//        }
//        currentList.add(root.key);
//        resultMap.put(height, currentList);

        return height;
    }
}
