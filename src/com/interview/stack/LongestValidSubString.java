package com.interview.stack;

import java.util.Stack;

public class LongestValidSubString {

    public void findMaxLen() {
        String str = "()()()";
        int result = 0;

        Stack<Integer> stk = new Stack<>();
        stk.push(-1);

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '(')
                stk.push(i);
            else {
               if (!stk.empty()) {
                   stk.pop();
                   result = Math.max(result, i - (stk.isEmpty() ? 0 : stk.peek()));
               } else
                    stk.push(i);
            }
        }

        System.out.println(result);
    }
}
