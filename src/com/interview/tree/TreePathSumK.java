package com.interview.tree;

import java.util.ArrayList;
import java.util.List;

//Print every path in the tree with sum of the nodes in the path as k.
//A path can start from any node and end at any node and must be downward only

/*
                    1
            2               3
        4       5       6
    7      8

    sum = 13
    path = 1    2   4   7
    currSum = 7, count = 0
    currSum = 11, count = 0
    currSum = 13, count = 1

    path = 1    2   4   8
    currSum = 14, count = 1

    path = 1    2   4
    currSum = 7, count = 1

    path = 1    2   5
 */

public class TreePathSumK {

    List<Integer> path = new ArrayList<>();
    int count = 0;

    public void pathCount(Node root, int k) {
        if (root == null)
            return;

        path.add(root.key);

        pathCount(root.left, k);
        pathCount(root.right, k);

        int currSum = 0;
        for (int j = path.size() - 1; j >= 0; j--) {
            currSum += path.get(j);

            if (currSum == k) {
                count++;
                for (int i=j; i<path.size(); i++){
                    System.out.print(path.get(i) + " ");
                }
                System.out.println();
            }
        }
        path.remove(path.size() - 1);       // Remove the current element from the path
    }


}
