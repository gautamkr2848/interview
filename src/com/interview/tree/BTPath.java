package com.interview.tree;

import java.util.ArrayList;
import java.util.List;

/*
                                1
                  2                             3
           4            5               6               7
                      8   9          10    11
*/

public class BTPath {

    public List<Integer> findPath(Node node, int n) {
        List<Integer> res = new ArrayList<>();
        searchBT(node, n, res);
        return res;
    }

    private boolean searchBT(Node node, int n, List<Integer> path){
        if(node == null)
            return false;

        path.add(node.key);
        if(node.key == n)
            return true;

        if (searchBT(node.left, n, path) || searchBT(node.right, n, path))
            return true;

        path.remove(path.size()-1);
        return false;
    }

}
