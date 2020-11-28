package com.interview.tree.width;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int key;
    Node left, right;

    public Node(int key){
        this.key = key;
    }
}

public class TreeWidth {

    public void treeWidth(Node node){       //same as max sum at level
        int width = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()){
            int count = q.size();
            width = Math.max(width, count);

            while (count-- > 0){
                Node temp = q.poll();
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
        }
        System.out.println(width);
    }
}
