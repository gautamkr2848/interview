package com.interview.array;

import java.util.Stack;

public class StockSpan {

    public void stockSpan(){

        int price[] = { 2, 10, 130, 5, 90, 120, 80 };
        int S[] = new int[price.length];
        Stack<Integer> st = new Stack<>();  //used to store only array indexes
        st.push(0);
        S[0] = 1;

        for (int i = 1; i < price.length; i++) {
            // Pop elements from stack while stack is not
            // empty and top of stack is smaller than price[i]
            while (!st.empty() && price[st.peek()] <= price[i])
                st.pop();

            // If stack becomes empty, then price[i] is greater than all elements on left of it, i.e.,
            // price[0], price[1], ..price[i-1]. Else price[i] is greater than elements after top of stack
            S[i] = (st.empty()) ? (i + 1) : (i - st.peek());
            st.push(i);
        }

        for(int i=0; i<S.length; i++)
            System.out.print(S[i] + " ");
    }

    public void stockSpan2(){

        int price[] = { 2, 10, 130, 5, 90, 120, 80 };
        int S[] = new int[price.length];
        S[0] = 1;

        for (int i = 1; i < price.length; i++) {
            S[i] = 1;
            for(int j=i-1; (j>=0) && (price[i] >= price[j]); j--){
                S[i]++;
            }
        }

        for(int i=0; i<S.length; i++)
            System.out.print(S[i] + " ");
    }
}
