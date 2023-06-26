package com.interview.graph;

import java.util.ArrayList;

/*

We can consider this problem as a graph (related to topological sorting) problem. All tasks are nodes of the graph and
if task u is a prerequisite of task v, we will add a directed edge from node u to node v. Now, this problem is equivalent
to detecting a cycle in the graph represented by prerequisites. If there is a cycle in the graph, then it is not possible
to finish all tasks (because in that case there is no any topological order of tasks). Both BFS and DFS can be used to
solve it.

Since pair is inconvenient for the implementation of graph algorithms, we first transform it to a graph. If task u is a
prerequisite of task v, we will add a directed edge from node u to node v.

Prerequisite: Detect Cycle in a Directed Graph

Using DFS For DFS, it will first visit a node, then one neighbor of it, then one neighbor of this neighbor… and so on.
If it meets a node which was visited in the current process of DFS visit, a cycle is detected and we will return false.
Otherwise it will start from another unvisited node and repeat this process till all the nodes have been visited. Note
that you should make two records: one is to record all the visited nodes and the other is to record the visited nodes in
the current DFS visit.

*/

public class prerequiteTasks {

    public void tasks(String args[]) {
        int numTasks = 4;

//        Vector<pair> prerequisites = new Vector<>();
//
//        prerequisites.add(new pair(1, 0));
//        prerequisites.add(new pair(2, 1));
//        prerequisites.add(new pair(3, 2));

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        //convert tasks into adj list

        if (canFinish(numTasks, graph))
            System.out.println("Possible to finish all tasks");
        else
            System.out.println("Impossible to finish all tasks");

    }

    private boolean canFinish(int numTasks, ArrayList<ArrayList<Integer>> graph) {

        boolean onpath[] = new boolean[numTasks];
        boolean visited[] = new boolean[numTasks];

        for (int i = 0; i < numTasks; i++)
            if (!visited[i] && dfs_cycle(graph, i, onpath, visited))
                return false;

        return true;
    }

    private boolean dfs_cycle(ArrayList<ArrayList<Integer>> graph, int node, boolean onpath[], boolean visited[]) {
        if (visited[node])
            return false;
        onpath[node] = visited[node] = true;

        for (int neigh : graph.get(node))
            if (onpath[neigh] || dfs_cycle(graph, neigh, onpath, visited))
                return true;

        return onpath[node] = false;
    }
}
