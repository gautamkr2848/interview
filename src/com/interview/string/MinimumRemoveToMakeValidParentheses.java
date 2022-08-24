package com.interview.string;

/*
Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"

Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
 */

public class MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String S) {
        char[] tmp = S.toCharArray();
        int len = S.length(), index = 0, i = 0, j = 0;
        int[] stack = new int[len+1];

        for (; i < len; i++)
            if (tmp[i] == ')')
                if (index > 0)
                    index--;
                else
                    tmp[i] = '_';
            else if (tmp[i] == '(')
                stack[index++] = i;

        for (i = 0, stack[index] = -1, index = 0; j < len; j++)
            if (j == stack[index])
                index++;
            else if (tmp[j] != '_')
                tmp[i++] = tmp[j];

        return new String(tmp, 0, i);
    }
}
