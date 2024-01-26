package com.interview.graph;

public class DisjointSet {

    public int find(int A[],int x) {
        if(A[x] == x) return x;
        return find(A, A[x]);
    }

    public void unionSet(int A[],int X,int Z) {
        int x = find(A, X);
        int z = find(A, Z);

        if(x == z)
            return;
        A[x] = z;
    }
}
