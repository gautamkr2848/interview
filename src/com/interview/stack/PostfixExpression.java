package com.interview.stack;

import java.util.Stack;

public class PostfixExpression {

    public void postfixExpression(){
        String s = "2536+**5/2-";
        int result = 0;
        Stack<Integer> stk = new Stack<>();

        for(int i=0; i<s.length(); i++){
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

    public int evaluate(Character c, int b, int a) {
        switch (c) {
            case '+': return a + b;
            case '-' :return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }
}
