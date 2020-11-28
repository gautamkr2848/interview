package com.interview.tree.levelOrder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
                1
        2               3           => 4 5 6 2 3 1
    4       5       6
*/

class Node{
    int key;
    Node left, right;

    public Node(int key){
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

public class LevelOrderReverse {

    public void levelOrderReverse(Node node){
        Stack<Node> stk = new Stack<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        while(queue.size() > 0){
            Node temp = queue.poll();
            stk.push(temp);

            if(temp.right != null)
                queue.add(temp.right);
            if(temp.left != null)
                queue.add(temp.left);
        }

        while (!stk.empty()){
            Node data = stk.pop();
            System.out.print(data.key+" ");
        }
    }
}
