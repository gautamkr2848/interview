package com.interview.matrix;

import java.util.Stack;

        /*If A knows B, then A can’t be a celebrity. Discard A, and B may be celebrity.
        If A doesn’t know B, then B can’t be a celebrity. Discard B, and A may be celebrity.
        Repeat above two steps till there is only one person.*/

public class CelebrityProblem {

    public int celebrity(int M[][], int n){
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++)
            st.push(i);

        while (st.size() > 1){
            int a = st.pop();
            int b = st.pop();

            if (knows(M, a, b))
                st.push(b);
            else
                st.push(a);
        }

        if(st.empty())
            return -1;

        int c = st.pop();

        // Check if C is actually a celebrity or not
        for (int i = 0; i < n; i++){
            if (i != c && (knows(M, c, i) || !knows(M, i, c)))
                return -1;
        }
        return c;
    }

    private boolean knows(int[][] M, int a, int b){
        return (M[a][b] == 1) ? true : false;
    }
}
