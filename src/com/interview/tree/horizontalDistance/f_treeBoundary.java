package com.interview.tree.horizontalDistance;

import com.interview.tree.Node;

import java.util.*;

public class f_treeBoundary {

    public void printBoundary(Node root) {
        if (root == null)
            return;

        if ((root.left == null) && (root.right == null)) {
            System.out.print(root.key);
            return;
        }

        List<Node> list = new ArrayList<>();
        list.add(root);

        Node L = root.left;
        while (L.left != null) {
            list.add(L);
            L = L.left;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if ((temp.left == null) && (temp.right == null))
                list.add(temp);

            if (temp.left != null)
                q.add(temp.left);

            if (temp.right != null)
                q.add(temp.right);
        }

        List<Node> list_r = new ArrayList<>();
        Node R = root.right;
        while (R.right != null) {
            list_r.add(R);
            R = R.right;
        }

        Collections.reverse(list_r);
        list.addAll(list_r);

        for (Node i : list)
            System.out.print(i.key + " ");

    }
}
