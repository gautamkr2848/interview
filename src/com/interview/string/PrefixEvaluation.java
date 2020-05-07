package com.interview.string;

import java.util.Stack;

public class PrefixEvaluation {

    public void prefixEvaluation(){
        String s = "-/*2*5+3652";
        int result = 0;
        Stack<Integer> stk = new Stack<>();

        for(int i=s.length() - 1; i>=0; i--){
            if(isANumber(s.charAt(i))){
                stk.push(Character.getNumericValue(s.charAt(i)));
            } else {
                result = evaluate(s.charAt(i), stk.pop(), stk.pop());
                stk.push(result);
            }
        }
        System.out.println(stk.pop());
    }

    public static Boolean isANumber(Character c){
        if(0 <= Character.getNumericValue(c) &&
                9 >= Character.getNumericValue(c))
            return true;
        else
            return false;
    }

    public int evaluate(Character c, int a, int b) {
        switch (c) {
            case '+': return a + b;
            case '-' :return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }
}
