package com.interview.graph.disjointSets;

// Two sets are called disjoint sets if they don’t have any element in common, the intersection of sets is a null set.

// A data structure that stores non overlapping or disjoint subset of elements is called disjoint set data structure.
// The disjoint set data structure supports following operations:

        // Adding new sets to the disjoint set.
        // Merging disjoint sets to a single disjoint set using Union operation.
        // Finding representative of a disjoint set using Find operation.
        // Check if two sets are disjoint or not.

// Consider a situation with a number of persons and the following tasks to be performed on them:

// Add a new friendship relation, i.e. a person x becomes the friend of another person y i.e adding new element to a set.
// Find whether individual x is a friend of individual y (direct or indirect friend)

// We are given 10 individuals say, a, b, c, d, e, f, g, h, i, j

// Following are relationships to be added:
// a <-> b
// b <-> d
// c <-> f
// c <-> i
// j <-> e
// g <-> j

// Given queries like whether a is a friend of d or not. We basically need to create following 4 groups and maintain a
// quickly accessible connection among group items:
// G1 = {a, b, d}
// G2 = {c, f, i}
// G3 = {e, g, j}
// G4 = {h}

// Data Structures used are:
// Array: An array of integers is called Parent[]. If we are dealing with N items, i’th element of the array represents
// the i’th item. More precisely, the i’th element of the Parent[] array is the parent of the i’th item. These relationships
// create one or more virtual trees.

// Tree: It is a Disjoint set. If two elements are in the same tree, then they are in the same Disjoint set. The root
// node (or the topmost node) of each tree is called the representative of the set. There is always a single unique
// representative of each set. A simple rule to identify a representative is if ‘i’ is the representative of a set,
// then Parent[i] = i. If i is not the representative of his set, then it can be found by traveling up the tree until
// we find the representative.

// Operations on Disjoint Set Data Structures:
// Find & Union

public class a_UnionFind {

    private int[] parent;

    public a_UnionFind(int size) {
        // Initialize the parent array with each element as its own representative
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

//    private int find2(int i) {
//        if (parent[i] == i)
//            return i;
//        else
//            return find2(parent[i]);
//    }

    // Compressed version
    // Find the representative (root) of the set that includes element i
    private int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]); // Path compression
        }
        return parent[i];
    }

    // Unite (merge) the set that includes element i and the set that includes element j
    public void union(int i, int j) {
        int irep = find(i); // Find the representative of set containing i
        int jrep = find(j); // Find the representative of set containing j

        // Make the representative of i's set be the representative of j's set
        parent[irep] = jrep;
    }

    public static void main(String[] args) {
        int size = 5; // Replace with your desired size
        a_UnionFind uf = new a_UnionFind(size);

        // Perform union operations as needed
        uf.union(1, 2);
        uf.union(3, 4);

        // Check if elements are in the same set
        boolean inSameSet = uf.find(1) == uf.find(2);
        System.out.println("Are 1 and 2 in the same set? " + inSameSet);
    }
}
