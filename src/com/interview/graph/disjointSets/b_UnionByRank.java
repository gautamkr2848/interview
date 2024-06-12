package com.interview.graph.disjointSets;

// First of all, we need a new array of integers called rank[]. The size of this array is the same as the parent array
// Parent[]. If i is a representative of a set, rank[i] is the height of the tree representing the set.

// Now recall that in the Union operation, it doesn’t matter which of the two trees is moved under the other. Now what
// we want to do is minimize the height of the resulting tree. If we are uniting two trees (or sets), let’s call them
// left and right, then it all depends on the rank of left and the rank of right.

// If the rank of left is less than the rank of right, then it’s best to move left under right, because that won’t
// change the rank of right (while moving right under left would increase the height). In the same way, if the rank of
// right is less than the rank of left, then we should move right under left.

// If the ranks are equal, it doesn’t matter which tree goes under the other, but the rank of the result will always be
// one greater than the rank of the trees.

public class b_UnionByRank {

    private int[] parent;
    private int[] rank;

    public b_UnionByRank(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Function to find the representative (or the root
    // node) of a set with path compression
    private int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]); // Path compression
        }
        return parent[i];
    }

    private void unionByRank(int i, int j) {        // Unites the set that includes i and the set that includes j by rank
        // Find the representatives (or the root nodes) for the set that includes i and j
        int irep = find(i);
        int jrep = find(j);

        if (irep == jrep)       // Elements are in the same set, no need to unite anything
            return;

        int irank = rank[irep];     // Get the rank of i's tree
        int jrank = rank[jrep];     // Get the rank of j's tree

        if (irank < jrank)     // If i's rank is less than j's rank then Move i under j
            parent[irep] = jrep;
        else if (jrank < irank)     // Else if j's rank is less than i's rank Move j under i
            parent[jrep] = irep;
        else {      // Else if their ranks are the same Move i under j (doesn't matter which one goes where)
            parent[irep] = jrep;
            rank[jrep]++;       // Increment the result tree's rank by 1
        }
    }

    public static void main(String[] args) {
        int size = 5;
        b_UnionByRank ds = new b_UnionByRank(size);

        // Perform some union operations
        ds.unionByRank(0, 1);
        ds.unionByRank(2, 3);
        ds.unionByRank(1, 3);

        // Find the representative of each element and print
        // the result
        for (int i = 0; i < size; i++) {
            System.out.println("Element " + i + " belongs to the set with representative " + ds.find(i));
        }
    }
}
