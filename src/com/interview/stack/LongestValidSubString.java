package com.interview.stack;

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

    public static void findMaxLen_2(String[] args) {
        String s = "()()()";

        int left = 0, right = 0, max = -1;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(')
                left++;
            else
                right++;

            if(left == right) {
                max = Math.max(max, 2*left);
            } else {
                if(right > left) {
                    left = 0;
                    right = 0;
                }
            }
        }

        left = 0;
        right= 0;
        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i) == '(')
                left++;
            else
                right++;

            if(left == right) {
                max = Math.max(max, 2*left);
            } else {
                if(right < left) {
                    left = 0;
                    right = 0;
                }
            }
        }

        System.out.println(max);
    }
}
