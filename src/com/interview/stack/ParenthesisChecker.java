package com.interview.stack;

import java.util.Stack;

public class ParenthesisChecker {

    public Boolean parenthesisChecker(String s){
        Stack<Character> stk = new Stack<>();
        if(s == null || s.length() == 0)
            return Boolean.TRUE;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '{' || current == '(' || current == '[')
                stk.push(current);

            if (current == '}' || current == ')' || current == ']'){
                if (stk.isEmpty())
                    return Boolean.FALSE;
                char top = stk.peek();
                if (current == '}' && top == '{' || current == ')' && top == '(' || current == ']' && top == '[')
                    stk.pop();
                else
                    return Boolean.FALSE;
            }
        }
        return null;
    }
}
