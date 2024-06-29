package com.interview.greedy;

public class ValidParenthesis {

    public static void main(String[] args) {
        String s = "(*";
        System.out.println(test (s, 0, 0));
    }

    private static boolean test(String s, int index, int count) {
        if(count < 0)
            return false;
        if(index == s.length())
            return count == 0;

        if(s.charAt(index) == '(')
            return test(s, index+1, count+1);
        else if(s.charAt(index) == ')')
            return test(s, index+1, count-1);
        else if(s.charAt(index) == '*')
            return test(s, index+1, count+1) || test(s, index+1, count-1) || test(s, index+1, count);

        return false;
    }

}
