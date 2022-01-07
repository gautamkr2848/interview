package com.interview.stack.nearest;

import java.util.Stack;

//nearest greater to left index
public class e_StockSpan {

    public void stockSpan(){

        int price[] = { 2, 10, 130, 5, 140, 150, 80 };
        Stack<Integer> st = new Stack<>();  //used to store only array indexes

        for (int i = 0; i < price.length; i++) {
            while (!st.empty() && price[st.peek()] <= price[i])
                st.pop();

            if(st.empty())
                System.out.print(i + 1);
            else
                System.out.print(i-st.peek());

            st.push(i);
        }
    }
}
