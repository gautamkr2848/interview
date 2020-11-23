package com.interview.tree;

import java.util.*;

class TopView {
    int data; //data of the node
    int hd; //horizontal distance of the node
    TopView left, right; //left and right references

    public TopView(int key){
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}

public class TreeTopView {
    
    public void topView(){

        TopView root = new TopView(20);
        root.left = new TopView(8);
        root.right = new TopView(22);
        root.left.left = new TopView(5);
        root.left.right = new TopView(3);
        root.right.left = new TopView(4);
        root.right.right = new TopView(25);
        root.left.right.left = new TopView(10);
        root.left.right.right = new TopView(14);

        if (root == null)
            return;

        int hd = 0;
        Map<Integer, Integer> map = new TreeMap<>();        //<horizontalDistance, node.data>
        Queue<TopView> queue = new LinkedList<>();

        root.hd = hd;
        queue.add(root);

        while (!queue.isEmpty()){
            TopView temp = queue.remove();
            hd = temp.hd;

            if(!map.containsKey(hd))
                map.put(hd, temp.data);

            // If the dequeued node has a left child add it to the queue with a horizontal distance hd-1.
            if (temp.left != null){
                temp.left.hd = hd-1;
                queue.add(temp.left);
            }
            // If the dequeued node has a right child add it to the queue with a horizontal distance hd+1.
            if (temp.right != null){
                temp.right.hd = hd+1;
                queue.add(temp.right);
            }
        }

        // Traverse the map elements and print values
        for(Integer i : map.values())
            System.out.print(i+" ");
    }
    
}
