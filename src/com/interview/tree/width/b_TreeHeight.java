package com.interview.tree.width;

import com.interview.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class b_TreeHeight {

    public int treeHeight(Node node){
        if(node == null)
            return 0;
        int leftHeight = treeHeight(node.left);
        int rightHeight = treeHeight(node.right);
        return (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight + 1;
    }

    public void treeHeight_2(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        int height = 0;

        while(!queue.isEmpty()){
            height++;
            int count = queue.size();

            while (count-- > 0){
                Node temp = queue.poll();
                if(temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
        System.out.print("Height of tree is "+ height);
    }

}
