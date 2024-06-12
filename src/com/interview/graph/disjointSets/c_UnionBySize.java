package com.interview.graph.disjointSets;

import java.util.Arrays;

// we need a new array of integers called size[]. The size of this array is the same as the parent array Parent[]. If i
// is a representative of a set, size[i] is the number of the elements in the tree representing the set.

// Now we are uniting two trees (or sets), let’s call them left and right, then in this case it all depends on the size
// of left and the size of right tree (or set).
//
// If the size of left is less than the size of right, then it’s best to move left under right and increase size of right
// by size of left. In the same way, if the size of right is less than the size of left, then we should move right under
// left. and increase size of left by size of right.
// If the sizes are equal, it doesn’t matter which tree goes under the other.

public class c_UnionBySize {

    private int[] Parent;
    private int[] Size;

    public c_UnionBySize(int n) {

        Parent = new int[n];
        Size = new int[n];
        for (int i = 0; i < n; i++) {
            Parent[i] = i;
        }

        Arrays.fill(Size, 1);   // Initialize Size array with 1s
    }

    // Function to find the representative (or the root
    // node) for the set that includes i
    public int find(int i) {
        if (Parent[i] != i) {
            Parent[i] = find(Parent[i]);
        }
        return Parent[i];
    }

    // Unites the set that includes i and the set that
    // includes j by size
    public void unionBySize(int i, int j) {
        int irep = find(i);         // Find the representatives (or the root nodes) for the set that includes i
        int jrep = find(j);

        if (irep == jrep)        // Elements are in the same set, no need to unite anything.
            return;

        int isize = Size[irep];         // Get the size of i’s tree
        int jsize = Size[jrep];         // Get the size of j’s tree

        if (isize < jsize) {        // If i’s size is less than j’s size Then move i under j
            Parent[irep] = jrep;
            Size[jrep] += Size[irep];       // Increment j's size by i's size
        } else {                            // Else if j’s size is less than i’s size Then move j under i
            Parent[jrep] = irep;
            Size[irep] += Size[jrep];       // Increment i's size by j's size
        }
    }

    public static void main(String[] args) {
        int n = 5;
        c_UnionBySize u = new c_UnionBySize(n);

        u.unionBySize(0, 1);
        u.unionBySize(2, 3);
        u.unionBySize(0, 4);

        for (int i = 0; i < n; i++) {
            System.out.println("Element " + i + ": Representative = " + u.find(i));
        }
    }
}
