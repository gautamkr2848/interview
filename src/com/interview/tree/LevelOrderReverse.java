package com.interview.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderReverse {

    public void levelOrderReverse(Node node){
        Stack<Node> stk = new Stack<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        while(queue.size() > 0){
            Node temp = stk.pop();
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
