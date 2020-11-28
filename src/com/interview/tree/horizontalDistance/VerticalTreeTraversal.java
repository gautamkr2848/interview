package com.interview.tree.horizontalDistance;
/*
                1                               4
       2                3               ==>     2
   4       5        6       7                   1 5 6
                        8       9               3 8
                                                7
                                                9
*/

import java.util.*;

class VerticalTree {
    int data; //data of the node
    int hd; //horizontal distance of the node
    VerticalTree left, right; //left and right references

    public VerticalTree(int key){
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}

public class VerticalTreeTraversal {

    public void printVertical(){

        VerticalTree root = new VerticalTree(20);
        root.left = new VerticalTree(8);
        root.right = new VerticalTree(22);
        root.left.left = new VerticalTree(5);
        root.left.right = new VerticalTree(3);
        root.right.left = new VerticalTree(4);
        root.right.right = new VerticalTree(25);
        root.left.right.left = new VerticalTree(10);
        root.left.right.right = new VerticalTree(14);

        if (root == null)
            return;

        int hd = 0;
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<VerticalTree> queue = new LinkedList<>();

        root.hd = hd;
        queue.add(root);

        while (!queue.isEmpty()){
            VerticalTree temp = queue.remove();
            hd = temp.hd;

            if(map.containsKey(hd)){
                List<Integer> list = map.get(hd);
                list.add(temp.data);
                map.put(hd, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(temp.data);
                map.put(hd, list);
            }

            // If the dequeued node has a left child, add it to the queue with a horizontal distance hd-1.
            if (temp.left != null){
                temp.left.hd = hd-1;
                queue.add(temp.left);
            }
            // If the dequeued node has a right child, add it to the queue with a horizontal distance hd+1.
            if (temp.right != null){
                temp.right.hd = hd+1;
                queue.add(temp.right);
            }
        }

        /*Map<Integer, List<Integer>> sortedMap = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));*/

        for(Integer i : map.keySet()){
            List<Integer> list = map.get(i);
            System.out.print(i+" => ");
            for(int j=0; j<list.size(); j++)
                System.out.print(list.get(j)+" ");
            System.out.println();
        }

    }

}
