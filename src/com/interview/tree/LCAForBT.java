package com.interview.tree;

import java.util.ArrayList;
import java.util.List;

public class LCAForBT {

    public void lcaBT() {

        Node node = new Node(7);
        node.left = new Node(3);
        node.left.left = new Node(2);
        node.left.right = new Node(4);
        node.right = new Node(11);

        List<Node> path1 = btPath(node, 3);
        List<Node> path2 = btPath(node, 2);

        int i=path1.size();
        int j=path2.size();
        Node prev = null;
        while(true) {
            if(i == 0) {
                prev = path2.get(j);
                break;
            }
            if(j==0) {
                prev = path1.get(i);
                break;
            }

            if(path1.get(--i) == path2.get(--j))
                prev = path1.get(i);
            else {
                prev = (prev);
                break;
            }
        }
        System.out.println(prev.key);
    }

    private List<Node> btPath(Node root, int n) {
        if(root == null) {
            return new ArrayList<>();
        }

        if(root.key == n) {
            List<Node> list = new ArrayList<>();
            list.add(root);
            return list;
        }

        List<Node> llist = btPath(root.left, n);
        if(llist.size() > 0) {
            llist.add(root);
            return llist;
        }

        List<Node> rlist = btPath(root.right, n);
        if(rlist.size() > 0) {
            rlist.add(root);
            return rlist;
        }

        return new ArrayList<>();
    }
}
