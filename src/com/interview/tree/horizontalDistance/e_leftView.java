package com.interview.tree.horizontalDistance;

import com.interview.tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class e_leftView {

    public void leftView(Node root) {

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            for (int i = 1; i <= q.size(); i++) {      // Traverse all nodes of current level
                Node temp = q.poll();

                if (i == 1)
                    System.out.print(temp.key);

                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
        }
    }
}
