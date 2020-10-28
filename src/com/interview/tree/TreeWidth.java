package com.interview.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeWidth {

    public void treeWidth(Node node){
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

    public int treeWidth_2(Node node){
        if(node == null)
            return 0;
        int height = height(node);
        int max = 0;
        for(int i=0; i<height; i++){
            int width = getWidth(node, i);
            if(width > max)
                max = width;
        }
        return max;
    }

    int getWidth(Node node, int height){
        if(node == null)
            return 0;
        if(height == 0)
            return 1;
        else if(height > 0)
            return getWidth(node.left, height - 1) + getWidth(node.right, height - 1);
        return 0;
    }

    int height(Node node){
        if (node == null)
            return 0;
        return (1 + Math.max(height(node.left), height(node.right)));
    }
}
