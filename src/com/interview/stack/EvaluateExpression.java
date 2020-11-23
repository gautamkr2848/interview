package com.interview.stack;

import java.util.Stack;

public class EvaluateExpression {

    public void evaluateExpression(){
        String s = "[5+{2*(9/3)}]";
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(isANumber(s.charAt(i)))
                operand.push(Character.getNumericValue(s.charAt(i)));
            else if(isAOperator(s.charAt(i)))
                operator.push(s.charAt(i));
        }

        int result = 0;
        while(operator.size() > 0){
            result = evaluate(operator.pop(), operand.pop(), operand.pop());
            operand.push(result);
        }
        System.out.println(result);
    }

    public static Boolean isANumber(Character c){
        if(0 <= Character.getNumericValue(c) && 9 >= Character.getNumericValue(c))
            return true;
        else
            return false;
    }

    public static Boolean isAOperator(Character c){
        if(c =='+' || c == '-' || c == '*' || c == '/')
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
