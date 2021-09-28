package com.interview.stack;

import java.util.Stack;

public class StackClone {

    public void stackClone(){

        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);

        Stack<Integer> cloned = new Stack<>();
        int i=0;
        while(!st.isEmpty()){

            while(!st.isEmpty())
                cloned.push(st.pop());

            int val = cloned.pop();
            while(cloned.size() > i)
                st.push(cloned.pop());

            cloned.push(val);
            i++;
        }
    }
}
