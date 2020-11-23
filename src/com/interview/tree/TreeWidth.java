package com.interview.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeWidth {

    public void treeWidth(Node node){       //same as max sum at level
        int width = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()){
            int count = queue.size();
            width = Math.max(width, count);

            while (count-- > 0){
                Node temp = queue.poll();
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
        }
        System.out.println(width);
    }
}
