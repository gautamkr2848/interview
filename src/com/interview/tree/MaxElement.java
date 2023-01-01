package com.interview.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxElement {

    public Integer maxElement(Node node){

        if(node == null)
            return null;

        int max = Integer.MIN_VALUE;

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            Node tmp = q.poll();
            if(tmp.key > max)
                max = tmp.key;

            if(tmp.left != null)
                q.add(tmp.left);

            if(tmp.right != null)
                q.add(tmp.right);
        }
        return max;
    }
}
