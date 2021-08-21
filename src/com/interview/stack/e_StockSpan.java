package com.interview.stack;

import java.util.Stack;

//nearest greater to left index
public class e_StockSpan {

    public void stockSpan(){

        int price[] = { 2, 10, 130, 5, 140, 150, 80 };
        int S[] = new int[price.length];
        Stack<Integer> st = new Stack<>();  //used to store only array indexes

        for (int i = 0; i < price.length; i++) {
            while (!st.empty() && price[st.peek()] <= price[i])
                st.pop();

            S[i] = st.empty()? i + 1 : i - st.peek();
            st.push(i);
        }

        for(int i=0; i<S.length; i++)
            System.out.print(S[i] + " ");
    }
}
