package com.interview.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LongestValidSubString {

    public static void findMaxLen() {
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

    public static void main(String[] args) {
        findMaxLen();
    }

    public static void findMaxValid() {
        String s = "()()(()";
        int count = 0;
        int maxlength = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(')
                count++;
            else if(s.charAt(i) == ')')
                count--;

            if(count == 0)
                maxlength = i+1;

            if(map.containsKey(count)) {
                maxlength = Math.max(maxlength, i- map.get(count) + 1);
            }
            map.put(count, i);
        }

        System.out.println(maxlength);
    }
}
