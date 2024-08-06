package com.interview;

import com.interview.tree.Node;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        System.out.println();
    }

    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> curr = new ArrayList<>();
    private static void path(Node node) {

        if(node == null)
            return;

        curr.add(node.key);

        if(node.left == null && node.right == null){
            res.add(curr);
            return;
        }

        path(node.left);
        path(node.right);

        curr.remove(curr.size()-1);
    }
}