package com.interview.graph;

import java.util.ArrayList;

/*
For Input:
5 7
0 1
0 4
1 2
1 3
1 4
2 3
3 4

Your Output:
0-> 1-> 4
1-> 0-> 2-> 3-> 4
2-> 1-> 3
3-> 1-> 2-> 4
4-> 0-> 1-> 3

*/

public class PrintAdjacency {

    public ArrayList<ArrayList<Integer>> printGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();

        for(int i=0; i<V; i++) {
            ArrayList<Integer> tmp=new ArrayList<>();
            tmp.add(i);
            for(Integer j : adj.get(i))
                tmp.add(j);
            list.add(tmp);
        }
        return list;
    }
}
