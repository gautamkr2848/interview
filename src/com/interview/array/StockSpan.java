package com.interview.array;

import java.util.Stack;

public class StockSpan {

    public void stockSpan(){

        int price[] = { 10, 4, 5, 90, 120, 80 };
        int S[] = new int[price.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        S[0] = 1;

        for (int i = 1; i < price.length; i++) {

            while (!st.empty() && price[st.peek()] <= price[i])
                st.pop();

            S[i] = (st.empty()) ? (i + 1) : (i - st.peek());
            st.push(i);
        }

        for(int i=0; i<S.length; i++)
            System.out.print(S[i] + " ");
    }
}
